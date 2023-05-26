package cl.uchile.dcc

import gwent.board.Board
import gwent.cards.Card
import gwent.cards.unit.subclass.{MeleeCard, RangeCard, SiegeCard}
import gwent.deck.Deck
import gwent.hand.Hand
import gwent.players.{Cpu, Player}

import munit.FunSuite

import scala.collection.mutable.ListBuffer

class cpuTest extends FunSuite {
  val name = "TestName"
  var gems = 2
  var deck : Deck = _
  var hand : Hand = _
  var player1 : Cpu = _
  var player2 : Cpu = _
  var listOfCards: ListBuffer[Card] = _
  var testBoard: Board = new Board()

  override def beforeEach(context: BeforeEach): Unit = {
    listOfCards = ListBuffer[Card](
      new MeleeCard("A", 1, "Ab"),
      new RangeCard("B", 1, "Ab"),
      new SiegeCard("C", 1, "Ab"),
    )
    deck = new Deck(listOfCards)
    hand = new Hand(listOfCards)
    player1 = new Cpu(name, gems, deck, hand)
    player2 = new Cpu(name, gems, deck, hand)
    testBoard = new Board()
  }

  test("A player can be created with a name, gems, deck and hand") {
    assertEquals(player1.getname(), name)
    assertEquals(player1.getgems(), gems)
    assert(player1.getgems() <= 2 )
    assert(player1.getgems() >= 0 )
    player1.setgems(0)
    assert(player1.getgems() == 0)
    player2.setgems(-2)
    assert(player2.getgems() == 0)
    assertEquals(player1.getdeck(), deck)
    assertEquals(player1.gethand(), hand)
  }
  test("If you play a card, the length of your hand decrease by 1"){
    player1.playCard(new MeleeCard("A", 1, "Ab"), testBoard)
    assertEquals(player1.gethand().getlistOfCards().length, 2 )
  }
  test("If you take a card, the length of your deck decrease by 1 and you hand increase by 2"){
    player1.takeCard()
    assertEquals(player1.gethand().getlistOfCards().length, 4 )
    assertEquals(player1.getdeck().getlistOfCards().length, 2 )
  }

  test("Testing an equals method for player class") {
    assert(player1.equals(player2))
    assert(player2.equals(player1))
    assert(!player1.equals("Test"))
    assert(player1.hashCode == player2.hashCode)
  }
}
