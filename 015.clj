; Problem 15: Lattice paths
; Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.


; How many such routes are there through a 20×20 grid?

(def routes (memoize
  (fn [x y]
    (cond (and (= x 0) (= y 0)) 1 ; complete path
          (or (< x 0) (< y 0)) 0 ; dead path
          :else (+ (routes (dec x) y) (routes x (dec y)))))))

(routes 20 20); 137846528820
