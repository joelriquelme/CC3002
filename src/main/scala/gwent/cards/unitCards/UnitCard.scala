
package cl.uchile.dcc
package gwent.cards.unitCards

import gwent.cards

import cl.uchile.dcc.gwent.cards.Cards

/**
 * @param name
 * @param strength
 * @param ability
 */
class UnitCard (private val name : String,
                private var strength : Int,
                private val ability : String) extends Cards {

  def play: Unit = {

  }
}
