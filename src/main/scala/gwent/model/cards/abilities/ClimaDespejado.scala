package cl.uchile.dcc
package gwent.model.cards.abilities

import gwent.model.cards.Card
import gwent.model.cards.unit.IUnitCard

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.weather.WeatherCard

import scala.collection.mutable.ListBuffer

class ClimaDespejado extends Ability {
  override def apply(self: Card, zone: ListBuffer[IUnitCard]): Unit = {
    zone.foreach(card => card.setweakness(false))
  }

  def doEffect(self: WeatherCard, board: Board): Unit = {
    board.effectToAll(self, this)
  }
}
