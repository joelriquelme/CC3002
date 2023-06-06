package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states._

class NewRoundState(context: GameController) extends GameState(context){

  override def isNewRoundState(): Boolean = true

  override def shuffleAndDraw(): Unit = {
    context.state = new HumanTurnState(context)
  }

  override def endGame(): Unit = {
    context.state = new GameOverState(context)
  }
}
