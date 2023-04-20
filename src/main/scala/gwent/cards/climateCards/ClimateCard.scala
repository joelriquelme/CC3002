package cl.uchile.dcc
package gwent.cards.climateCards

import gwent.cards.Card

import java.util.Objects

/** A class represent a ClimateCard.
 *
 * A ClimateCard is defined by a name and an ability, both non-voids strings.
 *
 * @param name The name of the card.
 * @param ability The ability of the card.
 *                
 * @constructor Creates a new ClimateCard with the specified name and ability.
 * 
 * @example
 * {{{
 * val climateCard = new ClimateCard("Storm","ability of the storm")
 * }}}
 * 
 * @author Joel Riquelme
 * @since 1.0.0
 * @version 1.0.0
 */
class ClimateCard (private val name : String,
                private val ability : String) extends Card, Equals {
  
  /** Method not implemented yet. */
  def play(): Unit = {}

  /** Getter of the param name. */
  def getname(): String = {
    name
  }

  /** Getter of the param ability. */
  def getability(): String = {
    ability
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[ClimateCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[ClimateCard]
      (this eq other) ||
        (this.name == other.name && this.ability == other.ability)
    } else {
      false
    }
  }

  override def hashCode: Int = Objects.hash(classOf[ClimateCard], name, ability )


}
