; Problem 4: Largest palindrome product
; A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

; Find the largest palindrome made from the product of two 3-digit numbers.

(defn palindromic-number? [n]
  (palindrome? (str n)))

(defn palindrome? [st]
  (if (< (count st) 2) true
      (let [inner (subs st 1 (- (count st) 1))]
           (and (= (first st) (last st))
                (palindrome? inner)))))

(last (sort
    (filter palindromic?
        (for [x (range 100 1000)
              y (range 100 1000)]
                  (* x y))))) ; 906609
