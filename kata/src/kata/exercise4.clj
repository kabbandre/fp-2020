(ns kata.exercise4
  (:use [clojure.test]
        [kata.data]))

(testing "First registrant"

  ; Find the first customer
  (let [customers (:customers mall)
        first-customer (first customers)]

    (is (= (:name first-customer) "Joe"))))


(testing "Is there anyone older than 40?"

  ; Check whether any customer older than 40 exists or not by using (some ...)
  (let [customers (:customers mall)
        over40 (some #(> (:age %) 40) customers)]

    (is (nil? over40))))

(testing "Is everybody older than 20?"

  ; Check whether all customer are older than 20 or not by using (every ...)
  (let [customers (:customers mall)
        over20 (every? #(> (:age %) 20) customers)]

    (is (true? over20))))

(testing "Everyone wants something"

  ; Confirm that none of the customer has empty :wants-to-buy by using (not-any? ...)
  (let [customers (:customers mall)
        wanted-items (map #(:wants-to-buy %) customers)
        all-want-smth (not-any? empty? wanted-items)]

    (is (true? all-want-smth))))
