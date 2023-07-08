package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

import cl.uchile.dcc.gwent.controller.states.*
import cl.uchile.dcc.gwent.controller.states.customException.InvalidActionException
import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.Card
/** Represents a state of the game.
 *
 * @param context the game controller.
 *
 * @constructor creates a new game state with the given game controller.
 *
 * @throws InvalidActionException if the action is not valid in the state.
 *                                
 * @example {{{
 *          val state = new GameState(context)
 *          }}}
 *
 * @see [[cl.uchile.dcc.gwent.controller.GameController]]
 *
 * @author Joel Riquelme
 * @since 1.0
 * @version 1.0
 *
 */
class GameState protected(val context: GameController) {
  context.state = this
  
  /** This method return false for default and the subclasses
   * override them.
   */
  def isCpuLoopState(): Boolean = false
  
  /** This method return false for default and the subclasses
   * override them.
   */
  def isCpuTurnState(): Boolean = false
  
  /** This method return false for default and the subclasses
   * override them.
   */
  def isGameOverState(): Boolean = false
  /** This method return false for default and the subclasses
   * override them.
   */
  def isHumanLoopState(): Boolean = false
  /** This method return false for default and the subclasses
   * override them.
   */
  def isHumanTurnState(): Boolean = false
  /** This method return false for default and the subclasses
   * override them.
   */
  def isNewRoundState(): Boolean = false
  /** This method return false for default and the subclasses
   * override them.
   */
  def isPreGameState(): Boolean = false
  
  /** This method try to start the game, if the state is not
   * PreGameState, it throws an InvalidActionException.
   */
  def startGame(): Unit = actionError("startGame")
  
  /** This method try to play a card, if the state is not
   * HumanTurnState or CpuTurnState, it throws an InvalidActionException.
   */
  def playCard(card: Card, board: Board): Unit = actionError("playCard")
  
  /** This method try to pass the turn, if the state is not
   * HumanTurnState, CpuTurnState, HumanLoopState or CpuLoopState, it throws an InvalidActionException.
   */
  def pass(): Unit = actionError("pass")
  
  /** This method try to step of NewRoundState to HumanTurnState, if the state is not
   * NewRoundState, it throws an InvalidActionException.
   */
  def shuffleAndDraw(): Unit = actionError("shuffleAndDraw")
  
  /** This method try to end the game, if the state is not
   * NewRoundState, it throws an InvalidActionException.
   */
  def endGame(): Unit = actionError("endGame")
  
  /** This method try to reset the game, if the state is not
   * GameOverState, it throws an InvalidActionException.
   */
  def reset(): Unit = actionError("reset")
  
  /** If the action is not valid in the state, this method throws an InvalidActionException.
   */
  private def actionError(action: String): Unit = {
    throw new InvalidActionException(
      s"Cannot perform $action in ${getClass.getSimpleName}"
    )
  }
}
