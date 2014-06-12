(ns com.camelpunch.bang.screen
  (:require [com.camelpunch.bang.plottable :refer :all]
            [lanterna.screen :as s]
            [com.stuartsierra.component :as component]))

(def actions
  {:text (fn [lscreen text coords]
           (s/put-string lscreen (first coords) (second coords) text))})

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

  (update [screen items]
    (doseq [item items]
      (let [k (first item)]
        (apply (k actions)
               (concat [(:lscreen screen)] (rest item)))))
    (s/redraw (:lscreen screen))))
