(ns user
  (:require [bang.core :refer :all]
            [clojure.test :refer :all]
            [clojure.repl :refer (apropos dir doc find-doc pst source)]
            [clojure.tools.namespace.repl :refer (refresh refresh-all)]))

(defn t
  []
  (refresh)
  (clojure.test/run-tests 'bang.core-test))
