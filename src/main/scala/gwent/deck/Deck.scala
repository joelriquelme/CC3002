import cl.uchile.dcc.gwent.cards.Cards

class Deck (private var listOfCards : List[Cards]) {
  def take() : Cards = {
    var carta: Cards = listOfCards.head
    listOfCards = listOfCards.tail
    carta
  }

  def getlistOfCards(): List[Cards] = {
    listOfCards
  }
}
