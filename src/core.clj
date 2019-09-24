(ns core
  (:require [morse.handlers :as h]
            [clojure.core.async :refer [<!!]]
            [morse.polling :as p]
            [morse.api :as t])
  (:gen-class))

(def token (System/getenv "TOKEN"))

(h/defhandler handler

  (h/command-fn
    "stop"
    (fn [{{id :id :as chat} :chat}]
      (t/send-text token id "You can't stop me")))

  (h/command-fn
    "start"
    (fn [{{id :id :as chat} :chat}]
      (println "Bot joined new chat: " chat))))

(defn -main []
  (println "START")
  (<!! (p/start token handler {:timeout 10})))
