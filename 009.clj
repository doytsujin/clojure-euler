; Problem 9: Special Pythagorean triplet
; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

; a2 + b2 = c2
; For example, 32 + 42 = 9 + 16 = 25 = 52.

; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
; Find the product abc.

(first (for [a (range 1 1000)
             b (range 1 1000)
             c (range 1 1000)
             :when (and
                     (< a b c)
                     (= 1000 (+ a b c))
                     (= (* c c) (+ (* b b) (* a a))))]
            (* a b c))) ; 31875000
