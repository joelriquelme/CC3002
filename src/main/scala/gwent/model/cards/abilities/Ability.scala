package cl.uchile.dcc
package gwent.model.cards.abilities

import gwent.model.cards.Card

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.unit.IUnitCard
import cl.uchile.dcc.gwent.model.cards.weather.WeatherCard

import java.util.Objects
import scala.collection.mutable.ListBuffer

trait Ability extends Equals{
  def apply(self:Card, zone: ListBuffer[IUnitCard]): Unit

  def canEqual(other: Any): Boolean = other.isInstanceOf[Ability]
  
  def doEffect(self: WeatherCard, board: Board): Unit
  

  override def equals(other: Any): Boolean = other match {
    case that: Ability =>
      (that canEqual this) &&
        this.getClass == that.getClass
    case _ => false
  }

  override def hashCode(): Int = Objects.hash(classOf[Ability])

}
