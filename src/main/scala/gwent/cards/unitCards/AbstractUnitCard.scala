
package cl.uchile.dcc.gwent.cards.unitCards



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
  
  def play(): Unit 

  /** Getter of the param name. */
  def getname(): String = {
    name
  }
  /** Getter of the param strength. */
  def getstrength(): Int = {
    strength
  }
  /** Getter of the param ability. */
  def getability(): String = {
    ability
  }
}

