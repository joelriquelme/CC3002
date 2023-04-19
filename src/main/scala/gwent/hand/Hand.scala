import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent

import java.util.Objects
import scala.concurrent.Batchable
import scala.collection.mutable.ListBuffer


/** A class represent a hand.
 *
 * A hand is defined by a ListBuffer of Cards
 *
 * @param listOfCards The ListBuffer of cards in the hand
 * @constructor Creates a new hand with the specified ListBuffer of Cards
 * @example
 * {{{
 * val hand = new ListBuffer(ListBuffer[Card](new UnitCard("A",1,"Ab"),
 *                                            new UnitCard("B",1,"Ab"),
 *                                            new UnitCard("C",1,"Ab"),
 *                                            )
 *                          )
 * }}}
 * @author Joel Riquelme
 * @since 1.0.0
 * @version 1.0.0
 */
class Hand (private val listOfCards : ListBuffer[Card]) extends Equals {

  /** Play a card of the hand.
   *
   * Play a card and remove them of the hand.
   *
   * @param c The card that you play.
   * @example
   * {{{
   * val hand = new ListBuffer(ListBuffer[Card](new UnitCard("A",1,"Ab"),
   *                                            new UnitCard("B",1,"Ab"),
   *                                            new UnitCard("C",1,"Ab"),
   *                                            )
   *                          )
   * hand.play(new UnitCard("A",1,"Ab")
   * }}}
   */
  def play(c: Card): Unit = {
    c.play()
    listOfCards -= c
  }

  /** Take a card from a deck.
   *
   * Play a card from a deck and add them to the hand.
   *
   * @param c The deck from which you are drawing a card.
   * @example
   * {{{
   * val hand = new ListBuffer(ListBuffer[Card](new UnitCard("A",1,"Ab"),
   *                                            new UnitCard("B",1,"Ab"),
   *                                            new UnitCard("C",1,"Ab"),
   *                                            )
   *                          )
   * hand.deck(Deck)
   * }}}
   */
  def take(deck: Deck) : Unit = {
    listOfCards += deck.take()
  }

  /** Getter of the param listOfCards */
  def getlistOfCards(): ListBuffer[Card] = {
    listOfCards
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Hand]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Hand]
      (this eq other) ||
        (this.listOfCards == other.listOfCards)
    } else {
      false
    }
  }
  override def hashCode: Int = Objects.hash(classOf[Hand], listOfCards)
}
