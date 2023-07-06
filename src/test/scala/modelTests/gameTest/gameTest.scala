package cl.uchile.dcc
package modelTests.gameTest

import munit.FunSuite
import gwent.presetsItems.{Deck1, Deck2, TCpu, TCpu2, TPlayer, TPlayer2, listOfCards}
import gwent.model.cards.Card
import gwent.controller.GameController

import gwent.model.deck.Deck
import gwent.model.players.{Cpu, Player}

import scala.collection.mutable.ListBuffer

class gameTest extends FunSuite{
  var Cards: ListBuffer[Card] = _
  var testDesk1: Deck = _
  var testDesk2: Deck = _
  var testPlayer: Player = _
  var testPlayer2: Player = _
  var testCpu: Cpu = _
  var testCpu2: Cpu = _
  var testGame: GameController = _
  var testGame2: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    Cards = listOfCards
    testDesk1 = Deck1
    testDesk2 = Deck2
    testPlayer = TPlayer
    testPlayer2 = TPlayer2
    testCpu = TCpu
    testCpu2 = TCpu2
    testGame = new GameController()
    testGame2 = new GameController()

  }

  test("A complete game test, wins the player"){
    testGame.createGame(testPlayer,testCpu) //create a new game
    assert(testGame.isPreGameState()) // PreGame State
    testGame.startGame() //start the game
    assert(testGame.isHumanTurnState()) // Human Turn State
    testGame.playCard(testGame.getplayerCharacters().head.gethand().getlistOfCards().head,testGame.board) // Human play a card
    assert(testGame.isCpuTurnState()) // Cpu Turn State
    testGame.playCard(testGame.getcpuCharacters().head.gethand().getlistOfCards().head,testGame.board) // Cpu play a card
    assert(testGame.isHumanTurnState()) // Human Turn State
    testGame.playCard(testGame.getplayerCharacters().head.gethand().getlistOfCards().head,testGame.board) // Human play a card
    testGame.pass() // Cpu pass
    assert(testGame.isHumanLoopState()) // Human Loop State
    testGame.playCard(testGame.getplayerCharacters().head.gethand().getlistOfCards().head,testGame.board) // Human play a card
    testGame.playCard(testGame.getplayerCharacters().head.gethand().getlistOfCards().head,testGame.board) // Human play a card
    testGame.pass() // Human pass
    assert(testGame.isNewRoundState()) // New Round State
    testGame.shuffleAndDraw()
    assert(testGame.isHumanTurnState()) // Human Turn State
    testGame.pass() // Human pass
    assert(testGame.isCpuLoopState()) // Cpu Loop State
    testGame.pass() // Cpu pass
  }

  test("A complete game test, wins the cpu"){
    testGame2.createGame(testPlayer2, testCpu2) //create a new game
    assert(testGame2.isPreGameState()) // PreGame State
    testGame2.startGame() //start the game
    assert(testGame2.isHumanTurnState()) // Human Turn State
    testGame2.playCard(testGame2.getplayerCharacters().head.gethand().getlistOfCards().head, testGame2.board) // Human play a card
    assert(testGame2.isCpuTurnState()) // Cpu Turn State
    testGame2.playCard(testGame2.getcpuCharacters().head.gethand().getlistOfCards().head, testGame2.board) // Cpu play a card
    assert(testGame2.isHumanTurnState()) // Human Turn State
    testGame2.pass() // Human pass
    assert(testGame2.isCpuLoopState()) // Cpu Loop State
    testGame2.playCard(testGame2.getcpuCharacters().head.gethand().getlistOfCards().head, testGame2.board) // Human play a card
    testGame2.playCard(testGame2.getcpuCharacters().head.gethand().getlistOfCards().head, testGame2.board) // Human play a card
    testGame2.pass() // Cpu pass
    assert(testGame2.isNewRoundState()) // New Round State
    testGame2.shuffleAndDraw()
    assert(testGame2.isHumanTurnState()) // Human Turn State
    testGame2.pass() // Human pass
    assert(testGame2.isCpuLoopState()) // Cpu Loop State
    testGame2.pass() // Cpu pass
  }

}
