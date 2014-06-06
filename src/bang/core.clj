(ns bang.core)

(def player \|)
(def space \space)

(def parse vec)
(def dump clojure.string/join)

(defn move-player-x [board move]
  (let [old-position (.indexOf board player)
        proposed-position (move old-position)
        new-position (cond
                      (= proposed-position -1) (dec (count board))
                      (>= proposed-position (count board)) 0
                      :else proposed-position
                      )]
    (assoc board
      old-position space
      new-position player)))

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
