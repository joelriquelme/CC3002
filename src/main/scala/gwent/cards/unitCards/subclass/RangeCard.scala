package cl.uchile.dcc
package gwent.cards.unitCards.subclass

import gwent.cards.unitCards.UnitCard

import java.util.Objects

/** A class represent a RangeCard.
 *
 * A RangeCard is a subclass of UnitCard and is defined by a name, strength
 * and an ability, all greater than zero or non-void string according to the case.
 *
 * @param name The name of the card.
 * @param strength The strength of the card.
 * @param ability The ability of the card.
 *
 * @constructor Creates a new RangeCard with the specified name, strength and ability.
 *
 * @example
 * {{{
 * val RangeCard = new ClimateCard("Archer","Power of the wind")
 * }}}
 *
 * @author Joel Riquelme
 * @since 1.0.0
 * @version 1.0.0
 */
class RangeCard (private val name : String,
                private var strength : Int,
                private val ability : String) extends UnitCard (name, strength, ability), Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[RangeCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[RangeCard]
      (this eq other) ||
        (this.name == other.name && this.strength == other.strength && this.ability == other.ability)
    } else {
      false
    }
  }

  override def hashCode: Int = Objects.hash(classOf[RangeCard], name, strength, ability)  
}
