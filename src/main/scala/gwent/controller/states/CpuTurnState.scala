package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states.*
import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.Card

class CpuTurnState(context: GameController) extends GameState(context){

  override def isCpuTurnState(): Boolean = true

  override def playCard(card: Card, board: Board): Unit = {
    context.cpuCharacters.foreach(c => c.playCard(card, board))
    context.state = new HumanTurnState(context)
  }

  override def pass(): Unit = {
    context.state = new HumanLoopState(context)
  }

}
