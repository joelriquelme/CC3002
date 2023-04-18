package cl.uchile.dcc
package gwent.cards.climateCards

import gwent.cards.Cards

import java.util.Objects

class ClimateCard (private val name : String,
                private val ability : String) extends Cards, Equals {

  def play(): Unit = {

  }
  //Getters
  def getname(): String = {
    name
  }
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

  override def hashCode: Int = Objects.hash(classOf[ClimateCard], name, ability)
  
  
}
