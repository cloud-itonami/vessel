(ns etzhayyim.wasm.vessel.state
  "UI state for the vessel appview surface (static app metadata card).")

(def app
  {:title "Vessel Registry V3ss3l01"
   :project "etzhayyim-project-vessel"
   :name "vessel-registry-v3ss3l01"
   :kind "appview"
   :route-count 0
   :routes []
   :vars []
   :xrpc true
   :relative-path "60-apps/etzhayyim-project-vessel/appview/vessel-registry-v3ss3l01"})

(defonce ^:private db (atom {:view :app}))

(defn current-view [] @db)

(defn set-view! [v]
  (swap! db assoc :view v))
