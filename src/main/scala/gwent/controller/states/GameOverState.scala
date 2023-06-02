package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states._

class GameOverState(context: GameController) extends GameState(context) {
  override def toPreGameState(): Unit = {
    context.state = new PreGameState(context)
  }
}
