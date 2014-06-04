(ns bang.core)

(def player \|)
(def space \space)

(def parse vec)
(def dump clojure.string/join)

(defn move-player-x [board direction-fn]
  (let [position (.indexOf board player)]
    (assoc board
      position space
      (direction-fn position) player)))

(defn next-game-state
  [raw-board input]
  (cond
   (= input ["R"]) (-> raw-board
                       parse
                       (move-player-x inc)
                       dump)
   (= input ["L"]) (-> raw-board
                       parse
                       (move-player-x dec)
                       dump)
   :else raw-board))
