package cl.uchile.dcc
package modelTests.boardTests

import cl.uchile.dcc.gwent
import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.Card
import cl.uchile.dcc.gwent.model.cards.abilities.NullAbility
import cl.uchile.dcc.gwent.model.cards.unit.AbstractUnitCard
import cl.uchile.dcc.gwent.model.cards.unit.subclass.{MeleeCard, RangeCard, SiegeCard}
import cl.uchile.dcc.gwent.model.cards.weather.WeatherCard
import cl.uchile.dcc.gwent.model.deck.Deck
import cl.uchile.dcc.gwent.model.hand.Hand
import cl.uchile.dcc.gwent.model.players.{Cpu, Player}
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class boardTest extends FunSuite {
  var testBoard: Board = new Board()
  val A = new MeleeCard("A", 1, new NullAbility)
  val B = new RangeCard("B", 1, new NullAbility)
  val C = new SiegeCard("C", 1, new NullAbility)
  val W = new WeatherCard("W", new NullAbility)
  val W2 = new WeatherCard("W2", new NullAbility)
  var gems = 2
  var deck: Deck = _
  var hand: Hand = _
  var player1: Player = _
  var player2: Cpu = _
  var listOfCards: ListBuffer[Card] = _

  override def beforeEach(context: BeforeEach): Unit = {
    testBoard = new Board()
    listOfCards = ListBuffer(A,B,C,W,W2)
    deck = new Deck(listOfCards)
    hand = new Hand(listOfCards)
    player1 = new Player("Human", gems, deck, hand)
    player2 = new Cpu("Cpu", gems, deck, hand)
  }

  test("A board can be create") {
    assertEquals(new Board(), new Board())
  }

  test("If a Human plays a unit card, the card go to the right side of the board") {
    player1.playCard(A,testBoard)
    assert(testBoard.getmeleePlayerZone().contains(A))
    player1.playCard(B,testBoard)
    assert(testBoard.getrangePlayerZone().contains(B))
    player1.playCard(C, testBoard)
    assert(testBoard.getsiegePlayerZone().contains(C))
  }

  test("If a Cpu plays a unit card, the card go to the right side of the board") {
    player2.playCard(A, testBoard)
    assert(testBoard.getmeleeCpuZone().contains(A))
    player2.playCard(B, testBoard)
    assert(testBoard.getrangeCpuZone().contains(B))
    player2.playCard(C, testBoard)
    assert(testBoard.getsiegeCpuZone().contains(C))
  }

  test("If a Human plays a weather card, the card go to the right side of the board") {
    player1.playCard(W, testBoard)
    assert(testBoard.getweatherZone().contains(W))
  }

  test("If a Cpu plays a weather card, the card go to the right side of the board") {
    player2.playCard(W, testBoard)
    assert(testBoard.getweatherZone().contains(W))
  }

  test("When a player plays a weather card, it is replaced by the one that was on the board"){
    player1.playCard(W, testBoard)
    player2.playCard(W2, testBoard)
    assert(testBoard.getweatherZone().contains(W2))
    assert(!testBoard.getweatherZone().contains(W))
  }

  test("Testing an equals method for board class") {
    assert(testBoard.equals(new Board()))
    assert((new Board()).equals(testBoard))
    assert(!testBoard.equals("Test"))
    assert(testBoard.hashCode == (new Board()).hashCode)
  }
}
