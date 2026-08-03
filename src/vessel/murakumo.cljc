(ns vessel.murakumo
  "Pure cljc actor boundary generated from manifest migration scaffold."
  (:require [clojure.string :as str]))

(def actor-did
  "did:web:vessel.etzhayyim.com")

(def common-gates
  [:council-charter-attestation
   :no-platform-held-key-baseline
   :no-probing-baseline
   :murakumo-only-inference-baseline
   :did-primary-baseline
   :append-only-gate-baseline
   :kotoba-only-substrate-baseline])

(defn collection
  [name]
  (str "com.etzhayyim.vessel." name))

(def cell-specs {
  :getship {:legacy-cell "com-etzhayyim-apps-vessel-registry-getShip"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "getship")]
     :required-gates common-gates
     :trigger "manifest cell getship"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :listships {:legacy-cell "com-etzhayyim-apps-vessel-registry-listShips"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "listships")]
     :required-gates common-gates
     :trigger "manifest cell listships"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :searchships {:legacy-cell "com-etzhayyim-apps-vessel-registry-searchShips"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "searchships")]
     :required-gates common-gates
     :trigger "manifest cell searchships"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :getvesselposition {:legacy-cell "com-etzhayyim-apps-vessel-tracking-getVesselPosition"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "getvesselposition")]
     :required-gates common-gates
     :trigger "manifest cell getvesselposition"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :listvesselsinarea {:legacy-cell "com-etzhayyim-apps-vessel-tracking-listVesselsInArea"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "listvesselsinarea")]
     :required-gates common-gates
     :trigger "manifest cell listvesselsinarea"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :getpositionhistory {:legacy-cell "com-etzhayyim-apps-vessel-tracking-getPositionHistory"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "getpositionhistory")]
     :required-gates common-gates
     :trigger "manifest cell getpositionhistory"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :listvoyages {:legacy-cell "com-etzhayyim-apps-vessel-voyage-listVoyages"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "listvoyages")]
     :required-gates common-gates
     :trigger "manifest cell listvoyages"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :listportcalls {:legacy-cell "com-etzhayyim-apps-vessel-voyage-listPortCalls"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "listportcalls")]
     :required-gates common-gates
     :trigger "manifest cell listportcalls"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :getvesselchain {:legacy-cell "com-etzhayyim-apps-vessel-voyage-getVesselChain"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "getvesselchain")]
     :required-gates common-gates
     :trigger "manifest cell getvesselchain"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :getdashboard {:legacy-cell "com-etzhayyim-apps-vessel-getDashboard"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "getdashboard")]
     :required-gates common-gates
     :trigger "manifest cell getdashboard"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :health {:legacy-cell "com-etzhayyim-apps-vessel-health"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "health")]
     :required-gates common-gates
     :trigger "manifest cell health"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :get {:legacy-cell "com-etzhayyim-apps-vessel-coverage-get"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "get")]
     :required-gates common-gates
     :trigger "manifest cell get"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :shinkaevolution {:legacy-cell "com-etzhayyim-apps-standard-shinkaEvolution"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "shinkaevolution")]
     :required-gates common-gates
     :trigger "manifest cell shinkaevolution"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :shinkaknowledge {:legacy-cell "com-etzhayyim-apps-standard-shinkaKnowledge"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "shinkaknowledge")]
     :required-gates common-gates
     :trigger "manifest cell shinkaknowledge"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :shinka {:legacy-cell "shinka"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "shinka")]
     :required-gates common-gates
     :trigger "manifest cell shinka"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :koji {:legacy-cell "koji"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "koji")]
     :required-gates common-gates
     :trigger "manifest cell koji"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :kyumei {:legacy-cell "kyumei"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "kyumei")]
     :required-gates common-gates
     :trigger "manifest cell kyumei"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :domain-knowledge {:legacy-cell "domain-knowledge"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "domain-knowledge")]
     :required-gates common-gates
     :trigger "manifest cell domain-knowledge"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :ship {:legacy-cell "com-etzhayyim-apps-vessel-ship"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "ship")]
     :required-gates common-gates
     :trigger "manifest cell ship"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :shipowner {:legacy-cell "com-etzhayyim-apps-vessel-shipowner"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "shipowner")]
     :required-gates common-gates
     :trigger "manifest cell shipowner"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :shipregistry {:legacy-cell "com-etzhayyim-apps-vessel-shipRegistry"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "shipregistry")]
     :required-gates common-gates
     :trigger "manifest cell shipregistry"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :vesselposition {:legacy-cell "com-etzhayyim-apps-vessel-vesselPosition"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "vesselposition")]
     :required-gates common-gates
     :trigger "manifest cell vesselposition"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :voyage {:legacy-cell "com-etzhayyim-apps-vessel-voyage"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "voyage")]
     :required-gates common-gates
     :trigger "manifest cell voyage"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :portcall {:legacy-cell "com-etzhayyim-apps-vessel-portCall"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "portcall")]
     :required-gates common-gates
     :trigger "manifest cell portcall"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :ownerlink {:legacy-cell "com-etzhayyim-apps-vessel-ownerLink"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "ownerlink")]
     :required-gates common-gates
     :trigger "manifest cell ownerlink"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :port {:legacy-cell "com-etzhayyim-apps-maps-port"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "port")]
     :required-gates common-gates
     :trigger "manifest cell port"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :entity {:legacy-cell "com-etzhayyim-legalEntity-entity"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "entity")]
     :required-gates common-gates
     :trigger "manifest cell entity"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
})

