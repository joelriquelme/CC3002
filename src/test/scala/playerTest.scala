
import cl.uchile.dcc.gwent
import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent.cards.unitCards.UnitCard
import munit.FunSuite

class playerTest extends FunSuite {
  val name = "TestName"
  var gems = 2
  var deck : Deck = _
  var hand : Hand = _
  var player1 : Player = _
  var player2 : Player = _
  var listOfCards: List[Card] = _

  override def beforeEach(context: BeforeEach): Unit = {
    listOfCards = List[Card](
      new UnitCard("A", 1, "Ab"),
      new UnitCard("B", 1, "Ab"),
      new UnitCard("C", 1, "Ab"),
    )
    deck = new Deck(listOfCards)
    hand = new Hand(listOfCards)
    player1 = new Player(name, gems, deck, hand)
    player2 = new Player(name, gems, deck, hand)
  }

  test("A player can be created with a name, gems, deck and hand") {
    assertEquals(player1.getname(), name)
    assertEquals(player1.getgems(), gems)
    assert(player1.getgems() <= 2 )
    assert(player1.getgems() >= 0 )
    assertEquals(player1.getdeck(), deck)
    assertEquals(player1.gethand(), hand)
  }
  test("If you play a card, the length of your hand decrease by 1"){
    player1.playCard(new UnitCard("A", 1, "Ab"))
    assertEquals(player1.gethand().getlistOfCards().length, 2 )
  }
  test("If you take a card, the length of your deck decrease by 1 and you hand increase by 2"){
    player1.takeCard()
    assertEquals(player1.gethand().getlistOfCards().length, 4 )
    assertEquals(player1.getdeck().getlistOfCards().length, 2 )
  }
  test("Testing an equals method for deck class") {
    assert(player1.equals(player2))
  }
}
