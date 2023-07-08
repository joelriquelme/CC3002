package cl.uchile.dcc
package gwent.model.cards.abilities

import gwent.model.cards.Card
import gwent.model.cards.unit.IUnitCard

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.abilities.customException.InvalidAbilityMethodException
import cl.uchile.dcc.gwent.model.cards.weather.WeatherCard

import scala.collection.mutable.ListBuffer

/** This class represents an ability that does nothing.
 * 
 * @constructor creates a new NullAbility instance.
 * 
 * @example {{{
 *          val nullAbility = new NullAbility()
 *          val card = new UnitCard("cardName", 0, nullAbility)
 *          }}}
 *          
 * @author Joel Riquelme
 * @since  1.0
 * @version 1.0
 */
class NullAbility extends Ability{
  
  /** Does nothing.
   * 
   * @param self the card that has this ability.
   * @param zone the zone where the card is.
   */
  override def apply(self:Card, zone: ListBuffer[IUnitCard]): Unit = {
    //do nothing
  }

  /** If this method is called, an exception is thrown.
   * 
   * @param self the card that has this ability.
   * @param board the board where the card is.
   * @throws InvalidAbilityMethodException if this method is called.
   */
  def doEffect(self: WeatherCard, board: Board): Unit = {
    throw new InvalidAbilityMethodException("Cannot use doEffect in UnitCard Abilities")
  }

}
