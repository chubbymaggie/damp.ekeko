(ns 
  damp.ekeko.demo.relations
  (:refer-clojure :exclude [== type])
  (:use [clojure.core.logic])
  (:use [damp.ekeko.logic])
  (:use [damp.ekeko.jdt.reification])
  (:use [damp.ekeko.jdt.basic]))


(defn
  statement-returning-null
  [?s]
  (fresh [?e] 
    (ast :ReturnStatement ?s)
    (has :expression ?s ?e)
    (ast :NullLiteral ?e)))


(defn 
  method-returning-null-for-type
  [?m ?t]
  (fresh [?s]
         (statement-returning-null ?s)
         (ast-encompassing-method ?s ?m)
         (has :returnType2 ?m ?t)))

(defn

(defn
  method-always-returning-null-for-ctype
  [?m ?t]
  (method-returning-null-for-ctype ?m ?t))
    
;  (defn
;            (qcurrent [?return]
;               (q=>*)       








