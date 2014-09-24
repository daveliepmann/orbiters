(ns orbiters.color
  (:use quil.core)
  (:require [quil.middleware :as qmid]))

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
  (doseq [x (range -10 (+ 20 (screen-width)) 20)
          y (range -10 (+ 20 (screen-height)) 20)]
    (fill (int (map-range (- x 10)
                          0 (screen-width)
                          0 255))
          170 222)
    (ellipse (+ x (* 15 (cos (radians (+ (:angle state)
                                         x y)))))
             (+ y (* 15 (sin (radians (+ (:angle state)
                                         x y)))))
             13 13)))

(defsketch orbiters
  :title "Orbiters in color"
  :setup setup :draw draw :update update
  :size [(screen-width) (screen-height)]
  :middleware [qmid/fun-mode])
