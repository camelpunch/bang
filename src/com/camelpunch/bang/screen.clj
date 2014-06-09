(ns com.camelpunch.bang.screen
  (:require [com.camelpunch.bang.plottable :refer :all]
            [lanterna.screen :as s]
            [com.stuartsierra.component :as component]))

(defrecord Screen []
  component/Lifecycle

  (start [component]
    (println "Starting screen")
    (let [lscreen (s/get-screen :swing)]
      (s/start lscreen)
      (assoc component :lscreen lscreen)))

  (stop [component]
    (println "Stopping screen")
    (s/stop (:lscreen component))
    component)

  Plottable

  (plot-text [screen x y text]
    (s/put-string (:lscreen screen) x y text))

  (update [screen]
    (s/redraw (:lscreen screen))))
