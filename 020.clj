; Problem 20: Factorial digit sum
; n! means n × (n − 1) × ... × 3 × 2 × 1

; For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
; and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

; Find the sum of the digits in the number 100!

(defn fac [n*]
  (loop [n n* p 1]
    (if (= n 1) p
        (recur (dec n) (*' p n)))))

(defn digits-sum [n*]
  (loop [n n* s 0]
    (if (= n 0) s
        (recur (quot n 10) (+' s (rem n 10))))))

(digits-sum (fac 100)) ; 648
