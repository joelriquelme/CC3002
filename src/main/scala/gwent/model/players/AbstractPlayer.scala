package cl.uchile.dcc
package gwent.model.players

import cl.uchile.dcc.gwent.controller.Observer
import cl.uchile.dcc.gwent.model.deck.Deck
import cl.uchile.dcc.gwent.model.hand.Hand

import scala.collection.mutable.ListBuffer

abstract class AbstractPlayer
(private val name: String,
 private var gems: Int,
 private val deck: Deck,
 private val hand: Hand) extends IPlayer {
  protected val observers: ListBuffer[Observer] = ListBuffer()

  def registerObserver(o: Observer): Unit = observers += o

  def removeGems(i: Int): Unit = {
    gems -= i
  }

  /** Getter of the param name */
  def getname(): String = {
    name
  }

  /** Getter of the param gems */
  def getgems(): Int = {
    gems
  }

  /** Setter of the param gems */
  def setgems(g: Int): Unit = {
    gems = math.max(0, g)
  }

  /** Getter of the param deck */
  def getdeck(): Deck = {
    deck
  }

  /** Getter of the param hand */
  def gethand(): Hand = {
    hand
  }

  def shuffleDeck(): Unit = {
    deck.shuffleDeck()
  }

  def removeOneGem(): Unit = {
    gems -= 1
    notifyObserver(response = getgems())
  }

  
}
