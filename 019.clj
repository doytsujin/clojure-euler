; Problem 19: Counting Sundays
; You are given the following information, but you may prefer to do some research for yourself.

; 1 Jan 1900 was a Monday.
; Thirty days has September,
; April, June and November.
; All the rest have thirty-one,
; Saving February alone,
; Which has twenty-eight, rain or shine.
; And on leap years, twenty-nine.
; A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
; How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

(defn in? [coll x] (if (some #{x} coll) true false))

(defn leap-year? [y]
  (and (zero? (rem y 4))
       (or (not (zero? (rem y 100)))
           (zero? (rem y 400)))))

(defn next-date [[d m y wd]]
  (let [wd* (inc (rem wd 7))
        m* (inc (rem m 12))]
  (cond (and (= d 31) (= m 12) (>= y 2000))
            nil
        (and (leap-year? y) (= m 2) (= d 28))
            [29 2 y wd*]
        (and (= m 2) (>= d 28))
            [1 3 y wd*]
        (and (= m 12) (= d 31))
            [1 1 (inc y) wd*]
        (or (and (in? '(9 4 6 11) m) (= d 30)) (>= d 31))
            [1 m* y wd*]
        :else
            [(inc d) m y wd*])))

(defn all-dates
  ([] (all-dates [1 1 1900 1]))
  ([[d m y wd :as date]]
   (if (nil? date)
        nil
       (cons [d m y wd]
             (lazy-seq (all-dates (next-date [d m y wd])))))))

(comment
  (in? (all-dates) [1 1 1970 4])
  )

(->>
 (all-dates)
 (filter (fn [[d m y wd]] (and (= 1 d) (= 7 wd) (<= y 2000) (>= y 1901))))
 (count)) ; 171
