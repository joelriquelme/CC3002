package cl.uchile.dcc
package gwent.model.players

import cl.uchile.dcc.gwent.*
import cl.uchile.dcc.gwent.controller.Observer
import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.Card
import cl.uchile.dcc.gwent.model.deck.Deck
import cl.uchile.dcc.gwent.model.hand.Hand

import java.util.Objects
import scala.collection.mutable.ListBuffer

/** A class represent a cpu.
 *
 * A cpu is defined by a name, gems, deck and a hand.
 *
 * @param name The name of the player
 * @param gems The count of gems
 * @param deck The deck of the player
 * @param hand The hand of the player
 *
 * @constructor Creates a new cpu with the specified name, gems, deck and hand.
 * @example
 * {{{
 * val listOfCards = new ListBuffer(ListBuffer[Card](new UnitCard("A",1,"Ab"),
 *                                            new UnitCard("B",1,"Ab"),
 *                                            new UnitCard("C",1,"Ab"),
 *                                            )
 *                          )
 * val cpu = new Cpu("Pedro", 2, new Deck(listOfCards), new Hand(listOfCards))
 * }}}
 * @author Joel Riquelme
 * @since 1.0.0
 * @version 1.0.0
 */
class Cpu (private val name : String,
          private var gems : Int,
          private val deck : Deck,
          private val hand : Hand) extends AbstractPlayer with Equals {
  //gems cant be negative
  gems = math.max(gems, 0)

  /** Play a card.
   *
   * Play a card of the hand.
   *
   * @param c The card that you play.
   * @example
   * {{{
   * val listOfCards = new ListBuffer(ListBuffer[Card](new UnitCard("A",1,"Ab"),
   *                                            new UnitCard("B",1,"Ab"),
   *                                            new UnitCard("C",1,"Ab"),
   *                                            )
   *                          )
   * val player = new Player("Pedro", 2, new Deck(listOfCards), new Hand(listOfCards))
   * player.play(new UnitCard("A",1,"Ab"))
   * }}}
   */
  def playCard(carta: Card, tablero: Board): Unit = {
    hand.playCpu(carta, tablero)
  }

  /** Take a card of the deck.
   *
   * Play a card of the deck and decrease the size of the deck.
   *
   * @example
   * {{{
   * val listOfCards = new ListBuffer(ListBuffer[Card](new UnitCard("A",1,"Ab"),
   *                                            new UnitCard("B",1,"Ab"),
   *                                            new UnitCard("C",1,"Ab"),
   *                                            )
   *                          )
   * val player = new Player("Pedro", 2, new Deck(listOfCards), new Hand(listOfCards))
   * player.take()
   * }}}
   */
  def takeCard() : Unit = {
    hand.take(deck)
  }



  def notifyObserver(response: Any): Unit = {
    for (o <- observers) {
      o.updateCpu(this, response)
    }
  }

  def removeOneGem(): Unit = {
    gems -= 1
    notifyObserver(response = getgems())
  }

  /** Getter of the param name */
  def getname() : String ={
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

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Cpu]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Cpu]
      (this eq other) ||
        (this.name == other.name && this.gems == other.gems && this.deck == other.deck && this.hand == other.hand)
    } else {
      false
    }
  }

  override def hashCode: Int = Objects.hash(classOf[Cpu], name, gems, deck, hand)
}
