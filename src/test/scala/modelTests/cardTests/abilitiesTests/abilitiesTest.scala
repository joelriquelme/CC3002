package cl.uchile.dcc
package modelTests.cardTests.abilitiesTests

import gwent.model.board.Board
import gwent.model.cards.Card
import gwent.model.cards.abilities.{ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable, NullAbility, RefuerzoMoral, VinculoEstrecho}
import gwent.model.cards.unit.IUnitCard
import gwent.model.cards.unit.subclass.{MeleeCard, RangeCard, SiegeCard}
import gwent.model.cards.weather.WeatherCard
import gwent.model.deck.Deck
import gwent.model.hand.Hand
import gwent.model.players.{Cpu, Player}

import cl.uchile.dcc.gwent.model.cards.abilities.customException.InvalidAbilityMethodException
import munit.FunSuite
import org.junit.Assert
import org.junit.runners.model.InvalidTestClassError

import scala.collection.mutable.ListBuffer

class abilitiesTest extends FunSuite {
  var testBoard: Board = new Board()
  val A = new MeleeCard("A", 4, new NullAbility)
  val B = new RangeCard("B", 1, new NullAbility)
  val C = new SiegeCard("C", 1, new NullAbility)
  val D = new MeleeCard("D", 1, new RefuerzoMoral)
  val E = new MeleeCard("A", 5, new VinculoEstrecho)
  val W = new WeatherCard("W", new EscarchaMordiente)
  val W2 = new WeatherCard("W2", new NieblaImpenetrable)
  val W3 = new WeatherCard("W3", new LluviaTorrencial)
  val W4 = new WeatherCard("W4", new ClimaDespejado)
  var gems = 2
  var deck: Deck = _
  var hand: Hand = _
  var player1: Player = _
  var player2: Cpu = _
  var listOfCards: ListBuffer[Card] = _

  override def beforeEach(context: BeforeEach): Unit = {
    A.setstrength((4))
    B.setstrength((1))
    C.setstrength((1))
    D.setstrength((1))
    E.setstrength((5))
    testBoard = new Board()
    listOfCards = ListBuffer(A, B, C, D, E, W, W2)
    deck = new Deck(listOfCards)
    hand = new Hand(listOfCards)
    player1 = new Player("Human", gems, deck, hand)
    player2 = new Cpu("Cpu", gems, deck, hand)
  }

  test("When you play a card with 'RefuerzoMoral' the ability works"){
    player1.playCard(A, testBoard)
    player1.playCard(D, testBoard)
    assertEquals(testBoard.getmeleePlayerZone().head.getstrength(),5)
    assertEquals(testBoard.getmeleePlayerZone().tail.head.getstrength(),1)
  }

  test("When you play a card with 'VinculoEstrecho' the ability works"){
    player1.playCard(A, testBoard)
    player1.playCard(E, testBoard)
    assertEquals(testBoard.getmeleePlayerZone().tail.head.getstrength(),10)
    assertEquals(testBoard.getmeleePlayerZone().head.getstrength(),8)
  }

  test("When you play a card with 'EscarchaMordiente' the ability works"){
    player1.playCard(A, testBoard)
    player1.playCard(W, testBoard)
    assertEquals(testBoard.getmeleePlayerZone().head.getstrength(),1)
  }

  test( "When you play a card with 'NieblaImpenetrable' the ability works"){
    player1.playCard(B, testBoard)
    player1.playCard(W2, testBoard)
    assertEquals(testBoard.getrangePlayerZone().head.getstrength(),1)
  }

  test("When you play a card with 'LluviaTorrencial' the ability works"){
    player1.playCard(C, testBoard)
    player1.playCard(W3, testBoard)
    assertEquals(testBoard.getsiegePlayerZone().head.getstrength(),1)
  }

  test("When you play a card with 'ClimaDespejado' the ability works"){
    player1.playCard(A, testBoard)
    player1.playCard(W, testBoard)
    assertEquals(testBoard.getmeleePlayerZone().head.getstrength(), 1)
    player1.playCard(W4, testBoard)
    assertEquals(testBoard.getmeleePlayerZone().head.getstrength(),4)
  }

  test("doEffect method throw a InvalidAbilityMethodException"){
    Assert.assertThrows(classOf[InvalidAbilityMethodException], () => A.getability().doEffect(W, testBoard))
    Assert.assertThrows(classOf[InvalidAbilityMethodException], () => D.getability().doEffect(W, testBoard))
    Assert.assertThrows(classOf[InvalidAbilityMethodException], () => E.getability().doEffect(W, testBoard))
  }


  test("Method equals works"){
    val testAb = new NullAbility
    assert(!testAb.equals(A))
  }
}
