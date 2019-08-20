(defproject {{full-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  
  :dependencies [[thheller/shadow-cljs "2.8.47"]
                 [reagent "0.8.1"]]
  
  :plugins [[lein-shadow "0.1.4"]]

  :shadow-cljs {:soruce-paths ["src",
                               "env/dev"
                               "env/prod"
                               "test"]
                :builds
                {:app
                 {:target :react-native
                  :output-dir "target"
                  :init-fn {{project-ns}}.core/init
                  :compiler-options {:infer-externs :auto}
                  :devtools {:autoload true
                             :preloads [{{project-ns}}.util.keep-awake]}}}
                :nrepl {:port 9600}} 
)