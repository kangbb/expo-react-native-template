(ns my-first-app.components.tabbar
  (:require ["react-native" :as rn]
            [reagent.core :as r]))

(defn judge [condition result-a result-b]
  (if condition result-a result-b))

(defn tab-bar-item [color focused select-image normal-image]
  (r/as-element
   [:> rn/Image {:style {:tintColor color :width 25 :height 25}
                 :source (judge focused select-image normal-image)}]))
