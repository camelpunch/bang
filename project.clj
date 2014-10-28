(defproject bang "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [jline "1.0"]]
  :profiles {:uberjar {:aot :all
                       :main bang.console}
             :dev {:dependencies [[org.clojure/tools.namespace "0.2.4"]]
                   :plugins [[cider/cider-nrepl "0.7.0"]]
                   :source-paths ["dev"]}})
