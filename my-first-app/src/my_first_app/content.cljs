(ns my-first-app.content
  (:require ["react-native" :as rn]
            [reagent.core :as r]))

(defn styles [key]
  (let [data
        {:container {:flex            1
                     :backgroundColor "#ffffff"
                     :alignItems      "center"
                     :justifyContent  "center"}
         :main      {:fontSize   40
                     :fontWeight "bold"}}]
    (get data key)))


(defn content []
  (r/as-element [:> rn/View {:style (styles :container)}
                 [:> rn/Text {:style (styles :main)} "CONTENT"]]))
