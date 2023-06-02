package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states._

class HumanTurnState(context: GameController) extends GameState(context){
  override def toCpuTurnState(): Unit = {
    context.state = new CpuTurnState(context)
  }

  override def toCpuLoopState(): Unit = {
    context.state = new CpuLoopState(context)
  }
}
