package cl.uchile.dcc
package gwent.cards

import gwent.board.Board

trait Card {
  /** Method not implemented yet */
  def play(b: Board): Unit
}
