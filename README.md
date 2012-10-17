## LispIndent

A plugin for [jEdit](http://www.jedit.org/) that properly indents lisp code.

This is needed since otherwise, code which contains any kind of brackets, or a quoted list, will fail to properly indent.

This will lead to results such as:

```clojure
(let [a {:bla 3
  :bla2 '(1 2 3
    4 5 6)}
  b :is-b]
  b)
``` 

Where the correct indentation is:

```clojure
(let [a {:bla 3
         :bla2 '(1 2 3
                 4 5 6)}
      b :is-b]
  b)
```
