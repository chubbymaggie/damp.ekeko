(ns 
  damp.ekeko.demo.relations
  (:refer-clojure :exclude [== type class])
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

;(defn
;         (type-qualifiedname ?collection-type "java.util.Collection")
;         ))

(defn
  method-returning-null-for-ctype
  [?method ?ast-type]
  (fresh [?ast-type-kind ?collection-type ?type]
         (method-returning-null-for-type ?method ?ast-type)
         (ast-type-type ?ast-type-kind ?ast-type ?type)
         (type-qualifiedname ?ast-type "java.util.List")))

(defn
  method-always-returning-null-for-ctype
  [?m ?t]
  (method-returning-null-for-type ?m ?t)
  )
    
;  (defn
;            (qcurrent [?return]
;               (q=>*)       








