(ns bang.core)

(def player \|)
(def space \space)

(def dump (partial map clojure.string/join))

(defn new-position [row old-position]
  (mod (inc old-position) (count row)))

(defn move-left-in-row [row]
  (let [n (count row)]
    (->> row
         cycle
         (drop 1)
         (take n))))

(defn move-left [board]
  (->> board (map vec) (map move-left-in-row)))

(defn move-right [board]
  (->> board (map reverse) move-left (map reverse)))

(defn next-game-state [board input]
  (dump (cond
         (= input "R") (move-right board)
         (= input "L") (move-left board)
         :else board)))
