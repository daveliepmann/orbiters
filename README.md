# orbiters

A Quil sketch made for fun (and to play with Quil's new
functional-mode). I reverse engineered Dave Whyte's
[orbiters](http://beesandbombs.tumblr.com/post/45513650541/orbiters)
using Processing, modified it a bit, then converted it to Quil.

The [processing.js version](http://www.daveliepmann.com/dataviz/orbiters) (in this repo as `orbiters-js.pde`) runs in
the browser. The only difference is the use of screen.width instead of
displayWidth (and same for height).

## Usage

LightTable - open `core.clj` and press `Ctrl+Shift+Enter` to evaluate the file.

Emacs - run cider, open `core.clj` and press `C-c C-k` to evaluate the file.

REPL - run `(require 'orbiters.core)`.

## License

Copyright © 2014

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
