package cl.uchile.dcc
package gwent.model.board

import gwent.model.cards.*

import cl.uchile.dcc.gwent.model.cards.unit.subclass.*
import cl.uchile.dcc.gwent.model.cards.Card
import cl.uchile.dcc.gwent.model.cards.abilities.Ability
import cl.uchile.dcc.gwent.model.cards.unit.{AbstractUnitCard, IUnitCard}
import cl.uchile.dcc.gwent.model.cards.unit.subclass.{MeleeCard, RangeCard, SiegeCard}
import cl.uchile.dcc.gwent.model.cards.weather.WeatherCard

import java.util.Objects
import scala.collection.mutable.ListBuffer

/** A class represent a board.
 *
 * A board is defined by a 7 ListBuffer, each represents a section of the board
 * The zone for meele, range, and siege card. These last ones are duplicated,
 * three zones for the cpu and three zones for the human.
 * And the last one zone are shared by Human and Cpu, the zone for the weather cards.
 *
 * @constructor Creates a new board with all empty list.
 * @example
 * board = new Board()
 *
 * @author Joel Riquelme
 * @since 1.0.0
 * @version 1.0.0
 */
class Board extends Equals {
  /** The list of the weather card. */
  private val weatherZone = ListBuffer[Card]()
  /** The list of the melee cards of the human. */
  private val meleePlayerZone = ListBuffer[IUnitCard]()
  /** The list of the range cards of the human. */
  private val rangePlayerZone = ListBuffer[IUnitCard]()
  /** The list of the siege cards of the human. */
  private val siegePlayerZone = ListBuffer[IUnitCard]()
  /** The list of the melee cards of the cpu. */
  private val meleeCpuZone = ListBuffer[IUnitCard]()
  /** The list of the range cards of the cpu. */
  private val rangeCpuZone = ListBuffer[IUnitCard]()
  /** The list of the siege cards of the cpu. */
  private val siegeCpuZone = ListBuffer[IUnitCard]()

  /** Play a melee card in the corresponding zone of the human player's half.
   *
   *  The indicated card is added to the meleePlayerZone list.
   *
   * @param c The card that you gou to play.
   * @example
   * {{{
   * var board = new Board()
   * var card = new MeleeCard("A",1,"Ab")
   * board.playMeleeHuman(card)
   * }}}
   */
  def playMeleeHuman(c: MeleeCard): Unit = {
    meleePlayerZone += c
    c.getability().apply(c,meleePlayerZone)

  }

  /** Play a range card in the corresponding zone of the human player's half.
   *
   * The indicated card is added to the rangePlayerZone list.
   *
   * @param c The card that you gou to play.
   * @example
   * {{{
   * var board = new Board()
   * var card = new RangeCard("A",1,"Ab")
   * board.playRangeHuman(card)
   * }}}
   */
  def playRangeHuman(c: RangeCard): Unit = {
    rangePlayerZone += c
    c.getability().apply(c,rangePlayerZone)
  }

  /** Play a siege card in the corresponding zone of the human player's half.
   *
   * The indicated card is added to the siegePlayerZone list.
   *
   * @param c The card that you gou to play.
   * @example
   * {{{
   * var board = new Board()
   * var card = new SiegeCard("A",1,"Ab")
   * board.playSiegeHuman(card)
   * }}}
   */
  def playSiegeHuman(c: SiegeCard): Unit = {
    siegePlayerZone += c
    c.getability().apply(c,siegePlayerZone)
  }

  /** Play a melee card in the corresponding zone of the cpu player's half.
   *
   * The indicated card is added to the meleeCpuZone list.
   *
   * @param c The card that you gou to play.
   * @example
   * {{{
   * var board = new Board()
   * var card = new MeleeCard("A",1,"Ab")
   * board.playMeleeCpu(card)
   * }}}
   */
  def playMeleeCpu(c: MeleeCard): Unit = {
    meleeCpuZone += c
    c.getability().apply(c,meleeCpuZone)
  }

  /** Play a range card in the corresponding zone of the cpu player's half.
   *
   * The indicated card is added to the rangeCpuZone list.
   *
   * @param c The card that you gou to play.
   * @example
   * {{{
   * var board = new Board()
   * var card = new RangeCard("A",1,"Ab")
   * board.playRangeCpu(card)
   * }}}
   */
  def playRangeCpu(c: RangeCard): Unit = {
    rangeCpuZone += c
    c.getability().apply(c,rangeCpuZone)
  }

  /** Play a siege card in the corresponding zone of the cpu player's half.
   *
   * The indicated card is added to the siegeCpuZone list.
   *
   * @param c The card that you gou to play.
   * @example
   * {{{
   * var board = new Board()
   * var card = new SiegeCard("A",1,"Ab")
   * board.playSiegeCpu(card)
   * }}}
   */
  def playSiegeCpu(c: SiegeCard): Unit = {
    siegeCpuZone += c
    c.getability().apply(c,siegeCpuZone)
  }

