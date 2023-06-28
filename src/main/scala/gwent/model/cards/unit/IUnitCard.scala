package cl.uchile.dcc
package gwent.model.cards.unit

import gwent.model.cards.Card

trait IUnitCard extends Card {
  def getstrength(): Int
  def setstrength(s: Int): Unit
  def getname(): String
}
