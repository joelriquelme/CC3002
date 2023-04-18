import cl.uchile.dcc.gwent.cards.Cards

import java.util.Objects

class Deck (private var listOfCards : List[Cards]) extends Equals {
  def take(): Cards = {
    var carta: Cards = listOfCards.head
    listOfCards = listOfCards.tail
    carta
  }

  def getlistOfCards(): List[Cards] = {
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
  
