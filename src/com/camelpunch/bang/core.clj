(ns com.camelpunch.bang.core
  (:require [com.camelpunch.bang.plottable :refer :all]
            [com.stuartsierra.component :as component]))

(defrecord Game []
  component/Lifecycle

  (start [component]
    (println "Starting game")
    (let [screen (:screen component)]
      (plot-text screen 10 5 "Hello, world!")
      (update screen))
    component)

  (stop [component]
    (println "Stopping game")
    component))
