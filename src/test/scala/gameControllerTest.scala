package cl.uchile.dcc

import cl.uchile.dcc.gwent.controller.GameController
import cl.uchile.dcc.gwent.controller.states.InvalidActionException
import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.abilities.NullAbility
import cl.uchile.dcc.gwent.model.cards.unit.subclass.MeleeCard
import cl.uchile.dcc.gwent.model.deck.Deck
import cl.uchile.dcc.gwent.model.hand.Hand
import cl.uchile.dcc.gwent.model.players.{Cpu, Player}
import munit.FunSuite
import org.junit.Assert
import org.junit.runners.model.InvalidTestClassError

import scala.collection.mutable.ListBuffer

class gameControllerTest extends FunSuite {

  var testGame: GameController = new GameController()
  var testBoard: Board = new Board()
  var testCard: MeleeCard = new MeleeCard("test", 1,new NullAbility)
  var testHand: Hand = new Hand(ListBuffer(testCard))
  var testDeck: Deck = new Deck(ListBuffer(testCard))
  var testPlayer: Player = new Player("test", 2, testDeck, testHand)
  var testCpu: Cpu = new Cpu("test", 2, testDeck, testHand)

  override def beforeEach(context: BeforeEach): Unit = {
    testGame = new GameController()
    testBoard = new Board()
    testCard = new MeleeCard("test", 1,new NullAbility)
    testHand = new Hand(ListBuffer(testCard))
    testDeck = new Deck(ListBuffer(testCard))
    testPlayer = new Player("test", 2, testDeck, testHand)
  }

  test("A GameController is initiated in PreGameState") {
    assert(testGame.isPreGameState())
    assert(!testGame.isHumanTurnState())
    assert(!testGame.isCpuTurnState())
    assert(!testGame.isCpuLoopState())
    assert(!testGame.isHumanLoopState())
    assert(!testGame.isNewRoundState())
    assert(!testGame.isGameOverState())
  }

  test("A PreGameState only can change to HumanTurnState"){
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.shuffleAndDraw())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.playCard(testCard,testBoard))
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.pass())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.endGame())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.reset())
    testGame.startGame()
    assert(!testGame.isPreGameState())
    assert(testGame.isHumanTurnState())
    assert(!testGame.isCpuTurnState())
    assert(!testGame.isCpuLoopState())
    assert(!testGame.isHumanLoopState())
    assert(!testGame.isNewRoundState())
    assert(!testGame.isGameOverState())

  }

  test("A HumanTurnState only can change to CpuTurnState or CpuLoopState") {
    testGame.startGame()
    assert(!testGame.isPreGameState())
    assert(testGame.isHumanTurnState())
    assert(!testGame.isCpuTurnState())
    assert(!testGame.isCpuLoopState())
    assert(!testGame.isHumanLoopState())
    assert(!testGame.isNewRoundState())
    assert(!testGame.isGameOverState())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.shuffleAndDraw())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.endGame())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.reset())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.startGame())
    testGame.playCard(testCard, testBoard)
    assert(testGame.isCpuTurnState())
    testGame.playCard(testCard, testBoard)
    assert(testGame.isHumanTurnState())
    testGame.pass()
    assert(testGame.isCpuLoopState())
  }

  test("A CpuTurnState only can change to HumanTurnState or HumanLoopState"){
    testGame.startGame()
    testGame.playCard(testCard, testBoard)
    assert(!testGame.isPreGameState())
    assert(!testGame.isHumanTurnState())
    assert(testGame.isCpuTurnState())
    assert(!testGame.isCpuLoopState())
    assert(!testGame.isHumanLoopState())
    assert(!testGame.isNewRoundState())
    assert(!testGame.isGameOverState())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.shuffleAndDraw())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.endGame())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.reset())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.startGame())
    testGame.playCard(testCard, testBoard)
    assert(testGame.isHumanTurnState())
    testGame.playCard(testCard, testBoard)
    assert(testGame.isCpuTurnState())
    testGame.pass()
    assert(testGame.isHumanLoopState())
  }

  test("A CpuLoopState only can change to CpuLoopState or NewRoundState"){
    testGame.startGame()
    testGame.pass()
    assert(!testGame.isPreGameState())
    assert(!testGame.isHumanTurnState())
    assert(!testGame.isCpuTurnState())
    assert(testGame.isCpuLoopState())
    assert(!testGame.isHumanLoopState())
    assert(!testGame.isNewRoundState())
    assert(!testGame.isGameOverState())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.shuffleAndDraw())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.endGame())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.reset())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.startGame())
    testGame.playCard(testCard, testBoard)
    assert(testGame.isCpuLoopState())
    testGame.pass()
    assert(testGame.isNewRoundState())
  }

  test("A HumanLoopState only can change to HumanLoopState or NewRoundState"){
    testGame.startGame()
    testGame.playCard(testCard, testBoard)
    testGame.pass()
    assert(!testGame.isPreGameState())
    assert(!testGame.isHumanTurnState())
    assert(!testGame.isCpuTurnState())
    assert(!testGame.isCpuLoopState())
    assert(testGame.isHumanLoopState())
    assert(!testGame.isNewRoundState())
    assert(!testGame.isGameOverState())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.shuffleAndDraw())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.endGame())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.reset())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.startGame())
    testGame.playCard(testCard, testBoard)
    assert(testGame.isHumanLoopState())
    testGame.pass()
    assert(testGame.isNewRoundState())
  }

  test("A NewRoundTest only can change to HumanTurnState or GameOverState"){
    testGame.startGame()
    testGame.pass()
    testGame.pass()
    assert(!testGame.isPreGameState())
    assert(!testGame.isHumanTurnState())
    assert(!testGame.isCpuTurnState())
    assert(!testGame.isCpuLoopState())
    assert(!testGame.isHumanLoopState())
    assert(testGame.isNewRoundState())
    assert(!testGame.isGameOverState())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.playCard(testCard,testBoard))
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.pass())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.reset())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.startGame())
    testGame.shuffleAndDraw()
    assert(testGame.isHumanTurnState())
    testGame.pass()
    testGame.pass()
    assert(testGame.isNewRoundState())
    testGame.endGame()
    assert(testGame.isGameOverState())
  }

  test("A GameOverState only can change to PreGameState"){
    testGame.startGame()
    testGame.pass()
    testGame.pass()
    testGame.endGame()
    assert(!testGame.isPreGameState())
    assert(!testGame.isHumanTurnState())
    assert(!testGame.isCpuTurnState())
    assert(!testGame.isCpuLoopState())
    assert(!testGame.isHumanLoopState())
    assert(!testGame.isNewRoundState())
    assert(testGame.isGameOverState())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.playCard(testCard,testBoard))
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.pass())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.startGame())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.endGame())
    Assert.assertThrows(classOf[InvalidActionException], () => testGame.shuffleAndDraw())
    testGame.reset()
    assert(testGame.isPreGameState())
  }
  test("When a player lose a gem is notified"){
    testPlayer.registerObserver(testGame)
    testPlayer.removeOneGem()
    testPlayer.removeOneGem()
  }
  test("When a cpu lose a gem is notified") {
    testCpu.registerObserver(testGame)
    testCpu.removeOneGem()
    testCpu.removeOneGem()
  }
}
