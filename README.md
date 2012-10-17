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

### Usage

1. Download the [plugin jar](https://github.com/odyssomay/LispIndent/blob/master/LispIndent.jar?raw=true).
2. Put the jar in the `jars` folder in your [settings directory](http://www.jedit.org/users-guide/settings-directory.html).
3. Start jEdit. You might have to enable LispIndent in the plugin manager (Plugins->Plugin manager...).

When LispIndent has been installed, two new actions will be available in the menu `Plugins->LispIndent`.

You probably want to bind each of these actions to a key. This can be done in `Utilities->Global Options...`, select `shortcuts` and `Plugin: LispIndent` in the `Edit Shortcuts` drop-down list.

The most convenient way to use LispIndent, is to bind `Indent` to ctrl+i, and `Insert newline and indent` to enter. 
This will override the default jEdit actions. 
Since you probably don't want to use LispIndent's indenting when you are editing a non-lisp file, 
you should enable the option `Only use lisp indenting if the file name matches:` 
in `Plugins->Plugin Options...` (select LispIndent).

### License

LispIndent is licensed under the mit license:

> Copyright (C) 2012 Jonathan Fischer Friberg
> 
> Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
> 
> The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
> 
> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

