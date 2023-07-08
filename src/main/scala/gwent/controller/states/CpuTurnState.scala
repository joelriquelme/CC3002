package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states.*
import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.Card

/**
 * Represents the state of the game when the CPU is playing a card.
 *
 * @param context the game controller.
 *
 * @constructor creates a new CPU turn state with the given game controller.
 *
 * @see [[cl.uchile.dcc.gwent.controller.states.GameState]]
 *
 * @throws InvalidActionException if the action is invalid for this state. 
 * 
 * @example {{{
 *          val state = new CpuTurnState(context)
 *          }}}
 *
 * @author Joel Riquelme
 * @since 1.0
 * @version 1.0
 *
 */
class CpuTurnState(context: GameController) extends GameState(context){

  /** Overrides the isCpuTurnState method from GameState.
   *
   * This method is used to know if the state is a cpu turn state.
   *
   * @return true.
   *
   * @see [[cl.uchile.dcc.gwent.controller.states.GameState.isCpuTurnState]]
   * 
   * @example {{{
   *          val state = new CpuTurnState(context)
   *          state.isCpuTurnState() // returns true
   *          }}}
   *
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   * 
   */
  override def isCpuTurnState(): Boolean = true
  
  /** Overrides the playCard method from GameState.
   * 
   * This method is used to play a card in the game. It plays the card in the cpu's hand and then changes the state to
   * a human turn state.
   * 
   * @param card the card to be played.
   * @param board the board where the card will be played.
   * 
   * @see [[cl.uchile.dcc.gwent.controller.states.GameState.playCard]]
   *      
   * @example {{{
   *          val state = new CpuTurnState(context)
   *          state.playCard(card, board) // plays the card in the cpu's hand and changes the state to a human turn state.
   *          }}}
   * 
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   *          
   */
  override def playCard(card: Card, board: Board): Unit = {
    context.cpuCharacters.foreach(c => c.playCard(card, board))
    context.state = new HumanTurnState(context)
  }
  
  /** Overrides the pass method from GameState.
   * 
   * This method is used to pass the turn. It changes the state to a human loop state.
   * 
   * @see [[cl.uchile.dcc.gwent.controller.states.GameState]]
   * 
   * @example {{{
   *          val state = new CpuTurnState(context)
   *          state.pass() // changes the state to a human loop state.
   *          }}}
   * 
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   */
  override def pass(): Unit = {
    context.state = new HumanLoopState(context)
  }

}
