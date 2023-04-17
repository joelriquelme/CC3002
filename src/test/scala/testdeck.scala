/* import cl.uchile.dcc.gwent.cards.Cards
import cl.uchile.dcc.gwent.cards.unitCards.UnitCard
import cl.uchile.dcc.gwent
import munit.FunSuite

class testdeck extends FunSuite{
  var testDeck: Deck = _
  var listOfCards: Any = _

  override def beforeEach(context: BeforeEach): Unit = {
    listOfCards = List(
      new UnitCard("A",1,"Ab"),
      new UnitCard("B",1,"Ab"),
      new UnitCard("C",1,"Ab"))
    testDeck = new Deck(listOfCards)
  }
  test("A deck can be create with a list of cards") {
    assertEquals(testDeck.listOfCards, listOfCards)
  }
  test("If you pick a card of a deck, the length of the deck decreases by 1"){
    testDeck.take()
    assertEquals(testDeck.listOfCards.length, 2)
  }
  test("You can only take the card of the top of the desk"){
    assertEquals(testDeck.take(), listOfCards.head)
    listOfCards = listOfCards.tail
    assertEquals(testDeck.take(), listOfCards.head)
  }

}

 */
