package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states._

class CpuLoopState(context: GameController) extends GameState(context){
  override def toNewRoundState(): Unit = {
    context.state = new NewRoundState(context)
  }

  override def toCpuLoopState(): Unit = {
    context.state = new CpuLoopState(context)
  }
}
