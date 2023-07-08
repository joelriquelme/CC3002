package cl.uchile.dcc
package gwent.model.cards.abilities
import gwent.model.cards.Card
import gwent.model.cards.unit.IUnitCard

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.abilities.customException.InvalidAbilityMethodException
import cl.uchile.dcc.gwent.model.cards.weather.WeatherCard

import scala.collection.mutable.ListBuffer

/** This class represents the ability of a card that increases the strength of a card
 *  if there is another card with the same name in the board.
 * 
 * The increase is of 100% of the original strength.
 *
 *  @constructor create a new instance of the ability VinculoEstrecho.
 *
 *  @example {{{
 *           val ability = new VinculoEstrecho()
 *           val card = new UnitCard("card", 2, ability)
 *           }}}
 *
 *  @author Joel Riquelme
 *  @since 1.0
 *  @version 1.0
 *
 */
class VinculoEstrecho extends Ability {
  
  /** An auxiliar class */
  class Existe extends Exception
  
  /** This method applies the ability to the cards in the board.
   * 
   * If there is another card with the same name in the board, the strength of the card
   * that has the ability is increased by 100% of its original strength.
   *
   *  @param self the card that has the ability.
   *  @param zone the board where the cards are.
   *  
   *  @example {{{
   *           val ability = new VinculoEstrecho()
   *           val card = new UnitCard("card", 2, ability)
   *           val card2 = new UnitCard("card", 3, ability)
   *           val zone = ListBuffer(card, card2)
   *           ability(card, zone)
   *           assert(card.getstrength() == 4)
   *           }}}
   *           
   *  @author Joel Riquelme
   *  @since 1.0
   *  @version 1.0
   *  
   */
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





