(ns orbiters.fun-mode
  (:use quil.core)
  (:require [quil.middleware :as qmid]))

(def w (screen-width))
(def h (screen-height))
(def increment 20)
(def radius 15)

(defn setup []
  (no-stroke)
  (smooth)
  (ellipse-mode :center)
  {:angle 0})

(defn update [state]
  (update-in state [:angle] (partial + 4)))

(defn draw [state]
  (background 250)
  (color-mode :hsb)
  (doseq [x (range -10 w increment)
          y (range -10 h increment)]
    (fill (int (map-range (- x 10)
                          0 w
                          0 255))
          170 222)
    (ellipse (+ x (* (cos (radians (+ (:angle state) x y)))
                     radius))
             (+ y (* (sin (radians (+ (:angle state) x y)))
                     radius))
             13 13)))

(defsketch orbiters
  :title "Orbiters"
  :setup setup
  :draw draw
  :update update
  :size [w h]
  :middleware [qmid/fun-mode])
