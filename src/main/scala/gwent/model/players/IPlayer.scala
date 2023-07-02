package cl.uchile.dcc
package gwent.model.players

import gwent.controller.Observer

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.Card

trait IPlayer  {
  def playCard(carta: Card, tablero: Board) : Unit
  def takeCard() : Unit
  def registerObserver(o: Observer) : Unit
  def notifyObserver(response: Any) : Unit
}