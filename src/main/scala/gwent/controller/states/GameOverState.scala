package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states.*

import cl.uchile.dcc.gwent.model.board.Board

/** Represents the state of the game when it is over.
 *
 * @param context the game controller
 *
 * @constructor creates a new game over state with the given game controller
 *
 * @see [[cl.uchile.dcc.gwent.controller.states.GameState]]
 *
 * @throws InvalidActionException if the action is invalid for this state. 
 * 
 * @example {{{
 *          val controller = new GameController()
 *          val gameOverState = new GameOverState(controller)
 *          }}}
 *
 * @note this state is reached when the game is over, and the player has to choose whether to play again or not.
 *
 * @author Joel Riquelme
 * @since 1.0
 * @version 1.0
 *
 */
class GameOverState(context: GameController) extends GameState(context) {

  /** Overrides the method isGameOverState from GameState.
   *
   * This method is used to know if the state is a game over state.
   *
   * @return true because this is a game over state.
   *
   * @see [[cl.uchile.dcc.gwent.controller.states.GameState]]
   *
   * @example {{{
   *          val controller = new GameController()
   *          val gameOverState = new GameOverState(controller)
   *          gameOverState.isGameOverState() // returns true
   *          }}}
   *
   * @author
   * @since 1.0
   * @version 1.0
   *
   */
  override def isGameOverState(): Boolean = true

  /** Overrides the method reset from GameState.
   *
   * This method is used to reset the game. It sets the board to a new board, and the state to a new pre-game state.
   *
   * @see [[cl.uchile.dcc.gwent.controller.states.GameState]]
   *
   * @example {{{
   *          val controller = new GameController()
   *          val gameOverState = new GameOverState(controller)
   *          gameOverState.reset() // resets the game
   *          }}}
   *
   * @note this method is called when the player chooses to play again.
   *
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   */
  override def reset(): Unit = {
    context.board = new Board()
    context.state = new PreGameState(context)
  }
}
