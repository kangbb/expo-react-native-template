(ns leiningen.new.expo-react-native
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files sanitize sanitize-ns project-name raw-resourcer]]
            [leiningen.core.main :as main]))

(def render (renderer "expo-react-native"))
(def raw (raw-resourcer "expo-react-native"))
; template-data "Used in function expo-react-native as the first arguments  to ->files"
(defn template-data [name]
  {:full-name name
   :name (project-name name)
   :project-goog-module (sanitize (sanitize-ns name))
   :project-ns (sanitize-ns name)
   :sanitized (name-to-path name)})


; format-files-args "Used in function expo-react-native" as the second arguments  to ->files 
(defn format-files-args [name]
  (let [data (template-data name)
        args [data
              ["resources/assets/icon.png" (raw "resources/assets/icon.png")]
              ["resources/assets/splash.png" (raw "resources/assets/splash.png")]
              ["resources/assets/home.png" (raw "resources/assets/home.png")]
              ["resources/assets/content.png" (raw "resources/assets/content.png")]
              ["resources/assets/user.png" (raw "resources/assets/user.png")]
              ["src/{{sanitized}}/core.cljs" (render "src/expo_react_native/core.cljs" data)]
              ["src/{{sanitized}}/content.cljs" (render "src/expo_react_native/content.cljs" data)]
              ["src/{{sanitized}}/user.cljs" (render "src/expo_react_native/user.cljs" data)]
              ["src/{{sanitized}}/components/tabbar.cljs" (render "src/expo_react_native/components/tabbar.cljs" data)]
              ["src/{{sanitized}}/util/keep_awake.cljs" (render "src/expo_react_native/util/keep_awake.cljs" data)]
              ["src/{{sanitized}}/util/register_app.cljs" (render "src/expo_react_native/util/register_app.cljs" data)]
              ["env/prod/{{sanitized}}/prod.cljs" (render "env/prod/expo_react_native/prod.cljs" data)]
              ["env/dev/{{sanitized}}/dev.cljs" (render "env/dev/expo_react_native/dev.cljs" data)]
              ["test/{{sanitized}}/core_test.cljs" (render "test/expo_react_native/core_test.cljs" data)]
              ["LICENSE" (render "LICENSE" data)]
              ["README.md" (render "README.md" data)]
              [".gitignore" (render "gitignore" data)]
              ["project.clj" (render "project.clj" data)]
              ["app.json" (render "app.json" data)]
              ["package.json" (render "package.json" data)]
              ["App.js" (render "App.js" data)]
              ["babel.config.js" (render "babel.config.js" data)]]]
        args))


(defn expo-react-native
  "FIXME: write documentation"
  [name]
  (main/info "Generating fresh 'lein new' expo-react-native project.")
  (apply ->files (format-files-args name)))
