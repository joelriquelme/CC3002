package cl.uchile.dcc
package gwent.model.cards.unit.subclass

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.unit.AbstractUnitCard

import java.util.Objects

/** A class represent a RangeCard.
 *
 * A RangeCard is a subclass of UnitCard and is defined by a name, strength
 * and an ability, all greater than zero or non-void string according to the case.
 *
 * @param name The name of the card.
 * @param strength The strength of the card.
 * @param ability The ability of the card.
 *
 * @constructor Creates a new RangeCard with the specified name, strength and ability.
 *
 * @example
 * {{{
 * val RangeCard = new ClimateCard("Archer","Power of the wind")
 * }}}
 *
 * @author Joel Riquelme
 * @since 1.0.0
 * @version 1.0.0
 */
class RangeCard(private val name : String,
                private var strength : Int,
                private val ability : String) extends AbstractUnitCard (name, strength, ability), Equals {
  
  /** Play a card (For Humans).
   *
   * Play a card on a board given as parameter. Call the method for play of the board.
   *
   * @param b The board where you go to play
   * @example
   * {{{
   * RangeCard.playHuman(new Board())
   * }}}
   */
  def playHuman(b: Board): Unit = {
    b.playRangeHuman(this)
  }

  /** Play a card (For Cpu).
   *
   * Play a card on a board given as parameter. Call the method for play of the board.
   *
   * @param b The board where you go to play
   * @example
   * {{{
   * RangeCard.playCpu(new Board())
   * }}}
   */
  def playCpu(b: Board): Unit = {
    b.playRangeCpu(this)
  }
  
  override def canEqual(that: Any): Boolean = that.isInstanceOf[RangeCard]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[RangeCard]
      (this eq other) ||
        (this.name == other.name && this.strength == other.strength && this.ability == other.ability)
    } else {
      false
    }
  }

  override def hashCode: Int = Objects.hash(classOf[RangeCard], name, strength, ability)  
}
