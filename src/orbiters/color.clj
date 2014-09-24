(ns orbiters.color
  (:use quil.core))

(def w (screen-width))
(def h (screen-height))
(def increment 20)
(def radius 15)

(def angle (atom 0))

(defn setup []
  (no-stroke)
  (smooth)
  (ellipse-mode :center))

(defn draw []
  (background 250)
  (color-mode :hsb)
  (doseq [x (range -10 (+ radius w) increment)
          y (range -10 (+ radius h) increment)]
    (fill (int (map-range (- x 10)
                          0 w
                          0 255))
          170 222)
    (ellipse (+ x (* (cos (radians (+ @angle x y)))
                     radius))
             (+ y (* (sin (radians (+ @angle x y)))
                     radius))
             13 13))
  (swap! angle (partial + 4)))

(defsketch orbiters
  :title "Orbiters"
  :setup setup
  :draw draw
  :size [w h])
