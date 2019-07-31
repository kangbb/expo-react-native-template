(defproject {{full-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  
  :dependencies [[thheller/shadow-cljs "2.8.41"]
                 [reagent "0.8.1"]]
  
  :plugins [[lein-shadow "0.1.4"]]

  :shadow-cljs {
    :soruce-paths [
      "src",
      "env/dev"
      "env/prod"
      "test"
    ]
    :builds
    {:app
      {:target :react-native
        :init-fn {{project-ns}}.core/init
        :output-dir "target"
        :devtools {:autoload true
                  :preloads [shadow.expo.keep-awake]}}}
  } 
)