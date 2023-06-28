package cl.uchile.dcc
package gwent.model.cards.abilities

import gwent.model.cards.Card
import gwent.model.cards.unit.IUnitCard

import scala.collection.mutable.ListBuffer

class NullAbility extends Ability{
  override def apply(self:Card, zone: ListBuffer[IUnitCard]): Unit = {
    //do nothing
  }

}
