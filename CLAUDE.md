# etzhayyim-project-vessel — IMO Vessel Registry

> **T1 Logical Actor**: Manifest-driven (`20-actors/vessel/actor-manifest.jsonld`).

`vessel.etzhayyim.com` (nanoid: `vessel01`) — Physical vessel asset registry. 105K merchant vessels (IMO + Lloyd's). Path-based DID per IMO 7-digit number.

## Role

vessel = **physical asset perspective** (船籍登録、IMO 番号主キー)。oil-shipping.tanker = **commercial wrapper** (用船・operator・dark-fleet flag)。同一 IMO で 2 重 DID 設計:
- `did:web:vessel.etzhayyim.com:imo:{IMO}` — physical
- `did:web:oil-shipping.etzhayyim.com:tanker:imo:{IMO}` — commercial

## cross-actor
- `cargo` — manifest 結合 (vesselDid)
- `crew` — STCW seafarer assignment (currentVesselDid)
- `bunker` — fuel supply event (vesselDid)
- `port` — port call event
- `marine-insurance` — Hull/P&I policy (insuredDid)
- `oil-shipping` — IMO-linked commercial wrapper

## Design
→ ADR-0013: 海運 + エネルギー クラスタ cross-actor (vessel ↔ oil-shipping 2 重 DID 設計)
