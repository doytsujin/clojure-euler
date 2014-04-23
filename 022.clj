; Problem 22: Names scores
; Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

; For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

; What is the total of all the name scores in the file?

(use '[clojure.string :only [replace split]])

(def names (map #(replace % #"[\\\"]" "") (split (slurp "./names.txt") #",")))

(defn alpha-value [word]
  (reduce (fn [sum letter]
          (+ sum (- (int letter) 64))) 0 word))

(->>
  (map #(list %1 (inc %2)) (sort names) (range))
  (reduce (fn [total [word, position]]
              (+ total
                 (* position
                    (alpha-value word))))
          0)
 ); 871198282
