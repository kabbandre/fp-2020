(ns kata.exercise8
  (:use [clojure.test]
        [kata.data]))

(defn difference
  ([s1] s1)
  ([s1 s2]
   (if (< (count s1) (count s2))
     (reduce (fn [result item]
               (if (contains? s2 item)
                 (disj result item)
                 result))
             s1 s1)
     (reduce disj s1 s2)))
  ([s1 s2 & sets]
   (reduce difference s1 (conj sets s2))))

(testing "Nowhere to be Found"

  ; Create a set of item names that are in {@link customer->wants-to-buy} but not on sale in any shop.
  (let [customers (:customers mall)
        wants-to-buy (mapcat #(:wants-to-buy %) customers)
        wants-to-buy-names (map #(:name %) wants-to-buy)
        wants-to-buy-names-set (set wants-to-buy-names)

        shops (:shops mall)
        shops-items (map #(:items %) shops)
        shops-items-flatten (flatten shops-items)
        shops-items-flatten-names (map #(:name %) shops-items-flatten)
        shops-items-flatten-names-set (set shops-items-flatten-names)

        not-for-sale (difference wants-to-buy-names-set shops-items-flatten-names-set)]

    (println wants-to-buy-names-set)
    (println shops-items-flatten-names-set)


    (is (= not-for-sale #{"bag", "pants", "coat"}))))

(testing "I see it, I like it, I want it, I got it "

  ; Create a customers' name list including who are having enough money to buy all items they want which is on sale.
  ; Items that are not for sale can be counted as 0 money cost.
  ; If there are multiple items with the same names, but different prices, customer will choose the cheapest one.
  (let [richies []]

    (is (= richies ["Joe", "Patrick", "Chris", "Kathy", "Alice", "Andrew", "Amy"]))))
