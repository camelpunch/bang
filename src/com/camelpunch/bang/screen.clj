(ns com.camelpunch.bang.screen
  (:require [lanterna.screen :as s]
            [com.stuartsierra.component :as component]))

(defrecord Screen []
  component/Lifecycle

  (start [component]
    (println "Starting screen")
    (let [lanterna-screen (s/get-screen :swing)]
      (s/start lanterna-screen)
      (assoc component :lanterna-screen lanterna-screen)))

  (stop [component]
    (println "Stopping screen")
    (s/stop (:lanterna-screen component))
    component))
