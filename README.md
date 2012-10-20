## LispIndent

A plugin for [jEdit](http://www.jedit.org/) that properly indents lisp code.
It's targeted to clojure users, but should be usable for other lisp dialects as well.

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

### Getting started

1. Download the [plugin jar](https://github.com/odyssomay/LispIndent/blob/master/LispIndent.jar?raw=true).
2. Put the jar in the `jars` folder in your [settings directory](http://www.jedit.org/users-guide/settings-directory.html).
3. Start jEdit. You might have to enable LispIndent in `Plugins->Plugin manager...`.
4. (optional) Set up [key bindings](#key-bindings).
5. (optional) Set up indenting for your language by using a [preset](#presets).

If you only want to use LispIndent occasionally, indenting can be done from the menu in `Plugins->LispIndent`.

### Upgrading

To upgrade LispIndent to the latest version, repeat steps 1-3 in `Usage`.

### Key bindings

### Presets

### Configuration

All configuration is done in `Plugins->Plugin Options...`. Select `LispIndent`.

#### File ending options

These options controls when LispIndent should be activated, and when it should not.

#### Indent options

These options controls when to use "two space indent", and when to use "function argument indent".

The two space indent looks like this:

```clojure
(blabla 1 2
  3 4 5)
```

The function argument indent looks like this:

```clojure
(blabla 1 2
        3 4 5)
```

### License

LispIndent is licensed under the mit license:

> Copyright (C) 2012 Jonathan Fischer Friberg
> 
> Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
> 
> The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
> 
> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

