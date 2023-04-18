import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent

import java.util.Objects
import scala.concurrent.Batchable

class Hand (private var listOfCards : List[Card]) extends Equals {

  def play(c: Card): Unit = {
    c.play()
    listOfCards = listOfCards.filter(!c.equals(_))

  }
  //Getters
  def take(deck: Deck) : Unit = {
    listOfCards = deck.take() :: listOfCards
  }
  def getlistOfCards(): List[Card] = {
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
