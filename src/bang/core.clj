(ns bang.core)

(def player \|)
(def space \space)

(def dump (partial map clojure.string/join))

(defn new-position [row old-position]
  (mod (inc old-position) (count row)))

(defn move-right-in-row [row]
  (let [n (count row)]
    (->> row
         cycle
         (drop (dec n))
         (take n))))

(defn move-right [board]
  (->> board (map vec) (map move-right-in-row)))

(defn move-left [board]
  (->> board (map reverse) move-right (map reverse)))

(defn next-game-state [board input]
  (dump (cond
         (= input "R") (move-right board)
         (= input "L") (move-left board)
         :else board)))
