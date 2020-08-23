# practicalli/simple-repl

A simple implementation of a Read, Evaluate, Print Loop (REPL) for Clojure, written in Clojure.  The aim is to gain insight into how the main part of the REPL works.  The project is not trying to implement a development tool.

Download from https://github.com/practicalli/simple-repl.

## Developent
Run the project via the command line

```shell
clojure -m practicalli.simple-repl
```

Run all the project tests using the Cognitect Labs test runner (or add your own test runner)

```shell
clojure -A:test:runner
```

## Deployment
Build an uberjar using depstar

```shell
     clojure -A:uberjar
```

Run the application from the uberjar

```shell
java -jar simple-repl.jar
```

## License

Copyright © 2020 Practicalli

Distributed under the Creative Commons Attribution Share-Alike 4.0 International
