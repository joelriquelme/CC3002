package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states._

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.Card

class HumanTurnState(context: GameController) extends GameState(context){
  override def toCpuTurnState(): Unit = {
    context.state = new CpuTurnState(context)
  }

  override def toCpuLoopState(): Unit = {
    context.state = new CpuLoopState(context)
  }

  override def playCard(card: Card, board: Board): Unit = {
    context.state = new CpuTurnState(context)
  }

  override def pass(): Unit = {
    context.state = new CpuLoopState(context)
  }

}
