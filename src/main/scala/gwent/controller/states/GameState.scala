package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

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

  def doAction(): Unit = {
    // do nothing
  }

  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }
}
