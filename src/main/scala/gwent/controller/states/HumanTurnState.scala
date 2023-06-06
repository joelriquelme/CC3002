package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states._
import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.Card

class HumanTurnState(context: GameController) extends GameState(context){

  override def isHumanTurnState(): Boolean = true

  override def playCard(card: Card, board: Board): Unit = {
    context.state = new CpuTurnState(context)
  }

  override def pass(): Unit = {
    context.state = new CpuLoopState(context)
  }

}
