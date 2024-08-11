(ns adventure-sheet.core
  (:require [org.httpkit.server :as hk-server]
            [huff2.core :as h]))

(defn app
  [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (str (h/html [:h1 "Welcome to Adventure Sheet!"]))})

(defonce server (atom nil))

(defn start-server!
  []
  (reset! server (hk-server/run-server #'app {:port 8080})))

(defn stop-server!
  []
  (when-some [s @server]
    (s :timeout 100)
    (reset! server nil)))
