(defproject xtract-csv "0.1.0-SNAPSHOT"
  :description "Extract the specified columns from the input csv into the output.csv."
  :url "http://github.com/mgyongyosi/xtract-csv/"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.csv "0.1.4"]]
  :main ^:skip-aot xtract-csv.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
