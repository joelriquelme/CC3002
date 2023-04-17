import cl.uchile.dcc.gwent.cards.Cards

class Player (private val name : String,
              private var gems : Int,
              private val deck : Deck,
              private val hand : Hand){
  
  def playCard(carta: Cards): Unit = {
    hand.play(carta)
  }

  def takeCard() : Unit = {
    hand.take(deck)
  }
}
