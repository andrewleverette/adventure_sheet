(ns adventure-sheet.views.core
  (:require [clojure.string :as str]
            [adventure-sheet.data.core :refer [db]]
            [adventure-sheet.data.services.races :as races-service]))

(defn app [view]
  [:html
   [:head
    [:title "Adventure Sheet"]]
   [:body [:div [view]]]])

(defn home []
  [:<>
   [:h1 "Welcome to Adventure Sheet!"]
   [:p "Your adventure awaits!"]])

(defn characters
  []
  [:<>
   [:h1 "Characters"]
   [:p "Choose from an existing character or create a new one!"]])

(defn character-builder []
  [:<>
   [:h1 "Character Builder"]
   [:p "This is the character builder"]])

(defn racial-traits [race]
  [:div
   [:h4 "Racial Traits"]
   [:p (->> race :traits (map :name) (str/join ", "))]])

(defn race [race]
  [:div
   [:h3 (:name race)]
   [:hr]
   [:p (:description race)]
   [racial-traits race]
   [:button {:on-click #(println "View " (:name race) " Details")} (str "View " (:name race) " Details")]
   [:hr]])

(defn races [races]
  [:<>
   [:h1 "Races"]
   [:hr]
   [:ul
    [:<> (for [r races]
           [:li [race r]])]]])

(defn not-found []
  [:h1 "You seem to be lost, adventurer!"])
