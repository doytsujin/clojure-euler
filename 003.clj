; Problem 3: Largest prime factor
; The prime factors of 13195 are 5, 7, 13 and 29.

; What is the largest prime factor of the number 600851475143 ?

(defn prime? [n]
  (not (some true? (map #(zero? (mod n %)) (drop 2 (range n))))))


(defn factorize [n]
  (filter prime?
          (filter #(zero? (mod n %))
                  (map inc (range (Math/sqrt n))))))

(last (factorize 600851475143)) ; 6857
