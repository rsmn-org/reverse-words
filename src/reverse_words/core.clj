(ns reverse-words.core (:gen-class))

(use '[clojure.string :only (join)])

(defn read-input
	[filename]
	(let [content (.split (slurp filename) "\n")]
		(map #(seq (.split % "[ ]")) (rest content))))
		
(defn solve
  [infile outfile]
  (let [input (read-input infile)
  	solutions (map reverse input)
  	result (apply str (map #(str "Case #" (inc %2) ": " (clojure.string/join " " %1) "\n") solutions (range)))]
  (do 
  	(spit outfile result)
  	(print result))))
  	
(defn -main 
	[infile outfile]
	(solve infile outfile))