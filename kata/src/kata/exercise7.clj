(ns kata.exercise7
  (:use [clojure.test]
        [kata.data]))

(testing "Average Age"

  ; Calculate the average of customer ages by using your own (avg ...)
  ;; Don't forget about (apply ...)
  (let [customers (:customers mall)
        all-ages (map #(:age %) customers)
        ages-sum (apply + all-ages)
        count-customers (count customers)
        avg-age (/ ages-sum count-customers)]

    (is (= avg-age (rationalize 28.7)))))


(testing "How Much for Everything?!"

  ; Calculate the sum of the prices for all the items in all shops by using (flatten ...)
  ;; Don't forget about (apply ...)
  (let [shops (:shops mall)
        all-items (map #(:items %) shops)
        items-flatten (flatten all-items)
        all-prices (map #(:price %) items-flatten)
        total (apply + all-prices)]

    (is (= total 60930))))
