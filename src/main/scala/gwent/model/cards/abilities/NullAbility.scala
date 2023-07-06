package cl.uchile.dcc
package gwent.model.cards.abilities

import gwent.model.cards.Card
import gwent.model.cards.unit.IUnitCard

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.abilities.customException.InvalidAbilityMethodException
import cl.uchile.dcc.gwent.model.cards.weather.WeatherCard

import scala.collection.mutable.ListBuffer

class NullAbility extends Ability{
  override def apply(self:Card, zone: ListBuffer[IUnitCard]): Unit = {
    //do nothing
  }

  def doEffect(self: WeatherCard, board: Board): Unit = {
    throw new InvalidAbilityMethodException("Cannot use doEffect in UnitCard Abilities")
  }

}
