(ns ltorrentz.models
  (:use korma.db
        korma.core))

(defdb clogdb
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname "clogdb"
   :user "clog"
   :password "unknown84"})

(defentity authors)
(defentity posts)