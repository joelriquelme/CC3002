package cl.uchile.dcc
package gwent.cards.unitCards.subclass

import gwent.cards.unitCards.UnitCard

import java.util.Objects

/** A class represent a SiegeCard.
 *
 * A SiegeCard is a subclass of UnitCard and is defined by a name, strength
 * and an ability, all greater than zero or non-void string according to the case.
 *
 * @param name The name of the card.
 * @param strength The strength of the card.
 * @param ability The ability of the card.
 *
 * @constructor Creates a new SiegeCard with the specified name, strength and ability.
 *
 * @example
 * {{{
 * val SiegeCard = new ClimateCard("Archer","Power of the wind")
 * }}}
 *
 * @author Joel Riquelme
 * @since 1.0.0
 * @version 1.0.0
 */
class SiegeCard (private val name : String,
                 private var strength : Int,
                 private val ability : String) extends UnitCard (name, strength, ability), Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[SiegeCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[SiegeCard]
      (this eq other) ||
        (this.name == other.name && this.strength == other.strength && this.ability == other.ability)
    } else {
      false
    }
  }

  override def hashCode: Int = Objects.hash(classOf[SiegeCard], name, strength, ability)  
}


