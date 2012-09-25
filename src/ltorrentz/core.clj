(ns ltorrentz.core
  (:use ring.adapter.jetty)
  ring.middleware.resource
  ring.util.response
  net.cgrand.moustache)

;;; A simple handler
(defn index
  [req]
  (response "Welcome to ltorrentz"))

; Routes definition
(def routes
  (app
   [""] index))

;;; start function for starting jetty
(defn start [&amp port]
             (run-jetty #'routes {:port (or port 8080) :join? false}))