(ns adventure-sheet.core
  (:require [org.httpkit.server :as hk-server]

            [adventure-sheet.data.core :as data]
            [adventure-sheet.routing :as routing]))

(defn app
  [req]
  (println req)
  (routing/request-handler req))

(defonce server (atom nil))

(defn start-server!
  []
  (reset! server (hk-server/run-server #'app {:port 8080})))

(defn stop-server!
  []
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)))

(defn restart-server!
  []
  (stop-server!)
  (start-server!))

(defn -main [& args]
  (println "Starting server...")
  (data/init-db)
  (restart-server!))
