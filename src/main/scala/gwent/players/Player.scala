import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent.players.IPlayer

import java.util.Objects

class Player (private val name : String,
              private var gems : Int,
              private val deck : Deck,
              private val hand : Hand) extends Equals {
  
  def playCard(carta: Card): Unit = {
    hand.play(carta)
  }

  def takeCard() : Unit = {
    hand.take(deck)
  }

  // Getters
  def getname() : String ={
    name
  }
  def getgems(): Int = {
    gems
  }
  def getdeck(): Deck = {
    deck
  }
  def gethand(): Hand = {
    hand
  }

  // Equals
  
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Player]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Player]
      (this eq other) ||
        (this.name == other.name && this.gems == other.gems && this.deck == other.deck && this.hand == other.hand)
    } else {
      false
    }
  }
  
  override def hashCode: Int = Objects.hash(classOf[Player], name, gems, deck, hand)
}
