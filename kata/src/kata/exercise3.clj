(ns kata.exercise3
  (:use [clojure.test]
        [kata.data]))

(testing "How many items wanted"

  ; Count how many items are wanted
  (let [customers (:customers mall)
        all-items (mapcat #(:wants-to-buy %) customers)
        wanted-items (count all-items)]

    (is (= wanted-items 32))))


(testing "Richest customer"

  ; Find the richest customer's budget by using (apply ...) (max ...)
  (let [customers (:customers mall)
        all-budgets (map #(:budget %) customers)
        biggest-budget (apply max all-budgets)]

    (is (= biggest-budget 12000))))

(testing "Youngest customer"

  ; Find the youngest customer by using (apply ...) (min-key ...)
  (let [customers (:customers mall)
        youngest-customer (apply min-key :age customers)]

    (is (= (:name youngest-customer) "Martin"))))
