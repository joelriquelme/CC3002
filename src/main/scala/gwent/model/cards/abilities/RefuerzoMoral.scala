package cl.uchile.dcc
package gwent.model.cards.abilities

import gwent.model.cards.Card

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.unit.{AbstractUnitCard, IUnitCard}

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
}
