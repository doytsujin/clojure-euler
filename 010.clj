; Problem 10: Summation of primes
; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

; Find the sum of all the primes below two million.

(defn prime? [n]
   (every? false? (filter #(zero? (mod n %)) (take-nth 1 (range 2 (+ 1 (int (Math/sqrt n))))))))



(->>
 (range)
 (filter prime?)
 (take-while (partial >= 2000000))
 (apply +)) ;142913828922
