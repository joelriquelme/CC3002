import cl.uchile.dcc.gwent.cards.Card

import java.util.Objects
import scala.collection.mutable.ListBuffer
import scala.util.Random

class Deck (private var listOfCards : ListBuffer[Card]) extends Equals {
  /** A class represent a deck.
   *
   * A deck is defined by a ListBuffer of Cards
   *
   * @param listOfCards The ListBuffer of cards in the deck
   * @constructor Creates a new Deck with the specified ListBuffer of Cards
   * @example
   * {{{
   * val deck = new ListBuffer(ListBuffer[Card](new UnitCard("A",1,"Ab"),
   *                                            new UnitCard("B",1,"Ab"),
   *                                            new UnitCard("C",1,"Ab"),
   *                                            )
   *                          )
   * }}}
   * @author Joel Riquelme
   * @since 1.0.0
   * @version 1.0.0
   */

  /**Take a card of the deck.
   *
   * Take the card of the top of the deck (the head of the ListBuffer), remove them of the deck and return the card.
   *
   * @return A Card of the top of the deck.
   * @example
   * {{{
   * val deck = new ListBuffer(ListBuffer[Card](new UnitCard("A",1,"Ab"),
   *                                            new UnitCard("B",1,"Ab"),
   *                                            new UnitCard("C",1,"Ab"),
   *                                            )
   *                          )
   * var card = deck.take()
   * }}}
   */
  def take(): Card = {
    val carta: Card = listOfCards.head
    listOfCards = listOfCards.tail
    carta
  }

  /** Shuffle the deck randomly.
   *
   * @example
   * {{{
   * val deck = new ListBuffer(ListBuffer[Card](new UnitCard("A",1,"Ab"),
   *                                            new UnitCard("B",1,"Ab"),
   *                                            new UnitCard("C",1,"Ab"),
   *                                            )
   *                          )
   * var card = deck.shuffleDeck()
   * }}}
   */
  def shuffleDeck(): Unit = {
    Random.shuffle(listOfCards)
  }
  
  /** Getter of the param listOfCards */
  def getlistOfCards(): ListBuffer[Card] = {
    listOfCards
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Deck]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Deck]
      (this eq other) ||
        (this.listOfCards == other.listOfCards)
    } else {
      false
    }
  }
  
  override def hashCode: Int = Objects.hash(classOf[Deck], listOfCards)
}
  
