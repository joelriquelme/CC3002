import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent
import cl.uchile.dcc.gwent.cards.unitCards.UnitCard
import munit.FunSuite

class handTest extends FunSuite{
  var testHand: Hand = _
  var testHand2: Hand = _
  var listOfCards: List[Card] = _
  var testDeck: Deck = _
  var A = new UnitCard("A", 1, "Ab")
  var B = new UnitCard("B", 1, "Ab")
  var C = new UnitCard("C", 1, "Ab")
  
  override def beforeEach(context: BeforeEach): Unit = {
    listOfCards = List(A,B,C)
    testHand = new Hand(listOfCards)
    testHand2 = new Hand(listOfCards)
    testDeck = new Deck(listOfCards)
  }

  test("A deck can be create with a list of cards") {
    assertEquals(testHand.getlistOfCards(), listOfCards)
  }
  test("If you play a card of a hand, the length of the hand decreases by 1") {
    testHand.play(B)
    assertEquals(testHand.getlistOfCards().length, 2)
  }
  test("If you take a card of a hand, the length of the hand creases by 1") {
    testHand.take(testDeck)
    assertEquals(testHand.getlistOfCards().length, 4)
  }
  test("Testing an equals method for hand class"){
    assert(testHand.equals(testHand2))
    assert(testHand2.equals(testHand))
  }
}
