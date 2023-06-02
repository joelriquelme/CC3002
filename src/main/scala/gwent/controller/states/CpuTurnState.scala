package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states.*

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.Card

class CpuTurnState(context: GameController) extends GameState(context){
  override def toHumanTurnState(): Unit = {
    context.state = new HumanTurnState(context)
  }

  override def toHumanLoopState(): Unit = {
    context.state = new HumanLoopState(context)
  }

  override def playCard(card: Card, board: Board): Unit = {
    context.state = new HumanTurnState(context)
  }

  override def pass(): Unit = {
    context.state = new HumanLoopState(context)
  }
    
}
