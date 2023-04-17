/* package cl.uchile.dcc

import cl.uchile.dcc.gwent.cards.Cards
import cl.uchile.dcc.gwent.deck.Deck
import cl.uchile.dcc.gwent.hand.Hand
import munit.FunSuite

class handTest extends FunSuite{
  var testHand: Hand = _
  var listOfCards: Any = _
  var testDeck: Deck = _
  var A = new UnitCard("A", 1, "Ab")
  var B = new UnitCard("B", 1, "Ab")
  var C = new UnitCard("C", 1, "Ab")
  
  override def beforeEach(context: BeforeEach): Unit = {
    listOfCards = List(A,B,C)
    testHand = new Hand(listOfCards)
    testDeck = new Deck(listOfCards)
  }

  test("A deck can be create with a list of cards") {
    assertEquals(testHand.listOfCards, listOfCards)
  }
  test("If you play a card of a hand, the length of the hand decreases by 1") {
    testHand.play(B)
    assertEquals(testHand.listOfCards.length, 2)
  }
  test("If you take a card of a hand, the length of the hand creases by 1") {
    testHand.take(testDeck)
    assertEquals(testHand.listOfCards.length, 4)
  }
}
*/