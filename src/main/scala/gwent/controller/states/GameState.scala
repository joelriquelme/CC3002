package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import cl.uchile.dcc.gwent.controller.states._
import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.Card

class GameState(val context: GameController) {
  context.state = this

  def isCpuLoopState(): Boolean = false

  def isCpuTurnState(): Boolean = false

  def isGameOverState(): Boolean = false

  def isHumanLoopState(): Boolean = false

  def isHumanTurnState(): Boolean = false

  def isNewRoundState(): Boolean = false

  def isPreGameState(): Boolean = false
  
  def startGame(): Unit = actionError("startGame")

  def playCard(card: Card, board: Board): Unit = actionError("playCard")

  def pass(): Unit = actionError("pass")

  def shuffleAndDraw(): Unit = actionError("shuffleAndDraw")

  def endGame(): Unit = actionError("endGame")

  def reset(): Unit = actionError("reset")

  private def actionError(action: String): Unit = {
    throw new InvalidActionException(
      s"Cannot perform $action in ${getClass.getSimpleName}"
    )
  }
}
