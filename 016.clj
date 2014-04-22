; Problem 16: Power digit sum
; 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

; What is the sum of the digits of the number 2^1000?

(use '[clojure.math.numeric-tower :as math])

(defn digits-sum
  ([n] (digits-sum n 0))
  ([n sum]
     (if (zero? n) sum
         (recur (quot n 10) (+ sum (rem n 10))))))

(digits-sum (math/expt 2 1000)) ; 1366
