package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states.*

import cl.uchile.dcc.gwent.model.board.Board

class GameOverState(context: GameController) extends GameState(context) {

  override def isGameOverState(): Boolean = true

  override def reset(): Unit = {
    context.board = new Board()
    context.state = new PreGameState(context)
  }
}
