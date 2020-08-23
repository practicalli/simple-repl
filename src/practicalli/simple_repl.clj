(ns practicalli.simple-repl
  (:gen-class))


(defn -main
  "A naive Clojure REPL implementation.  Enter `:quit`
   to exit."
  []
  (print (str (ns-name *ns*) " λ "))
  (flush)
  (let [result (eval (read))]
    (when (not= :quit result)
      (println result)
      (recur))))


;; Usage
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Call the `-main` function to start the REPL in a REPL

(comment

  (-main)

  )

;; Or run the project on the comand line, see README.md


;; Design Journal
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(comment

  ;; Use the -main function as the repl
  ;; - app template used to create the project


  ;; Create a prompt for the repl

  ;; `print` sends a value to the standard out

  ;; The REPL prompt shows the current namespace

  (ns-name 'practicalli.simple-repl)
  ;; => practicalli.simple-repl

  ;; The *ns* is dynamically assigned to the current namespace in the REPL
  ;; so `ns-name` with the argument `*ns*` will return the current namespace

  (ns-name *ns*)
  ;; => practicalli.simple-repl

  ;; When running this application on the command line, `user` will be the default namespace
  ;; as its the Clojure REPL default namespace

  ;; `flush` Flushes the output stream that is the current value of *out*
  ;; this ensures the REPL prompt is displayed each time around the loop.

  ;; The prompt is completed, now we need to get the clojure expressions and evaluate them


  ;; (read) will get the value from the standard in, *in*

  ;; As we are entering in Clojure expressions, then we can simply pass the value of standard in to eval

  (eval '(map inc [1 2 3]))
  ;; => (2 3 4)

  ;; println will sent the result of the eval function to the standard out.

  (println (eval (read)))

  ;; Put this code into a -main function definition

  (defn -main
    []
    (print (str (ns-name *ns*) " λ "))
    (flush)
    (println (eval (read))))

  ;; So far there is a Read Evaluate and Print part of the REPL.

  ;; Using `recur` provides a simple way to have a loop, as it will continually call -main
  ;; The loop is stateless, so no need to pass any data back via the recur

  (defn -main
    []
    (print (str (ns-name *ns*) " λ "))
    (flush)
    (println (eval (read)))
    (recur))

  ;; The REPL works, although improvements can be made

  ;; There is no way to stop the loop so the REPL is eternal.
  ;; A `when` expression is a simple way to add a conditional break.
  ;; The condition checks if something other than `:quit` keyword has been entered at the prompt

  (defn -main
    []
    (print (str (ns-name *ns*) " λ "))
    (flush)
    (when (not= :quit (read))
      (println (eval (read)))
      (recur)))

  ;; This is not quite right as we need to read the expression typed at the prompt twice.

  ;; Use a let expression to capture the value read from the standard in

  (let [expression (read)
        result     (eval expression)])

  ;; Or even simpler
  (let [result (eval (read))])

  ;; Then the value referred to by result can be used in several places

  (defn -main
    []
    (print (str (ns-name *ns*) " λ "))
    (flush)
    (let [result (eval (read))]
      (when (not= :quit result)
        (println result)
        (recur))))

  ;; Now we have a working REPL that will end when it receives the keyword :quit

  )
