(ns orbiters.reverse-engineered
  (:use quil.core))

(def w (screen-width))
(def h (screen-height))
(def increment 20)
(def radius 15)

(def angle (atom 0))

(defn setup []
  (fill 255)
  (no-stroke)
  (smooth)
  (ellipse-mode :center))

(defn draw []
  (background 0)
  
  (doseq [x (range -10 (+ radius w) increment)
          y (range -10 (+ radius h) increment)]    
    (ellipse (+ x (* (cos (radians (+ @angle x y)))
                     radius))
             (+ y (* (sin (radians (+ @angle x y)))
                     radius))
             13 13))
  (swap! angle (partial + 2)))

(defsketch orbiters
  :title "Orbiters"
  :setup setup
  :draw draw
  :size [w h])
