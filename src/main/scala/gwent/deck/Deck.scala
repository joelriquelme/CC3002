import cl.uchile.dcc.gwent.cards.Card

import java.util.Objects

class Deck (private var listOfCards : List[Card]) extends Equals {
  def take(): Card = {
    var carta: Card = listOfCards.head
    listOfCards = listOfCards.tail
    carta
  }

  def getlistOfCards(): List[Card] = {
    listOfCards
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Deck]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Deck]
      (this eq other) ||
        (this.listOfCards == other.listOfCards && this.hashCode == other.hashCode)
    } else {
      false
    }
  }
  
  override def hashCode: Int = Objects.hash(classOf[Deck], listOfCards)
}
  
