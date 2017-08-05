(ns xtract-csv.core
  (:gen-class)
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]))

(defn select
  "Selects the elements on the indexes from a vec into a seq."
  [indexes from]
  (loop [n indexes
         source from
         out []]
    (if (empty? n)
      out
      (recur (rest n) source (conj out (nth source (read-string (first n))))))))


(defn transform-csv [from to indexes]
  (with-open [reader (io/reader from :encoding "UTF-16")
              writer (io/writer to)]
    (->> (csv/read-csv reader :separator \; :quote \")
         (map #(select indexes %))
         (csv/write-csv writer))))

; :separator \;
;:quote \"
;:quote? :separator
;:newline :cr+lf

(defn -main
  [& args]
  (transform-csv (nth args 0) (nth args 1) (vec (drop 2 args))))
