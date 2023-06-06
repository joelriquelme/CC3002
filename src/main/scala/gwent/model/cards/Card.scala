package cl.uchile.dcc
package gwent.model.cards

import cl.uchile.dcc.gwent.model.board.Board
trait Card {
  def playHuman(b: Board): Unit
  def playCpu(b: Board): Unit
}
