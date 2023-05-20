import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent
import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.unit.AbstractUnitCard
import cl.uchile.dcc.gwent.cards.unit.subclass.{MeleeCard, RangeCard, SiegeCard}
import cl.uchile.dcc.gwent.deck.Deck
import cl.uchile.dcc.gwent.hand.Hand
import munit.FunSuite

import scala.collection.mutable.{ArrayStack, ListBuffer}

class handTest extends FunSuite{
  var testHand: Hand = _
  var testHand2: Hand = _
  var listOfCards: ListBuffer[Card] = _
  var testDeck: Deck = _
  var A = new MeleeCard("A", 1, "Ab")
  var B = new RangeCard("B", 1, "Ab")
  var C = new SiegeCard("C", 1, "Ab")
  var testBoard: Board = new Board()
  
  override def beforeEach(context: BeforeEach): Unit = {
    listOfCards = ListBuffer(A,B,C)
    testHand = new Hand(listOfCards)
    testHand2 = new Hand(listOfCards)
    testDeck = new Deck(listOfCards)
    testBoard = new Board()
  }

  test("A hand can be create with a list of cards") {
    assertEquals(testHand.getlistOfCards(), listOfCards)
  }
  test("If you play a card of a hand, the length of the hand decreases by 1") {
    testHand.playHuman(B, testBoard)
    assertEquals(testHand.getlistOfCards().length, 2)
  }
  test("If you take a card of a hand, the length of the hand creases by 1") {
    testHand.take(testDeck)
    assertEquals(testHand.getlistOfCards().length, 4)
  }
  test("Testing an equals method for hand class"){
    assert(testHand.equals(testHand2))
    assert(testHand2.equals(testHand))
    assert(!testHand.equals("Test"))
    assert(testHand.hashCode == testHand2.hashCode)
  }
}
