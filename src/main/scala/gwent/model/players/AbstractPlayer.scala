package cl.uchile.dcc
package gwent.model.players

import cl.uchile.dcc.gwent.controller.Observer
import cl.uchile.dcc.gwent.model.deck.Deck
import cl.uchile.dcc.gwent.model.hand.Hand

import scala.collection.mutable.ListBuffer

/** This abstract class represents a player or cpu in the game.
 * 
 * The player is defined by its name, the number of gems that it has, its deck and its hand.
 * 
 * @param name is the name of the player.
 * @param gems is the number of gems that the player has.
 * @param deck is the deck of the player.
 * @param hand is the hand of the player.
 * 
 * @example A player can be created as follows:
 *          {{{
 *          val player = new Player("player1", 2, deck, hand)
 *          }}}
 * 
 * @note The class is an abstract class, so it can't be instantiated.
 * 
 * @author Joel Riquelme
 * @since 1.0
 * @version 1.0
 */
abstract class AbstractPlayer
(private val name: String,
 private var gems: Int,
 private val deck: Deck,
 private val hand: Hand) extends IPlayer {
  /** list of observers */
  protected val observers: ListBuffer[Observer] = ListBuffer()

  /** Adds an observer to the list of observers */
  def registerObserver(o: Observer): Unit = observers += o

  /** Removes a gem from the player.
   * 
   * This method is only used by the method removeGemsToBoth() in GameController class.
   * 
   * @param i is the number of gems to remove.
   * 
   * @example A player can remove 2 gems as follows:
   *          {{{
   *          player.removeGems(2)
   *          }}}
   * 
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   *          
   */
  def removeGems(i: Int): Unit = {
    gems -= i
  }

  /** Getter of the param name */
  def getname(): String = {
    name
  }

  /** Getter of the param gems */
  def getgems(): Int = {
    gems
  }

  /** Setter of the param gems */
  def setgems(g: Int): Unit = {
    gems = math.max(0, g)
  }

  /** Getter of the param deck */
  def getdeck(): Deck = {
    deck
  }

  /** Getter of the param hand */
  def gethand(): Hand = {
    hand
  }
  /** Shuffles the deck of the player.
   * 
   * This method calls the shuffleDeck method of the deck of the player.
   * 
   * @example A player can shuffle its deck as follows:
   *          {{{
   *          player.shuffleDeck()
   *          }}}
   * 
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   */
  def shuffleDeck(): Unit = {
    deck.shuffleDeck()
  }
  
  /** Removes a gem from the player and notifies the observers.
   * 
   * @see [[cl.uchile.dcc.gwent.controller.Observer]]
   * @see [[cl.uchile.dcc.gwent.controller.GameController]]
   * 
   * @example A player can remove a gem as follows:
   *          {{{
   *          player.removeOneGem()
   *          }}}
   * 
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   *          
   */
  def removeOneGem(): Unit = {
    gems -= 1
    notifyObserver(response = getgems())
  }

  
}
