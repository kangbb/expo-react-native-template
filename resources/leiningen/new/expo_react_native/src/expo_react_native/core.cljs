(ns {{project-ns}}.core
  (:require [reagent.core :as r]
            ["react-native" :as rn]
            [{{project-ns}}.content :as content]
            [{{project-ns}}.user :as my]
            [{{project-ns}}.components.tabbar :as tabbar]
            [{{project-ns}}.util.register-app :as register-app]
            ["react-navigation" :as router]))

(defn styles [key]
  (let [data
        {:container {:flex            1
                     :backgroundColor "#ffffff"
                     :alignItems      "center"
                     :justifyContent  "center"}
         :main      {:fontSize   40
                     :fontWeight "bold"}}]
    (get data key)))


(defn home-screen []
  (r/as-element [:> rn/View {:style (styles :container)}
                 [:> rn/Text {:style (styles :main)} "HOME"]]))

(defn tab-navigator []
  (router/createBottomTabNavigator
   ^js (clj->js
        {:HomeScreen
         {:screen home-screen
          :navigationOptions (fn [^js navigation]
                               ^js (clj->js
                                    {:tabBarLabel "首页"
                                     :tabBarIcon (fn [^js obj]
                                                   (tabbar/tab-bar-item
                                                    (.-tintColor obj)
                                                    (.-focused obj)
                                                    (js/require "../resources/assets/home.png")
                                                    (js/require "../resources/assets/home.png")))}))}
         :Content
         {:screen content/content
          :navigationOptions (fn [{:keys [^js navigation]}]
                               ^js (clj->js
                                    {:tabBarLabel "内容"
                                     :tabBarIcon (fn [^js obj]
                                                   (tabbar/tab-bar-item
                                                    (.-tintColor obj)
                                                    (.-focused obj)
                                                    (js/require "../resources/assets/content.png")
                                                    (js/require "../resources/assets/content.png")))}))}
         :My
         {:screen my/my
          :navigationOptions (fn [{:keys [^js navigation]}]
                               ^js (clj->js
                                    {:tabBarLabel "我的"
                                     :tabBarIcon (fn [^js obj]
                                                   (tabbar/tab-bar-item
                                                    (.-tintColor obj)
                                                    (.-focused obj)
                                                    (js/require "../resources/assets/user.png")
                                                    (js/require "../resources/assets/user.png")))}))}})
   ^js (clj->js
        {:tabBarOptions
         {:activeTintColor "#4CB4E7"
          :inactiveTintColor "#FFEE93"
          :style {:backgroundColor "#FFC09F"}}})))


(def AppContainer (router/createAppContainer (tab-navigator)))

(defn start
  {:dev/after-load true}
  []
  (register-app/render-root (r/as-element [:> AppContainer])))

(defn init []
  (start))