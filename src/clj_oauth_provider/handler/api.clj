(ns clj-oauth-provider.handler.api
  (:require [compojure.core :refer :all]
            [clojure.java.io :as io]
            [integrant.core :as ig]
            [clj-oauth-provider.service.authorization :as authorization]))

(defmethod ig/init-key :clj-oauth-provider.handler/api [_ {:keys [auth]}]
  (context "/" []
           (GET  "/authorize" [] (authorization/login-page auth nil))
           (POST "/authorize" [] (authorization/authorize-resource auth))
           (POST "/token" [] (authorization/access-token-resource auth))
           (GET  "/introspect" [] (authorization/introspect-resource auth))))
