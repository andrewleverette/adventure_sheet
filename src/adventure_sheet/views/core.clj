(ns adventure-sheet.views.core)

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

(defn not-found []
  [:h1 "You seem to be lost, adventurer!"])
