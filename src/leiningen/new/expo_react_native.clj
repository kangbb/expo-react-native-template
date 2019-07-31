(ns leiningen.new.expo-react-native
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files sanitize sanitize-ns project-name]]
            [leiningen.core.main :as main]))

(def render (renderer "expo-react-native"))

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
              ["project.clj" (render "project.clj" data)]
              ["resources/assets/icon.png" (render "resources/assets/icon.png" data)]
              ["resources/assets/splash.png" (render "resources/assets/splash.png" data)]
              ["src/{{sanitized}}/core.cljs" (render "src/expo_react_native/core.cljs" data)]
              ["env/prod/{{sanitized}}/prod.cljs" (render "env/prod/expo_react_native/prod.cljs" data)]
              ["env/dev/{{sanitized}}/dev.cljs" (render "env/dev/expo_react_native/dev.cljs" data)]
              ["test/{{sanitized}}/core_test.cljs" (render "test/expo_react_native/core_test.cljs" data)]
              ["LICENSE" (render "LICENSE" data)]
              ["README.md" (render "README.md" data)]
              [".gitignore" (render "gitignore" data)]
             ;; Heroku support
              ["project.clj" (render "project.clj" data)]
              ["app.json" (render "app.json" data)]
              ["package.json" (render "package.json" data)]
              ["babel.config.js" (render "babel.config.js" data)]]]
        args))


(defn expo-react-native
  "FIXME: write documentation"
  [name]
  (main/info "Generating fresh 'lein new' expo-react-native project.")
  (apply ->files (format-files-args name)))
