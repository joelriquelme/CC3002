
package cl.uchile.dcc.gwent.cards.unitCards



import cl.uchile.dcc.gwent.cards.Card

import java.util.Objects

/**
 * @param name
 * @param strength
 * @param ability
 */
class UnitCard (private val name : String,
                private var strength : Int,
                private val ability : String) extends Card, Equals {

  def play(): Unit = {

  }

  //Getters
  def getname(): String = {
    name
  }
  def getstrength(): Int = {
    strength
  }
  def getability(): String = {
    ability
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[UnitCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[UnitCard]
      (this eq other) ||
        (this.name == other.name && this.strength == other.strength && this.ability == other.ability)
    } else {
      false
    }
  }

  override def hashCode: Int = Objects.hash(classOf[UnitCard], name, strength, ability)
}

