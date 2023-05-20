package cl.uchile.dcc
package gwent.cards

import gwent.board.Board
trait Card {
  def playHuman(b: Board): Unit
  def playCpu(b: Board): Unit
}
