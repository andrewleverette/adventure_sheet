(ns adventure-sheet.views.core)

(defn app [view]
  [:html
   [:head
    [:title "Adventure Sheet"]]
   [:body [:div [view]]]])

(defn home []
  [:<>
   [:h1 "Welcome to Adventure Sheet!"]
   [:p "Start editing to see some magic happen!"]])

(defn not-found []
  [:h1 "You seem to be lost, adventurer!"])
