(ns adventure-sheet.routing
  (:require
   [clojure.java.io :as io]
   [huff.core :as h]
   [adventure-sheet.views.core :as views]))

(def route-map
  {[:get "/"] views/home})

(def resource-map
  {"/favicon.ico" "public/img/favicon.ico"})

(defn view-handler
  [route]
  (let [view (get route-map route views/home)]
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body (h/html [views/app view])}))

(defn resource-handler
  [path]
  {:status 200
   :headers {"Content-Type" "image/x-icon"}
   :body (io/file path)})

(defn request-handler
  [req]
  (let [{request-method :request-method
         uri :uri} req]
    (cond
      (contains? resource-map uri) (resource-handler (get resource-map uri))
      (contains? route-map [request-method uri]) (view-handler [request-method uri])
      :else {:status 404
             :headers {"Content-Type" "text/html"}
             :body (h/html [views/not-found])})))
