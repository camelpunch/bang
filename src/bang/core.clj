(ns bang.core
  (:require [clojure.string :refer [join]]))

(def player \|)
(def space \space)

(defn read-board [raw-board]
  (vec raw-board))

(defn write-board [vecboard]
  (join vecboard))

(defn move-player-right [board]
  (let [position (.indexOf board player)]
    (assoc board
      position space
      (inc position) player)))

(defn next-game-state
  [raw-board input]
  (if (= input ["R"])
    (-> raw-board
        read-board
        move-player-right
        write-board)
    raw-board))
