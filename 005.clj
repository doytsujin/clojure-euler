; Problem 5: Smallest multiple
; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?


(defn factors
  ([n] (factors n [1]))
  ([n fs]
    (if (= n 1) fs
        (let [_f (first (filter #(zero? (mod n %)) (range 2 (+ n 1))))
              f (if _f _f n)]
            (factors (/ n f) (conj fs f))))))

(int (reduce (fn [acc [k v]] (* acc (Math/pow k v))) 1
  (let [fs (map (comp frequencies factors) (range 1 21))]
    (reduce
       (partial merge-with (fn [a b] (if (> a b) a b)))
       {} fs)))) ; 232792560
