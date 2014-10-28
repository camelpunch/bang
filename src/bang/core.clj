(ns bang.core)

(def player \|)
(def space \space)

(def parse (partial map vec))
(def dump (partial map clojure.string/join))

(defn move-x-in-row [row move]
  (let [old-position (.indexOf row player)]
    (if (= old-position -1)
      row
      (let [proposed-position (move old-position)
            new-position (cond
                          (= proposed-position -1) (dec (count row))
                          (>= proposed-position (count row)) 0
                          :else proposed-position
                          )]
        (assoc row
          old-position space
          new-position player)))))

(defn move-x [board move]
  (map (fn [row] (move-x-in-row row move)) board))

(defn next-game-state [raw-board input]
  (cond
   (= input "R") (dump (move-x (parse raw-board) inc))
   (= input "L") (dump (move-x (parse raw-board) dec))
   :else raw-board))
