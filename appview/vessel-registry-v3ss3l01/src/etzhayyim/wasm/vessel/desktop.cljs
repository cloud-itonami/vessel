(ns etzhayyim.wasm.vessel.desktop
  "Reagent mount point for the vessel appview page."
  (:require [reagent.dom.client :as rdc]
            [etzhayyim.wasm.vessel.ui :as ui]))

(defonce root (rdc/create-root (js/document.getElementById "app")))

(defn ^:dev/after-load render! []
  (rdc/render root [ui/app-view nil]))

(defn init! []
  (render!))
