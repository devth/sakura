(ns sakura.core "Playing with trees")

(defrecord Node [value children])

(defn mk-tree
  "Recursively transform nested vectors into Node instances"
  [node]
  (if (sequential? node)
    (let [[value & children] node]
      (Node. value (map mk-tree children)))
    (Node. node [])))

;;; Some trees to play with

(def Rosaceae
  "Rosaceae (the rose family) are a medium-sized family of flowering plants,
   including about 2830 species in 95 genera.
   Taken from http://en.wikipedia.org/wiki/Rosaceae"
  (mk-tree '[Rosaceae
             Rosoideae
             Filipendula
             [Rosodae
              Sanguisorbeae
              Potentilleae
              Colurieae]
             Dryadoideae
             [Amygdaloideae
              Lyonothamnus
              Amygdaleae
              Sorbarieae
              Spiraeeae
              [Kerriodae
               Kerrieae
               Osmarioneae]
              [Pyrodae
               Gillenia
               [Maleae
                Kageneckia
                Vauquelinia
                Lindleya
                Malinae]]]]))

(def Family
  "In human context, a family (from Latin: familia) is a group of people affiliated
   by consanguinity, affinity, or co-residence."
  (mk-tree '[Great Grandparent
             [Great Uncle
              [First cousin once removed
               [Second cousin
                Second cousin once removed]]]
             Great Aunt
             [Grandparent
              [Aunt
               Cousin
               Cousin]
              [Uncle
               Cousin]
              [Parent
               Self ; <-- You are Here
               Brother
               Sister]]]))

(defn -main [])
