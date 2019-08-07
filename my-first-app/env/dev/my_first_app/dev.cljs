(ns my-first-app.dev
  (:require [my-first-app.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
