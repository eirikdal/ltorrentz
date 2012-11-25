(ns lobos.config
  (:use lobos.connectivity))

(def clogdb
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname "clogdb"
   :user "clog"
   :password "unknown84"})

(open-global clogdb)