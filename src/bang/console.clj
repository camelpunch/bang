(ns bang.console
  (:import jline.Terminal)
  (:gen-class)
  (:require [bang.core :refer [next-game-state]]
            [clojure.string :refer [join replace-first]]))

(def game (atom nil))

(defn char-to-input [char]
  (cond
   (= char 65) "U"
   (= char 66) "D"
   (= char 67) "R"
   (= char 68) "L"
   :else nil))

(defn show-game [game-state]
  (print (join "\n" game-state))
  (flush))

(defn -main [& args]
  (let [term (Terminal/getTerminal)
        empty-board (repeat (.getTerminalHeight term)
                            (apply str (repeat (.getTerminalWidth term) \space)))
        line-with-player (replace-first (first empty-board) #"." "|")
        board-with-player (concat [line-with-player] (rest empty-board))]
    (reset! game board-with-player)
    (show-game @game)
    (while true
      (let [char (.readCharacter term System/in)]
        (show-game
         (swap! game next-game-state
                (char-to-input char)))))))
