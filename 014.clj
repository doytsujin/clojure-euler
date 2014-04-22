; Problem 14: Longest Collatz sequence
; The following iterative sequence is defined for the set of positive integers:

; n → n/2 (n is even)
; n → 3n + 1 (n is odd)

; Using the rule above and starting with 13, we generate the following sequence:

; 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
; It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

; Which starting number, under one million, produces the longest chain?

; NOTE: Once the chain starts the terms are allowed to go above one million.

(defn collatz-length [n]
  (loop [n n length 1]
    (if (= n 1)
        length
        (recur (if (even? n)
                   (/ n 2)
                   (inc (* 3 n)))
               (inc length)))))

(loop [n 0 nl 0 i 1]
  (if (>= i 1000000)
      n
      (if (> (collatz-length i) nl)
          (recur i (collatz-length i) (inc i))
          (recur n nl (inc i))))) ; 837799

(collatz-length 837799) ; length = 525
