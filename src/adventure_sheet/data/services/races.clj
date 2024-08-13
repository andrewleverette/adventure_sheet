(ns adventure-sheet.data.services.races)

(defn find-many [db]
  (:races @db))
