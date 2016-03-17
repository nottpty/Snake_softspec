# README #

This README will show about compound of project, creator and controller.

### How many class in this project ###

* GameActivity
* BoardView
* Die
* DieCup
* Game
* Piece
* Player

### Creator ###

* DieCup creates Die.
* Player creates Piece.
* GameActivity creates Game and BoardView.
* BoardView creates UI.
* Game creates Player and DieCup.

### Controller ###

* GameActivity connect with BoardView and Game because Game will process logical of program and BoardView create UI of program. GameActivity just control UI from BoardView and use logic from Game, then compile it together.

### Optional ###

* Green cell - If you stop in this cell, you will go to last cell before end point.
* Orange cell - If you stop in this cell, you will go to start point.