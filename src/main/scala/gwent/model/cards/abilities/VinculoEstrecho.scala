package cl.uchile.dcc
package gwent.model.cards.abilities
import gwent.model.cards.Card
import gwent.model.cards.unit.IUnitCard

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.abilities.customException.InvalidAbilityMethod
import cl.uchile.dcc.gwent.model.cards.weather.WeatherCard

import scala.collection.mutable.ListBuffer

class VinculoEstrecho extends Ability {
  class Existe extends Exception
  
  override def apply(self: Card, zone: ListBuffer[IUnitCard]): Unit = {
    var count = 0
    try {
      for (c <- zone) {
        if (c.getname() == self.getname()) count += 1
        if (count > 1) throw new Existe
      }
    } catch {
      case e: Existe => for (c <- zone) {
        if (c.getname() == self.getname()) {
          c.setstrength(c.getstrength() * 2)
        }
      }
    }
  }

  def doEffect(self: WeatherCard, board: Board): Unit = {
      throw new InvalidAbilityMethod("Cannot use doEffect in UnitCard Abilities")
  }
}





