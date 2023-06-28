import cl.uchile.dcc.gwent
import cl.uchile.dcc.gwent.model.cards.Card
import cl.uchile.dcc.gwent.model.cards.abilities.NullAbility
import cl.uchile.dcc.gwent.model.cards.unit.AbstractUnitCard
import cl.uchile.dcc.gwent.model.cards.unit.subclass.{MeleeCard, RangeCard, SiegeCard}
import cl.uchile.dcc.gwent.model.deck.Deck
import munit.FunSuite

import scala.collection.mutable.ListBuffer



class deckTest extends FunSuite{
  var testDeck: Deck = _
  var testDeck2: Deck = _
  var listOfCards: ListBuffer[Card] = _

  override def beforeEach(context: BeforeEach): Unit = {
    listOfCards = ListBuffer[Card](
      new MeleeCard("A",1,new NullAbility),
      new RangeCard("B",1,new NullAbility),
      new SiegeCard("C",1,new NullAbility),
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
    assert(!testDeck.equals("Test"))
    assert(testDeck.hashCode == testDeck2.hashCode)
  }
  test("A deck can be shuffled"){
    assertEquals(testDeck.getlistOfCards().size,3)
    testDeck.shuffleDeck()
    assertEquals(testDeck.getlistOfCards().size,3)
    for(w <- listOfCards){
      assert(testDeck.getlistOfCards().contains(w))
    }
  }
}