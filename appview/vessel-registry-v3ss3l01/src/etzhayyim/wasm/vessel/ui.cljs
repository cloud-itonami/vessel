(ns etzhayyim.wasm.vessel.ui
  "Reagent views for the vessel appview card. Structural chrome via
  appkit.core / kotoba-ui.core; interactive controls hand-rolled with
  (ui/class-name ...)."
  (:require [appkit.core :as appkit]
            [kotoba-ui.core :as ui]
            [etzhayyim.wasm.vessel.state :as state]))

(defn fact-row [label value]
  [:div {:style {:border "1px solid var(--kotoba-border, #2b3948)"
                 :border-radius "8px"
                 :background "var(--kotoba-surface, #171f28)"
                 :padding "14px"}}
   [:span {:style {:display "block" :margin-bottom "8px"
                   :font-size "12px" :color "#96a6b8"}}
    label]
   [:strong {:style {:overflow-wrap "anywhere"}} value]])

(defn panel
  ([title body] (panel title body {}))
  ([title body opts]
   (appkit/panel
     [:div
      [:h2 {:style {:margin "0 0 12px" :font-size "13px"
                    :text-transform "uppercase" :color "#96a6b8"}}
       title]
      body]
     opts)))

(defn app-view [_]
  (let [{:keys [title project name kind route-count routes vars xrpc relative-path]} state/app]
    [:main {:style {:min-height "100vh" :padding "24px"
                    :background "#11161d" :color "#eef4f8"
                    :font-family "Inter, ui-sans-serif, system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', sans-serif"}}
     [:section {:style {:margin-bottom "18px"}}
      [:p {:style {:margin "0 0 8px" :font-size "12px" :font-weight "700"
                   :text-transform "uppercase" :color "#96a6b8"}}
       (str "Cloudflare " kind)]
      [:h1 {:style {:margin 0 :font-size "clamp(28px, 5vw, 48px)" :line-height "1.05"}}
       title]
      [:span {:style {:display "block" :margin-top "8px"
                      :font-family "ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas, monospace"
                      :overflow-wrap "anywhere" :color "#96a6b8"}}
       name]]
     [:section {:style {:display "grid"
                        :grid-template-columns "repeat(3, minmax(0, 1fr))"
                        :gap "12px" :margin-bottom "12px"}}
      (fact-row "Project" project)
      (fact-row "Routes" (str route-count))
      (fact-row "XRPC" (if xrpc "enabled" "not configured"))]
     (panel "Public Routes"
            (if (seq routes)
              [:ul {:style {:display "grid" :gap "8px" :margin 0 :padding 0
                            :list-style "none"}}
               (for [r routes]
                 ^{:key r} [:li {:style {:border "1px solid #263443" :border-radius "6px"
                                         :background "#101720" :padding "9px 10px"
                                         :font-family "ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas, monospace"
                                         :overflow-wrap "anywhere"}}
                            r])]
              [:p {:style {:margin 0 :color "#96a6b8"}}
               "No public route is declared next to this app surface."]))
     (panel "Runtime Bindings"
            (if (seq vars)
              [:ul {:style {:display "grid" :gap "8px" :margin 0 :padding 0
                            :list-style "none"
                            :grid-template-columns "repeat(auto-fit, minmax(180px, 1fr))"}}
               (for [k vars]
                 ^{:key k} [:li {:style {:border "1px solid #263443" :border-radius "6px"
                                         :background "#101720" :padding "9px 10px"
                                         :font-family "ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas, monospace"
                                         :overflow-wrap "anywhere"}}
                            k])]
              [:p {:style {:margin 0 :color "#96a6b8"}}
               "No public vars are declared in the nearest wrangler config."]))
     (panel "Source"
            [:p {:style {:margin 0
                         :border "1px solid #263443" :border-radius "6px"
                         :background "#101720" :padding "9px 10px"
                         :font-family "ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas, monospace"
                         :overflow-wrap "anywhere"}}
             relative-path])]))
