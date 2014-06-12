(ns com.camelpunch.bang.core
  (:require [com.camelpunch.bang.plottable :refer :all]
            [com.stuartsierra.component :as component]))

(defrecord Game []
  component/Lifecycle

  (start [component]
    (println "Starting game")
    (let [screen (:screen component)]
      (update screen
              [[:text "Hello, world!" [10 5]]]))
    component)

  (stop [component]
    (println "Stopping game")
    component))
