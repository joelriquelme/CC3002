package cl.uchile.dcc
package modelTests.gameTest

import munit.FunSuite
import gwent.presetsItems.{Cpu, Deck1, Deck2, Player, listOfCards}

import cl.uchile.dcc.gwent.controller.GameController

class gameTest extends FunSuite{
  val Cards = listOfCards
  val testDesk1 = Deck1
  val testDesk2 = Deck2
  val testPlayer = Player
  val testCpu = Cpu

  test("A complete game test"){
    val testGame = new GameController //instance of a game
    testGame.createGame(testPlayer,testCpu) //create a new game
    assert(testGame.isPreGameState()) // PreGame State
    testGame.startGame() //start the game
    assert(testGame.isHumanTurnState()) // Human Turn State
    testGame.playCard(testGame.getplayerCharacters()(0).gethand().getlistOfCards()(0),testGame.board) // Human play a card
    assert(testGame.isCpuTurnState()) // Cpu Turn State
    testGame.playCard(Cpu.gethand().getlistOfCards()(0),testGame.board) // Cpu play a card
    assert(testGame.isHumanTurnState()) // Human Turn State
    testGame.playCard(Player.gethand().getlistOfCards()(0),testGame.board) // Human play a card
    testGame.pass() // Cpu pass
    assert(testGame.isHumanLoopState()) // Human Loop State
    testGame.playCard(testGame.getplayerCharacters()(0).gethand().getlistOfCards()(0),testGame.board) // Human play a card
    testGame.playCard(testGame.getplayerCharacters()(0).gethand().getlistOfCards()(0),testGame.board) // Human play a card
    testGame.pass() // Human pass
    assert(testGame.isNewRoundState()) // New Round State
    testGame.shuffleAndDraw()
    assert(testGame.isHumanTurnState()) // Human Turn State
    testGame.pass() // Human pass
    assert(testGame.isCpuLoopState()) // Cpu Loop State
    testGame.pass() // Cpu pass


  }

}
