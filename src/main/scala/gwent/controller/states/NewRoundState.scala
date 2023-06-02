package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states._

class NewRoundState(context: GameController) extends GameState(context){
  override def toGameOverState(): Unit = {
    context.state = new GameOverState(context)
  }

  override def toHumanTurnState(): Unit = {
    context.state = new HumanTurnState(context)
  }
}
