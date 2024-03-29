(ns lobos.migrations
  (:refer-clojure :exclude [alter drop
                            bigint boolean char double float time])
  (:use (lobos [migration :only [defmigration]]
               core
               schema
               config)))

(defmigration add-authors-table
  ;; code be executed when migrating the schema "up" using "migrate"
  (up [] (create clogdb
                 (table :authors (integer :id :primary-key )
                        (varchar :username 100 :unique )
                        (varchar :password 100 :not-null )
                        (varchar :email 255))))
  ;; Code to be executed when migrating schema "down" using "rollback"
  (down [] (drop (table :authors ))))

(defmigration add-posts-table
  (up [] (create clogdb
                 (table :posts (integer :id :primary-key )
                        (varchar :title 250)
                        (text :content )
                        (boolean :status (default false))
                        (timestamp :created (default (now)))
                        (timestamp :published )
                        (integer :author [:refer :authors :id] :not-null))))
  (down [] (drop (table :posts))))

(defmigration add-ingredients-table
  (up [] (create clogdb
                 (table :ingredients (integer :id :primary-key )
                        (varchar :name 250))))
  (down [] (drop (table :ingredients))))

(defmigration add-recipes-table
  (up [] (create clogdb
                 (table :recipes (integer :id :primary-key )
                        (varchar :title 250))))
  (down [] (drop (table :recipes))))

(defmigration add-subrecipe-table
  (up [] (create clogdb
                 (table :subrecipe (integer :id :primary-key )
                        (varchar :title 250))))
  (down [] (drop (table :subrecipe))))
