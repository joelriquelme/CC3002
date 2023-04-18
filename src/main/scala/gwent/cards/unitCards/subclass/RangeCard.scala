package cl.uchile.dcc
package gwent.cards.unitCards.subclass

import gwent.cards.unitCards.UnitCard

import java.util.Objects

/**
 * @param name
 * @param strength
 * @param ability
 */
class RangeCard (private val name : String,
                private var strength : Int,
                private val ability : String) extends UnitCard (name, strength, ability), Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[RangeCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[RangeCard]
      (this eq other) ||
        (this.name == other.name && this.strength == other.strength && this.ability == other.ability && this.hashCode == other.hashCode)
    } else {
      false
    }
  }

  override def hashCode: Int = Objects.hash(classOf[RangeCard], name, strength, ability)  
}
