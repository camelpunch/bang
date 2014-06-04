(ns bang.core-test
  (:require [clojure.test :refer :all]
            [bang.core :refer :all]))

(def some-game-state identity)

(deftest character
  (testing "character moves right when input is R"
    (is (= (some-game-state "  |")
           (next-game-state " | "
                            ["R"]))))
  (testing "character moves left when input is L"
    (is (= (some-game-state "|  ")
           (next-game-state " | "
                            ["L"])))))
