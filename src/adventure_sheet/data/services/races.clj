(ns adventure-sheet.data.services.races)

(defn find-many [db]
  (:races @db))

(defn find-unique
  [db index]
  (->> @db
       :races
       (filter #(= index (:index %)))
       first))
