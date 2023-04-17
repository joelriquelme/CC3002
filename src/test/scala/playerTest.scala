/* package cl.uchile.dcc

import cl.uchile.dcc.gwent.deck.Deck
import cl.uchile.dcc.gwent.players.Player
import munit.FunSuite

class playerTest extends FunSuite {
  val name = "TestName"
  var gems = 2
  val deck : Deck = null
  val hand : Hand = null
  val player : Player = null

  override def beforeEach(context: BeforeEach): Unit = {
    val deck = new Deck()
    val hand = new Hand()
    val player = new Player(name, gems, deck, hand)
  }

  test("A player can be created with a name, gems, deck and hand") {
    assertNotEquals(player.name, "") // name cant be void string
    assertEquals(player.name, name)
    assertEquals(player.gems, gems)
    assert(player.gems <= 2 )
    assert(player.gems >= 0 )
    assertEquals(player.deck, deck)
    assertEquals(player.hand, hand)
  }
}


 */