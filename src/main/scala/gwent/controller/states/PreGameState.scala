package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states.*

import cl.uchile.dcc.gwent.model.board.Board

/** Represents the state of the game before it starts.
 *
 * It is the first state of the game, and it is the state
 * that is active when the game is created.
 * Once the game starts, it changes to HumanTurnState.
 *
 *  @param context the context of the game.
 *
 *  @constructor create a new PreGameState with the given context.
 *
 *  @see [[cl.uchile.dcc.gwent.controller.states.GameState]]
 *
 *  @throws InvalidActionException if the action is invalid for this state.
 *
 *  @example {{{
 *           val context = new GameController()
 *           val state = new PreGameState(context)
 *           }}}
 *
 *  @author Joel Riquelme
 *  @since 1.0
 *  @version 1.0
 */
class PreGameState(context: GameController) extends GameState(context){

  /** Overrides the method isPreGameState from GameState.
   *
   * This method is used to know if the state is a human turn state.
   *
   * @return true.
   *
   * @see [[cl.uchile.dcc.gwent.controller.states.GameState]]
   *
   * @example {{{
   *          val context = new GameController()
   *          val state = new PreGameState(context)
   *          state.isPreGameState() // returns true
   *          }}}
   *
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   *
   */
  override def isPreGameState(): Boolean = true

  /** Overrides the method isHumanTurnState from GameState.
   *
   * This method is used to start the game.
   * It shuffles the decks of the players and cpu characters,
   * and gives them 10 cards each.
   * Then, it changes the state to HumanTurnState.
   *
   * @see [[cl.uchile.dcc.gwent.controller.states.GameState]]
   *
   * @example {{{
   *          val context = new GameController()
   *          val state = new PreGameState(context)
   *          state.startGame()
   *          }}}
   *
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   *
   */
  override def startGame(): Unit = {
    for (p <- context.playerCharacters) {
      p.shuffleDeck()
      var i = 0
      while (i < 10) {
        p.takeCard()
        i += 1
      }
    }
    for (c <- context.cpuCharacters) {
      c.shuffleDeck()
      var i = 0
      while (i < 10) {
        c.takeCard()
        i += 1
      }
    }
    context.state = new HumanTurnState(context)
  }
}
