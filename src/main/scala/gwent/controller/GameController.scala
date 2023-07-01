package cl.uchile.dcc
package gwent.controller

import gwent.controller.states.*

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.Card
import cl.uchile.dcc.gwent.model.players.IPlayer

class GameController extends Observer {
  var state: GameState = new PreGameState(this)

  def updatePlayer(o: IPlayer, arg: Any): Unit = {
    if (arg.asInstanceOf[Int] <= 0) {
      println("Game Over, The cpu wins!")
    }
    else {
      println(s"Player has $arg gems remaining.")
    }
  }

  def updateCpu(o: IPlayer, arg: Any): Unit = {
    if (arg.asInstanceOf[Int] <= 0) {
      println("Game Over, The player wins!")
    }
    else {
      println(s"Enemy has $arg gems remaining.")
    }
  }

  def startGame(): Unit = {
    state.startGame()
  }

  def playCard(card: Card, board: Board): Unit = {
    state.playCard(card, board)
  }

  def pass(): Unit = {
    state.pass()
  }

  def shuffleAndDraw(): Unit = {
    state.shuffleAndDraw()
  }

  def endGame(): Unit = {
    state.endGame()
  }

  def reset(): Unit = {
    state.reset()
  }

  def isCpuLoopState(): Boolean = state.isCpuLoopState()
  def isCpuTurnState(): Boolean = state.isCpuTurnState()
  def isGameOverState(): Boolean = state.isGameOverState()
  def isHumanLoopState(): Boolean = state.isHumanLoopState()
  def isHumanTurnState(): Boolean = state.isHumanTurnState()
  def isNewRoundState(): Boolean = state.isNewRoundState()
  def isPreGameState(): Boolean = state.isPreGameState()
}
