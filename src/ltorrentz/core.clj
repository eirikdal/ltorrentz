(ns ltorrentz.core
  (:use ring.adapter.jetty
        ltorrentz.models
        ltorrentz.controller
        [ring.middleware resource params file file-info stacktrace reload]
        [ring.util.response :exclude [not-found]]
        net.cgrand.moustache
        net.cgrand.enlive-html))

; Routes definition
(def routes
  (app
   ["login"] (delegate login)
   [""] (delegate index)
   [id] (delegate post id)
   )
)

(defn myapp
  []
  (-> routes
      (wrap-file "resources/public")
      (wrap-reload '(ltorrentz.core ltorrentz.templates ltorrentz.models ltorrentz.controller))))

;;; start function for starting jetty
(defn start [&amp port]
             (run-jetty (myapp) {:port (or port 8080) :join? false}))

(defn restart [srv port]
  (.stop srv)
  (start false port))