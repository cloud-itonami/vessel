# Operator quickstart

**The identity scheme this repository documents is not the one its code emits, and
the letters `IMO` do not appear in any code here.** For a registry whose stated
primary key is a 7-digit IMO number, those are the two facts to establish before
anything else.

17 tracked files: a thin edge facade, a Svelte appview, an actor manifest, and a
`vitest.config.ts` with no tests. Steps marked ✅ were run against this tree on
2026-08-16.

---

## 1. `IMO` is in the prose and nowhere in the code ✅

```bash
git grep -icE 'imo' -- .
#   AGENTS.md:6
#   appview/vessel-registry-v3ss3l01/kotodama.jsonld:1
```

Two files. `AGENTS.md` says "105K merchant vessels (IMO + Lloyd's). Path-based DID
per IMO 7-digit number", and the manifest mentions it once. **No source file
mentions IMO at all**, so there is no parsing of one, no primary-key handling, and
in particular no check-digit validation.

That last point is worth stating plainly because IMO numbers *have* a check digit —
the seventh digit is fixed by the first six under weights 7,6,5,4,3,2 — so a
transposed pair or a mistyped digit is detectable arithmetically. Nothing here
detects it. Whatever eventually stores vessels will accept `9074729` and `9074728`
equally, and only one of those is a valid IMO number.

## 2. ⚠ The documented DID is not the DID the code uses ✅

`AGENTS.md` states the scheme, and the whole cross-actor design rests on it:

> `did:web:vessel.etzhayyim.com:imo:{IMO}` — physical
> `did:web:oil-shipping.etzhayyim.com:tanker:imo:{IMO}` — commercial
> …same IMO, two DIDs

What the code emits:

```bash
git grep -o 'did:web:[a-z0-9.:{}-]*' -- appview/*/src/app.ts appview/*/kotodama.jsonld
#   appview/vessel-registry-v3ss3l01/src/app.ts:did:web:v3ss3l01.etzhayyim.com
#   appview/vessel-registry-v3ss3l01/kotodama.jsonld:did:web:v3ss3l01.etzhayyim.com
git grep -nE 'imo:|:imo|vesselDid' -- appview/
#   (no output)
```

Two differences, not one:

| | documented | in the code |
|---|---|---|
| host | `vessel.etzhayyim.com` | `v3ss3l01.etzhayyim.com` — the nanoid subdomain |
| per-vessel segment | `:imo:{IMO}` | **absent** |

So there is one DID for the service, not one per vessel. `AGENTS.md` declares three
cross-actor joins that depend on a per-vessel identifier — `cargo` on `vesselDid`,
`crew` on `currentVesselDid`, `bunker` on `vesselDid` — and the string `vesselDid`
appears in **no code in this repository**. Those joins have nothing to join on yet.

**The nanoid in the documentation is also wrong.** `AGENTS.md` line 5 says
`nanoid: vessel01`; `kotodama.jsonld` (4 mentions) and `wrangler.jsonc` (3) say
`v3ss3l01`, and so does the running facade. Since the nanoid is the DID's host
label, the documented DID cannot be right even in its host part.

## 3. The facade runs offline ✅

No imports, only `Request`/`Response`. Walked on Node v26.3.0, where
`--experimental-strip-types` is a no-op (default from Node 23) and required on
22.6–22.x:

```bash
cat > /tmp/vwalk.mjs <<'EOF'
const app = (await import(process.argv[2])).default;
for (const [l, req] of [
  ["GET /health", new Request("https://vessel.etzhayyim.com/health")],
  ["GET /nope  ", new Request("https://vessel.etzhayyim.com/nope")],
  ["bad json   ", new Request("https://vessel.etzhayyim.com/xrpc/com.etzhayyim.apps.vessel.getVessel",
                              { method: "POST", body: "{not json" })],
]) { const r = await app.fetch(req, {}); console.log(l, "->", r.status, (await r.text()).slice(0,100)); }
EOF

node --experimental-strip-types /tmp/vwalk.mjs \
  "$PWD/appview/vessel-registry-v3ss3l01/src/app.ts"
```

Actual output:

```
GET /health -> 200 {"ok":true,"actor":"did:web:v3ss3l01.etzhayyim.com","nanoid":"v3ss3l01", ...
GET /nope   -> 404 {"error":"NotFound","message":"vessel not found"}
bad json    -> 400 {"error":"InvalidJson"}
```

The `/health` body is where §2's discrepancy is easiest to see: it reports the
service DID, and there is no vessel in it.

## 4. ⚠ And this facade is not what deploys

The pattern common to the cohort:

```bash
grep '"main"' appview/*/wrangler.jsonc
#     "main": "svelte/.svelte-kit/cloudflare/_worker.js",
rg -c health appview/*/svelte/src/          # no match
```

`/health` answers only in the file above, which `wrangler` does not deploy. Across
the 329 appview repositories carrying a `wrangler.jsonc`, 89 are in that position
and 58 have request validation only there; the standing check is
`:verify-appview-facade` in `manifest/orgs-detectors.edn`. **Do not health-check
this service at `/health`.**

## 5. A test runner with no tests ✅

```bash
git ls-files | grep -cE '\.(test|spec)\.'   # 0
```

`appview/vessel-registry-v3ss3l01/vitest.config.ts` exists and there is not one test
file in the repository. From a file listing this reads like a tested repository.

## 6. So the useful next step

Not to run this — §3 is the whole of what runs. It is to settle which identity
scheme is real, because §2 is not a documentation slip: if the per-IMO DID is
intended, then the code emits the wrong DID and the three cross-actor joins are
unimplemented; if the service DID is intended, then `AGENTS.md`'s "same IMO, two
DIDs" design and its join table describe something else. That is the app owner's
call and this document does not make it.

`migration.edn` is the `/v1` schema with an `:identity/:allowed-additions`
allow-list, which this document has been added to.
