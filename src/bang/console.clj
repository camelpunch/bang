(ns bang.console
  (:import jline.Terminal)
  (:gen-class)
  (:require [bang.core :refer [next-game-state]]))

(def game (atom "              |              "))

(defn char-to-input [char]
  (cond
   (= char 68) ["L"]
   (= char 67) ["R"]
   :else nil))

(defn show-game [game-state]
  (print "\r" game-state "\r")
  (flush))

(defn -main [& args]
  (let [term (Terminal/getTerminal)]
    (show-game @game)
    (while true
      (let [char (.readCharacter term System/in)]
        (show-game
         (swap! game next-game-state
                (char-to-input char)))))))