  /** Play a weather card in the corresponding zone.
   *
   * The indicated card is added to the weatherZone list.
   *
   * @param c The card that you gou to play.
   * @example
   * {{{
   * var board = new Board()
   * var card = new WeatherCard("A",1,"Ab")
   * board.playWeather(card)
   * }}}
   */
  def playWeather(c: WeatherCard): Unit = {
    weatherZone.clear()
    weatherZone += c
    c.getability().doEffect(c,this)
  }

  /** Apply a weather effect to the melee zone.
   * 
   * This method is used by the weather card to apply its effect to the melee zone.
   * 
   * @param c The card that you gou to play.
   * @param a The ability that you want to apply.
   * 
   * @example {{{
   *          var board = new Board()
   *          var ability = new EscarchaMordiente()
   *          var card = new WeatherCard("A",ability)
   *          board.effectToMelee(card,ability)
   *          }}}
   * 
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   */
  def effectToMelee(c: WeatherCard, a: Ability): Unit = {
    a(c, meleePlayerZone)
    a(c, meleeCpuZone)
  }

  /** Apply a weather effect to the range zone.
   *
   * This method is used by the weather card to apply its effect to the range zone.
   *
   * @param c The card that you gou to play.
   * @param a The ability that you want to apply.
   * @example {{{
   *          var board = new Board()
   *          var ability = new NieblaImpenetrable()
   *          var card = new WeatherCard("A",ability)
   *          board.effectToRange(card,ability)
   *           }}}
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   */
  def effectToRange(c: WeatherCard, a: Ability): Unit = {
    a(c, rangePlayerZone)
    a(c, rangeCpuZone)
  }

  /** Apply a weather effect to the siege zone.
   *
   * This method is used by the weather card to apply its effect to the siege zone.
   *
   * @param c The card that you gou to play.
   * @param a The ability that you want to apply.
   * @example {{{
   *          var board = new Board()
   *          var ability = new LluviaTorrencial()
   *          var card = new WeatherCard("A",ability)
   *          board.effectToSiege(card,ability)
   *            }}}
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   */
  def effectToSiege(c: WeatherCard, a: Ability): Unit = {
    a(c, siegePlayerZone)
    a(c, siegeCpuZone)
  }

  /** Apply a weather effect to all zones.
   *
   * This method is used by the weather card to apply its effect to the all zones.
   *
   * @param c The card that you gou to play.
   * @param a The ability that you want to apply.
   * @example {{{
   *          var board = new Board()
   *          var ability = new ClimaDespejado()
   *          var card = new WeatherCard("A",ability)
   *          board.effectToSiege(card,ability)
   *             }}}
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   */
  def effectToAll(c: WeatherCard, a: Ability): Unit = {
    effectToMelee(c, a)
    effectToRange(c, a)
    effectToSiege(c, a)
  }

  /** Getter of the param weatherZone */
  def getweatherZone(): ListBuffer[Card] = {
    weatherZone.clone()
  }

  /** Getter of the param meleePlayerZone */
  def getmeleePlayerZone(): ListBuffer[IUnitCard] = {
    meleePlayerZone.clone()
  }

  /** Getter of the param rangePlayerZone */
  def getrangePlayerZone(): ListBuffer[IUnitCard] = {
    rangePlayerZone.clone()
  }

  /** Getter of the param siegePlayerZone */
  def getsiegePlayerZone(): ListBuffer[IUnitCard] = {
    siegePlayerZone.clone()
  }

  /** Getter of the param meleeCpuZone */
  def getmeleeCpuZone(): ListBuffer[IUnitCard] = {
    meleeCpuZone.clone()
  }

  /** Getter of the param rangeCpuZone */
  def getrangeCpuZone(): ListBuffer[IUnitCard] = {
    rangeCpuZone.clone()
  }

  /** Getter of the param siegeCpuZone */
  def getsiegeCpuZone(): ListBuffer[IUnitCard] = {
    siegeCpuZone.clone()
  }
  
  /** Reset the board.  
   * 
   * This method is used to reset the board.
   * 
   * @example {{{
   *          var board = new Board()
   *          board.resetBoard()
   *          }}}
   * 
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   *          
   */
  def resetBoard(): Unit = {
    meleePlayerZone.clear()
    rangePlayerZone.clear()
    siegePlayerZone.clear()
    meleeCpuZone.clear()
    rangeCpuZone.clear()
    siegeCpuZone.clear()
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Board]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Board]
      (this eq other) ||
        (this.weatherZone == other.weatherZone &&
          this.meleePlayerZone == other.meleePlayerZone &&
          this.rangePlayerZone == other.rangePlayerZone &&
          this.siegePlayerZone == other.siegePlayerZone &&
          this.meleeCpuZone == other.meleeCpuZone &&
          this.rangeCpuZone == other.rangeCpuZone &&
          this.siegeCpuZone == other.siegeCpuZone)
    } else {
      false
    }
  }

  override def hashCode: Int = Objects.hash(
                                classOf[Board],
                                weatherZone,
                                meleePlayerZone, rangePlayerZone, siegePlayerZone,
                                meleeCpuZone, rangeCpuZone, siegeCpuZone)
}



