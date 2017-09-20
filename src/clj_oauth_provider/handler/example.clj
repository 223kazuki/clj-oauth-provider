(ns clj-oauth-provider.handler.example
  (:require [compojure.core :refer :all]
            [clojure.java.io :as io]
            [integrant.core :as ig]))

(defmethod ig/init-key :clj-oauth-provider.handler/example [_ options]
  (context "/example" []
    (GET "/" []
      {:body {:example "data"}}(io/resource "clj_oauth_provider/handler/example/example.html"))))
