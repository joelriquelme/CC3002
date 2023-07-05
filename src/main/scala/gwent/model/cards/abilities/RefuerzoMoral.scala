package cl.uchile.dcc
package gwent.model.cards.abilities

import gwent.model.cards.Card

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.abilities.customException.InvalidAbilityMethod
import cl.uchile.dcc.gwent.model.cards.unit.{AbstractUnitCard, IUnitCard}
import cl.uchile.dcc.gwent.model.cards.weather.WeatherCard

import scala.collection.mutable.ListBuffer

class RefuerzoMoral extends Ability {
  override def apply(self: Card, zone: ListBuffer[IUnitCard]): Unit = {
    for (c <- zone){
      if (c != self) {
        var temp = c.getstrength()
        c.setstrength(temp + 1)
      }
    }
  }

  def doEffect(self: WeatherCard, board: Board): Unit = {
    throw new InvalidAbilityMethod("Cannot use doEffect in UnitCard Abilities")
  }
}