(defn safe-rkey
  [s]
  (let [clean (-> (str s)
                  (str/replace #"^did:web:" "")
                  (str/replace #"[^A-Za-z0-9._~-]" "-"))]
    (if (str/blank? clean) "unknown" clean)))

(defn gate-value
  [attestations gate]
  (or (get attestations gate)
      (get attestations (name gate))
      (when (set? attestations) (attestations gate))
      (when (set? attestations) (attestations (name gate)))))

(defn missing-gates
  [spec attestations]
  (->> (:required-gates spec)
       (remove #(boolean (gate-value attestations %)))
       vec))

(defn put-record-effect
  [collection rkey record]
  {:op :mst/put-record
   :actor actor-did
   :collection collection
   :rkey rkey
   :record record})

(defn records-for
  [spec {:keys [records record computed-at request-id]
         :as input}]
  (let [input-records (cond
                        (map? records) records
                        (some? record) {0 record}
                        :else {})
        base {:actorDid actor-did
              :computedAt computed-at
              :legacyCell (:legacy-cell spec)
              :phase (:phase spec)
              :requestId request-id
              :actorBoundary "cljc-migration-scaffold"
              :scaffold true
              :constitutionalStatus "attested-plan"}]
    (map-indexed
     (fn [idx coll]
       (let [record* (merge {:$type coll}
                            base
                            (or (get input-records coll)
                                (get input-records idx)
                                {}))
             rkey (safe-rkey (or (:rkey record*)
                                 (get record* "rkey")
                                 (:tid record*)
                                 request-id
                                 (str (:legacy-cell spec) "-" idx)))]
         {:collection coll
          :record record*
          :rkey rkey}))
     (:collections spec))))

(defn cell-plan
  [cell-key {:keys [attestations] :as input}]
  (let [spec (get cell-specs cell-key)]
    (when-not spec
      (throw (ex-info "unknown cell" {:cell cell-key})))
    (let [missing (missing-gates spec attestations)]
      (merge
       {:cell cell-key
        :legacy-cell (:legacy-cell spec)
        :actor actor-did
        :phase (:phase spec)
        :murakumo-node (:murakumo-node spec)
        :trigger (:trigger spec)
        :ceiling (:ceiling spec)
        :required-gates (:required-gates spec)
        :missing-gates missing}
       (if (seq missing)
         {:status :blocked
          :effects []}
         (let [planned-records (records-for spec input)]
           {:status :ready
            :records (vec planned-records)
            :effects (mapv (fn [{:keys [collection record rkey]}]
                             (put-record-effect collection rkey record))
                           planned-records)}))))))

(defn all-cell-plans
  [input]
  (into {}
        (map (fn [cell-key] [cell-key (cell-plan cell-key input)]))
        (keys cell-specs)))
