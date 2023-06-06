package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states._

class PreGameState(context: GameController) extends GameState(context){

  override def isPreGameState(): Boolean = true

  override def startGame(): Unit = {
    context.state = new HumanTurnState(context)
  }
}
