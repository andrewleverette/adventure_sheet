(ns adventure-sheet.data.loader
  (:require [clojure.java.io :as io]
            [cheshire.core :as json]))

(defn load-json
  [filename]
  (-> filename
      io/resource
      slurp
      (json/parse-string true)
      vec))

(defn load-all-resources []
  {:races (load-json "data/Races.json")
   :subraces (load-json "data/Subraces.json")
   :classes (load-json "data/Classes.json")})
