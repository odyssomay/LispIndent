## LispIndent

A plugin for [jEdit](http://www.jedit.org/) that properly indents lisp code.

The in-built indenter in jEdit is very simplistic, and for good reasons!
However, for lisp code, it leads to very inadequate results such as:

```clojure
(let [a {:bla 3
  :bla2 '(1 2 3
    4 5 6)}
  b :is-b]
  b)
``` 

With LispIndent, it's possible to get a much more lispy indentation:

```clojure
(let [a {:bla 3
         :bla2 '(1 2 3
                 4 5 6)}
      b :is-b]
  b)
```
