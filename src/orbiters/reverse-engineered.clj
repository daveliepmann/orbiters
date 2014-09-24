(ns orbiters.reverse-engineered
  (:use quil.core)
  (:require [quil.middleware :as qmid]))

(defn setup []
  (no-stroke)
  (smooth)
  (ellipse-mode :center)
  (fill 0)
  {:angle 0})

(defn update [state]
  (update-in state [:angle] (partial + 4)))

(defn draw [state]
  (background 250)
  (doseq [x (range -10 (+ 20 (screen-width)) 20)
          y (range -10 (+ 20 (screen-height)) 20)]
    (ellipse (+ x (* 15 (cos (radians (+ (:angle state)
                                         x y)))))
             (+ y (* 15 (sin (radians (+ (:angle state)
                                         x y)))))
             13 13)))

(defsketch orbiters
  :title "Orbiters, reverse engineered in Quil"
  :setup setup :draw draw :update update
  :size [(screen-width) (screen-height)]
  :middleware [qmid/fun-mode])
