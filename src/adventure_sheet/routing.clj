(ns adventure-sheet.routing
  (:require
   [clojure.java.io :as io]
   [huff.core :as h]
   [adventure-sheet.data.core :refer [db]]
   [adventure-sheet.data.services.races :as races-service]
   [adventure-sheet.views.core :as views]))

(defn request-handler
  [req]
  (case (:uri req)
    "/" {:status 200
         :headers {"Content-Type" "text/html"}
         :body (h/html (views/app [views/home]))}
    "/characters" {:status 200
                   :headers {"Content-Type" "text/html"}
                   :body (h/html (views/app [views/characters]))}
    "/characters/builder" {:status 200
                           :headers {"Content-Type" "text/html"}
                           :body (h/html (views/app [views/character-builder]))}
    "/races" {:status 200
              :headers {"Content-Type" "text/html"}
              :body (h/html (views/app [views/races (races-service/find-many db)]))}
    "/favicon.ico" {:status 200
                    :headers {"Content-Type" "image/x-icon"}
                    :body (io/file "public/img/favicon.ico")}
    {:status 404
     :headers {"Content-Type" "text/html"}
     :body (h/html (views/app views/not-found))}))
