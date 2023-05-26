
package cl.uchile.dcc
package gwent.cards.unit

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.Card

import java.util.Objects

/** A class represent a UnitCard.
 *
 * A UnitCard is defined by a name, strength
 * and an ability, all greater than zero or non-void string according to the case.
 *
 * @param name The name of the card.
 * @param strength The strength of the card.
 * @param ability The ability of the card.
 *
 * @constructor Creates a new UnitCard with the specified name, strength and ability.
 *
 * @example
 * {{{
 * val UnitCard = new UnitCard("Archer","Power of the wind")
 * }}}
 *
 * @author Joel Riquelme
 * @since 1.0.0
 * @version 1.0.0
 */
abstract class AbstractUnitCard(private val name : String,
                                private var strength : Int,
                                private val ability : String) extends Card, Equals {
  def playHuman(b: Board): Unit

  def playCpu(b: Board): Unit

  /** Getter of the param name. */
  def getname(): String = {
    name
  }

  /** Getter of the param strength. */
  def getstrength(): Int = {
    strength
  }

  /** Setter of the param strength */
  def setstrength(s: Int): Unit = {
    strength = math.max(s,0)
  }

  /** Getter of the param ability. */
  def getability(): String = {
    ability
  }
}