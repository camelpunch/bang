(ns bang.core-test
  (:require [clojure.test :refer :all]
            [bang.core :refer :all]))

(def some-game-state identity)

(deftest player-movement
  (testing "player moves right when input is R"
    (is (= (some-game-state "  |")
           (next-game-state " | "
                            ["R"]))))
  (testing "player moves left when input is L"
    (is (= (some-game-state "|  ")
           (next-game-state " | "
                            ["L"]))))
  (testing "player movement wraps on left side"
    (is (= (some-game-state "      |")
           (next-game-state "|      "
                            ["L"]))))
  (testing "player movement wraps on right side"
    (is (= (some-game-state "|      ")
           (next-game-state "      |"
                            ["R"])))))
