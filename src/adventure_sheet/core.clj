(ns adventure-sheet.core
  (:require [org.httpkit.server :as hk-server]

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
  (when-some [s @server]
    (s :timeout 100)
    (reset! server nil)))

(defn -main [& args]
  (start-server!))
