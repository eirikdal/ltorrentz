(defproject ltorrentz "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [compojure "1.1.3"]
                 [ring "1.1.6"
                  :exclusions [org.clojure/clojure
                               clj-stacktrace]]
                 [lobos "1.0.0-SNAPSHOT"]
                 [postgresql "9.1-901.jdbc4"]
                 [korma "0.3.0-beta9"]
                 [clj-yaml "0.4.0"]
                 [enlive "1.0.0"]
                 [net.cgrand/moustache "1.1.0"]
                 [log4j "1.2.15" :exclusions [javax.mail/mail
                                              javax.jms/jms
                                              com.sun.jdmk/jmxtools
                                              com.sun.jmx/jmxri]]
                 ])