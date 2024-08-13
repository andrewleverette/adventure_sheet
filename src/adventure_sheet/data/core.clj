(ns adventure-sheet.data.core
  (:require [adventure-sheet.data.loader :as loader]))

(def db (atom {}))

(defn init-db []
  (reset! db (loader/load-all-resources)))
