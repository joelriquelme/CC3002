package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states.*

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.Card

class CpuLoopState(context: GameController) extends GameState(context){
  override def toNewRoundState(): Unit = {
    context.state = new NewRoundState(context)
  }

  override def toCpuLoopState(): Unit = {
    context.state = new CpuLoopState(context)
  }

  override def playCard(card: Card, board: Board): Unit = {
    context.state = new CpuLoopState(context)
  }

  override def pass(): Unit = {
    context.state = new CpuLoopState(context)
  }
}
