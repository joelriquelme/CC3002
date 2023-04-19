import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent.cards.unitCards.UnitCard
import cl.uchile.dcc.gwent
import munit.FunSuite

import scala.collection.mutable.ListBuffer



class deckTest extends FunSuite{
  var testDeck: Deck = _
  var testDeck2: Deck = _
  var listOfCards: ListBuffer[Card] = _

  override def beforeEach(context: BeforeEach): Unit = {
    listOfCards = ListBuffer[Card](
      new UnitCard("A",1,"Ab"),
      new UnitCard("B",1,"Ab"),
      new UnitCard("C",1,"Ab"),
    )
    testDeck = new Deck(listOfCards)
    testDeck2 = new Deck(listOfCards)
  }
  test("A deck can be create with a list of cards") {
    assertEquals(testDeck.getlistOfCards(), listOfCards)
  }
  test("If you pick a card of a deck, the length of the deck decreases by 1"){
    testDeck.take()
    var lista = testDeck.getlistOfCards()
    assertEquals(lista.length, 2)
  }
  test("You can only take the card of the top of the desk"){
    assertEquals(testDeck.take(), listOfCards.head)
    listOfCards = listOfCards.tail
    assertEquals(testDeck.take(), listOfCards.head)
  }
  test("Testing an equals method for deck class") {
    assert(testDeck.equals(testDeck2))
    assert(testDeck2.equals(testDeck))
  }
}