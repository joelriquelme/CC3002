import cl.uchile.dcc.gwent.cards.Cards
import cl.uchile.dcc.gwent

class Hand (private var listOfCards : List[Cards]){

  def play(c: Cards): Unit = {
    c.play()
    listOfCards.filter(_ equals c)
  }

  def take(deck: Deck) : Unit = {
    listOfCards = deck.take() :: listOfCards
  }
}
