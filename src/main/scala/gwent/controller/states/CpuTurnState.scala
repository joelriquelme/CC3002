package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states._

class CpuTurnState(context: GameController) extends GameState(context){
  override def toHumanTurnState(): Unit = {
    context.state = new HumanTurnState(context)
  }

  override def toHumanLoopState(): Unit = {
    context.state = new HumanLoopState(context)
  }
}
