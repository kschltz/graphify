(ns sample.core
  "A sample namespace for testing."
  (:require [clojure.string :as str]))

(def ^:private x 42)

(defn greet
  "Greets a person."
  [name]
  (str/upper-case (str "Hello, " name)))

(defmacro unless
  [condition body]
  `(if (not ~condition) ~body nil))

(defmulti process class)

(defmethod process String [s]
  (.length s))

(defprotocol Drawable
  (draw [this]))

(deftype Point [x y]
  Drawable
  (draw [this] (str "Point(" x "," y ")")))

(defrecord Person [name age])

(defn main []
  (let [p (->Person "Alice" 30)]
    (greet (:name p))))
