import cl.uchile.dcc.gwent.cards.Cards
import cl.uchile.dcc.gwent

import java.util.Objects
import scala.concurrent.Batchable

class Hand (private var listOfCards : List[Cards]) extends Equals {

  def play(c: Cards): Unit = {
    c.play()
    listOfCards = listOfCards.filter(!c.equals(_))

  }
  //Getters
  def take(deck: Deck) : Unit = {
    listOfCards = deck.take() :: listOfCards
  }
  def getlistOfCards(): List[Cards] = {
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
