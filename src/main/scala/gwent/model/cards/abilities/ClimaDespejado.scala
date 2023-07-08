package cl.uchile.dcc
package gwent.model.cards.abilities

import gwent.model.cards.Card
import gwent.model.cards.unit.IUnitCard

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.weather.WeatherCard

import scala.collection.mutable.ListBuffer

/** This represents the ability of a card that remove any weather effect on the board.
 * 
 * @constructor creates a new ClimaDespejado instance.
 * 
 * @example {{{
 *          val ability = ClimaDespejado()
 *          val card = new WeatherCard("Sun", ability)
 *          }}}
 *  
 * @see [[cl.uchile.dcc.gwent.model.cards.abilities.Ability]]
 * 
 * @author Joel Riquelme
 * @since 1.0
 * @version 1.0
 *          
 */
class ClimaDespejado extends Ability {
  
  /** This method remove any weather effect on the board.
   * 
   * @param self the card that has this ability.
   * @param zone the zone where the ability will be applied.
   * 
   * @example {{{
   *          val ability = ClimaDespejado()
   *          val card = new WeatherCard("Sun", ability)
   *          val zone = ListBuffer[Card](card)
   *          ability(card, zone)
   *          }}}
   * 
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   *          
   */
  override def apply(self: Card, zone: ListBuffer[IUnitCard]): Unit = {
    zone.foreach(card => card.setweakness(false))
  }

  /** This method call to the effectToAll method of the board, passing this ability and the card that has this ability.
   *
   * @param self the card that has this ability.
   * @param board the board where the ability will be applied.
   * 
   * @example {{{
   *          val ability = ClimaDespejado()
   *          val card = new WeatherCard("Sun", ability)
   *          val board = new Board()
   *          ability.doEffect(card, board)
   *          }}}
   */
  def doEffect(self: WeatherCard, board: Board): Unit = {
    board.effectToAll(self, this)
  }
}
