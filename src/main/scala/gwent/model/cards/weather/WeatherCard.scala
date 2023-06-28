package cl.uchile.dcc
package gwent.model.cards.weather

import cl.uchile.dcc.gwent.*
import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.Card
import cl.uchile.dcc.gwent.model.cards.abilities.{Ability}

import java.util.Objects

/** A class represent a ClimateCard.
 *
 * A ClimateCard is defined by a name and an ability, both non-voids strings.
 *
 * @param name The name of the card.
 * @param ability The ability of the card.
 *                
 * @constructor Creates a new ClimateCard with the specified name and ability.
 * 
 * @example
 * {{{
 * val climateCard = new ClimateCard("Storm","ability of the storm")
 * }}}
 * 
 * @author Joel Riquelme
 * @since 1.0.0
 * @version 1.0.0
 */
class WeatherCard(private val name : String,
                  private val ability : Ability) extends Card, Equals {
  
  /** Play a card (For Humans).
   *
   * Play a card on a board given as parameter. Call the method for play of the board.
   *
   * @param b The board where you go to play
   * @example
   * {{{
   * WeatherCard.playHuman(new Board())
   * }}}
   */
  def playHuman(b: Board): Unit = {
    b.playWeather(this)
  }

  /** Play a card (For Cpu).
   *
   * Play a card on a board given as parameter. Call the method for play of the board.
   *
   * @param b The board where you go to play
   * @example
   * {{{
   * WeatherCard.playCpu(new Board())
   * }}}
   */
  def playCpu(b: Board): Unit = {
    b.playWeather(this)
  }

  /** Getter of the param name. */
  def getname(): String = {
    name
  }

  /** Getter of the param ability. */
  def getability(): Ability = {
    ability
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[WeatherCard]
      (this eq other) ||
        (this.name == other.name && this.ability == other.ability)
    } else {
      false
    }
  }

  override def hashCode: Int = Objects.hash(classOf[WeatherCard], name, ability )


}
