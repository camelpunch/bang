(ns com.camelpunch.bang.screen
  (:require [com.camelpunch.bang.plottable :refer :all]
            [lanterna.screen :as s]
            [com.stuartsierra.component :as component]
            [clojure.core.async :refer [go go-loop chan <! >!]]))

(def actions
  {:text (fn [lscreen text coords]
           (s/put-string lscreen (first coords) (second coords) text))})

(defrecord Screen []
  component/Lifecycle

  (start [component]
    (println "Starting screen")
    (let [scr (s/get-screen :swing)
          keychan (chan)]
      (s/start scr)

      (go-loop []
               (println "got key:" (<! keychan))
               (recur))

      (go-loop []
               (>! keychan (s/get-key-blocking scr))
               (recur))

      (assoc component :scr scr)))

  (stop [component]
    (println "Stopping screen")
    (s/stop (:scr component))
    component)

  Plottable

  (update [screen items]
    (doseq [item items]
      (let [k (first item)]
        (apply (k actions)
               (concat [(:scr screen)] (rest item)))))
    (s/redraw (:scr screen))))
