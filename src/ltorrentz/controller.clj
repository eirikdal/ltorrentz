(ns ltorrentz.controller
  (:use ltorrentz.templates
         ltorrentz.models
         ring.util.response
         korma.core))

(defn index
  "Index page handler"
  [req]
  (->> (select posts) (home-page) response)) ;; A sexier way to write (response (home-page))

(defn post
  "Post details page handler"
  [req id]
  (let [postId (Integer/parseInt id)]
    (->> (first (select posts (where {:id postId})))
      post-page response)))