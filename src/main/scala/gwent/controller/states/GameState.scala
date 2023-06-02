package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent.controller.states._

class GameState(val context: GameController) {
  context.state = this

  def toHumanTurnState(): Unit = {
    transitionError("HumanTurnState")
  }

  def toCpuTurnState(): Unit = {
    transitionError("CpuTurnState")
  }

  def toHumanLoopState(): Unit = {
    transitionError("HumanLoopState")
  }

  def toCpuLoopState(): Unit = {
    transitionError("CpuLoopState")
  }

  def toNewRoundState(): Unit = {
    transitionError("NewRoundState")
  }

  def toGameOverState(): Unit = {
    transitionError("GameOverState")
  }

  def toPreGameState(): Unit = {
    transitionError("PreGameState")
  }

  def playCard(card: Card, board: Board): Unit = {
    actionError("playCard")
  }

  def pass(): Unit = {
    actionError("pass")
  }

  def shuffleAndDraw(): Unit = {
    actionError("shuffleAndDraw")
  }

  def endGame(): Unit = {
    actionError("endGame")
  }
  
  def reset(): Unit = {
    actionError("reset")
  }

  private def actionError(action: String): Unit = {
    throw new InvalidActionException(
      s"Cannot perform $action in ${getClass.getSimpleName}"
    )
  }

  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }
}
