package cl.uchile.dcc
package gwent.model.cards.abilities

import gwent.model.cards.Card

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.abilities.customException.InvalidAbilityMethodException
import cl.uchile.dcc.gwent.model.cards.unit.{AbstractUnitCard, IUnitCard}
import cl.uchile.dcc.gwent.model.cards.weather.WeatherCard

import scala.collection.mutable.ListBuffer

/**  This class represents the ability of a card that increases the strength of all cards in his row
 *  except itself.
 *  
 *  The increase is of 1 point.
 *  
 *  @constructor create a new instance of the ability RefuerzoMoral.
 *  
 *  @example {{{
 *           val ability = new RefuerzoMoral
 *           val card = new UnitCard("card", 2, ability)
 *           }}}
 *  
 *  @author Joel Riquelme
 *  @since 1.0
 *  @version 1.0
 *  
 */
class RefuerzoMoral extends Ability {
  
  /** Increases the strength of all cards in his row except itself.
   * 
   * The increase is of 1 point.
   *
   * @param self the card that has this ability.
   * @param zone the zone where the card is.
   *             
   * @example {{{
   *          val ability = new RefuerzoMoral
   *          val card = new UnitCard("card", 2, ability)
   *          val zone = ListBuffer(card)
   *          ability(card, zone)
   *          }}}
   */
  override def apply(self: Card, zone: ListBuffer[IUnitCard]): Unit = {
    for (c <- zone){
      if (c != self) {
        val temp = c.getstrength()
        c.setstrength(temp + 1)
      }
    }
  }

  /** If this method is called, an exception is thrown.
   *
   * @param self  the card that has this ability.
   * @param board the board where the card is.
   * @throws InvalidAbilityMethodException if this method is called.
   */
  def doEffect(self: WeatherCard, board: Board): Unit = {
    throw new InvalidAbilityMethodException("Cannot use doEffect in UnitCard Abilities")
  }
}
