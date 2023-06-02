package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states._

class HumanLoopState(context: GameController) extends GameState(context){
  override def toNewRoundState(): Unit = {
    context.state = new NewRoundState(context)
  }

  override def toHumanLoopState(): Unit = {
    context.state = new HumanLoopState(context)
  }
}
