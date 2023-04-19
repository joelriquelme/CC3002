import cl.uchile.dcc.gwent.cards.Card

import java.util.Objects
import scala.collection.mutable.ListBuffer

class Deck (private var listOfCards : ListBuffer[Card]) extends Equals {
  def take(): Card = {
    var carta: Card = listOfCards.head
    listOfCards = listOfCards.tail
    carta
  }

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
  
