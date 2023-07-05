package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states.*

import cl.uchile.dcc.gwent.model.board.Board

class PreGameState(context: GameController) extends GameState(context){

  override def isPreGameState(): Boolean = true

  override def startGame(): Unit = {
    for (p <- context.playerCharacters) {
      p.shuffleDeck()
      var i = 0
      while (i < 10) {
        p.takeCard()
        i += 1
      }
    }
    for (c <- context.cpuCharacters) {
      c.shuffleDeck()
      var i = 0
      while (i < 10) {
        c.takeCard()
        i += 1
      }
    }
    context.state = new HumanTurnState(context)
  }
}
