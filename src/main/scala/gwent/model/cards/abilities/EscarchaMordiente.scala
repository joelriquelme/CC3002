package cl.uchile.dcc
package gwent.model.cards.abilities
import gwent.model.cards.Card
import gwent.model.cards.unit.IUnitCard

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.weather.WeatherCard

import scala.collection.mutable.ListBuffer

/**
 * This ability is triggered when a weather card is played.
 * 
 * It sets the weakness of all cards in the melee row to true.
 * That means that all cards in the melee row will have their
 * strength set at 1.
 * 
 * @constructor creates a new EscarchaMordiente instance.
 * 
 * @example {{{
 *          val ability = new EscarchaMordiente()
 *          val card = new WeatherCard("Escarcha", ability)
 *          }}}
 *          
 * @author Joel Riquelme
 * @since 1.0
 * @version 1.0
 *          
  */
class EscarchaMordiente extends Ability {
  
  /**
   * Sets the weakness of all cards in the melee row to true.
   * 
   * @param self the card that has this ability.
   * @param zone the zone where the ability will be applied.
   * 
   * @example {{{
   *          val ability = new EscarchaMordiente()
   *          val card = new WeatherCard("Escarcha", ability)
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
    zone.foreach(card => card.setweakness(true))
  }

  /** This method call to the effectToMelee method of the board, passing this ability and the card that has this ability.
   *
   * @param self  the card that has this ability.
   * @param board the board where the ability will be applied.
   * @example {{{
   *          val ability = new EscarchaMordiente()
   *          val card = new WeatherCard("Escarcha", ability)
   *          val board = new Board()
   *          ability.doEffect(card, board)
   *          }}}
   */
  def doEffect(self: WeatherCard, board: Board): Unit = {
    board.effectToMelee(self, this)
  }
}
