package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states._

class PreGameState(context: GameController) extends GameState(context){
  override def toPreGameState(): Unit = {
    context.state = new PreGameState(context)
  }
}
