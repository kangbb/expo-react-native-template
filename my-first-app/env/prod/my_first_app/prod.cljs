(ns my-first-app.prod
  (:require [my-first-app.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
