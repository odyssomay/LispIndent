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

## Getting started

1. Download the [plugin jar](https://github.com/odyssomay/LispIndent/blob/master/LispIndent.jar?raw=true).
2. Put the jar in the `jars` folder in your [settings directory](http://www.jedit.org/users-guide/settings-directory.html).
3. Start jEdit. You might have to enable LispIndent in `Plugins->Plugin manager...`.
4. (optional) Set up [key bindings](#key-bindings).
5. (optional) Set up indenting for your language by using a [preset](#presets).

If you only want to use LispIndent occasionally, indenting can be done from the menu in `Plugins->LispIndent`.

### Upgrading

To upgrade LispIndent to the latest version, 
repeat steps 1-3 in [Getting started](#getting-started).

## Configuration

Most configuration is done in the plugin options.
They can be accessed in `Plugins->Plugin Options...`, select `LispIndent`.

### Key bindings

LispIndent does not automatically set up key bindings.
To do this, go to `Utilities->Global Options...`. Select `Shortcuts`.
In the `Edit Shortcuts` drop-down list, select `Plugin: LispIndent`.

You can of course use any key you like for the LispIndent actions,
but this scheme is recommended:

- `enter` for `LispIndent: Insert enter and indent`.
- `ctrl + i` for `LispIndent: Indent`.

If you use this scheme, you should also use a preset (see below) and/or
configure the [file ending options](#plugin-options).
Otherwise, LispIndent will also indent files that are not lisp files.

### Presets

Different lisp languages is not automatically detected.
There are however presets that tailors the indenting specifically
for a certain language.

To use a preset, click the `Use preset` button in the plugin options.

If your language is not one of the available, use the `none` preset or
manually configure LispIndent (see [Plugin options](#plugin-options) below).
If you'd like your language to be available, please open an issue 
or contact [me](https://github.com/odyssomay).

### Plugin options

This section describes specifically how each option works.

#### File ending options

These options controls for which files LispIndent should be activated.
If `Only use LispIndent if file name matches regex:` is unchecked,
LispIndent is always used when the LispIndent actions are activated.

If it is checked, and the file name matches the regular expression in the text box,
LispIndent is used. Otherwise, the in-built jEdit indenting is used. 

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

The first option - `By default, indent: ...`, simply sets which of these
types of indenting is used normally.

The `Indent two spaces if operator matches regex:`,
`Indent to function arguments if operator matches regex:`
and their corresponding text boxes, controls
when the other type of indenting should be used instead
('the other type' depends on the default indenting type).

### License

LispIndent is licensed under the mit license:

> Copyright (C) 2012 Jonathan Fischer Friberg
> 
> Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
> 
> The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
> 
> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

