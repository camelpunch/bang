(ns bang.core-test
  (:require [clojure.test :refer :all]
            [bang.core :refer :all]))

(deftest player-movement
  (testing "player moves right when input is R"
    (is (= ["   "
            "  |"
            "   "]
           (next-game-state ["   "
                             " | "
                             "   "]
                            "R"))))
  (testing "player moves left when input is L"
    (is (= ["|  "]
           (next-game-state [" | "]
                            "L"))))
  (testing "player moves up when input is U"
    (is (= [" |  "
            "    "
            "    "]
           (next-game-state ["    "
                             " |  "
                             "    "]
                            "U"))))
  (testing "player moves down when input is D"
    (is (= ["     "
            "     "
            "    |"]
           (next-game-state ["     "
                             "    |"
                             "     "]
                            "D"))))
  (testing "player movement wraps on left side"
    (is (= ["      |"]
           (next-game-state ["|      "]
                            "L"))))
  (testing "player movement wraps on right side"
    (is (= ["       "
            "|      "
            "       "]
           (next-game-state
            ["       "
             "      |"
             "       "]
            "R")))))
