package cl.uchile.dcc
package gwent.model.cards

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.abilities.Ability
trait Card {
  def playHuman(b: Board): Unit
  def playCpu(b: Board): Unit
  def getname() : String
}
