package cl.uchile.dcc
package gwent.cards.unitCards.subclass

import gwent.cards.unitCards.UnitCard

import java.util.Objects

/**
 * @param name
 * @param strength
 * @param ability
 */
class MeleeCard (private val name : String, 
                 private var strength : Int, 
                 private val ability : String) extends UnitCard (name, strength, ability), Equals {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[MeleeCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[MeleeCard]
      (this eq other) ||
        (this.name == other.name && this.strength == other.strength && this.ability == other.ability)
    } else {
      false
    }
  }

  override def hashCode: Int = Objects.hash(classOf[SiegeCard], name, strength, ability)
}
