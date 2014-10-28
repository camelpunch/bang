(ns bang.core)

(defn move-left-in-row [row]
  (let [n (count row)]
    (->> row
         cycle
         (drop 1)
         (take n))))

(defn transpose [board]
  (apply map list board))

(defn move-left [board]
  (->> board (map vec) (map move-left-in-row)))

(defn move-right [board]
  (->> board (map reverse) move-left (map reverse)))

(defn move-up [board]
  (-> board transpose move-left transpose))

(defn move-down [board]
  (-> board transpose move-right transpose))

(defn next-game-state [board input]
  (map clojure.string/join
       (cond
        (= input "R") (move-right board)
        (= input "L") (move-left board)
        (= input "U") (move-up board)
        (= input "D") (move-down board)
        :else board)))
