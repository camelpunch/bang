(ns bang.core-test
  (:require [clojure.test :refer :all]
            [bang.core :refer :all]))

(deftest character
  (testing "character moves right when input is a R"
    (is (=                  "  |"
           (next-game-state " | "
            ["R"])))))
