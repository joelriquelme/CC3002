package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states._

/** State that represents the beginning of a new round.
 *
 *  From this state the game can go to the HumanTurnState or the GameOverState.
 *  To go to the HumanTurnState, the method shuffleAndDraw() is called.
 *  To go to the GameOverState, the method endGame() is called.
 *
 * @param context the controller of the game.
 *                
 * @constructor create a new round state with a context.
 * 
 * @see [[cl.uchile.dcc.gwent.controller.states.GameState]]
 *
 * @throws InvalidActionException if the action is invalid for this state.
 * 
 * @example {{{
 *          val context = new GameController()
 *          val state = new NewRoundState(context)
 *          }}}
 * 
 * @author Joel Riquelme
 * @since 1.0
 * @version 1.0
 *          
 */
class NewRoundState(context: GameController) extends GameState(context){
  
  /** Overrides the method isNewRoundState from GameState.
   *
   *  This method is used to know if the state is a human turn state.
   * 
   *  @return true, because this is a NewRoundState.
   *
   *  @see [[cl.uchile.dcc.gwent.controller.states.GameState]]
   *
   *  @example {{{
   *           val context = new GameController()
   *           val state = new NewRoundState(context)
   *           state.isNewRoundState() // returns true
   *           }}}
   *  
   *  @author Joel Riquelme
   *  @since 1.0
   *  @version 1.0
   */
  override def isNewRoundState(): Boolean = true

  /** Overrides the method shuffleAndDraw from GameState.
   *
   * This method shuffles the decks of the players and the cpu and draws 3 cards for each player.
   * The new state is the HumanTurnState.
   * 
   * @see [[cl.uchile.dcc.gwent.controller.states.HumanTurnState]]
   * 
   * @example {{{
   *          val context = new GameController()
   *          val state = new NewRoundState(context)
   *          state.shuffleAndDraw()
   *          }}}
   * 
   * @author
   * @since 1.0
   * @version 1.0
   * 
   */
  override def shuffleAndDraw(): Unit = {
    for (p <- context.playerCharacters) {
      p.shuffleDeck()
      var i = 0
      while (i < 3) {
        if (p.gethand().getlistOfCards().length == 10){
          i = 3
        }
        else {
          p.takeCard()
          i += 1
        }
      }
    }

    for (c <- context.cpuCharacters) {
      c.shuffleDeck()
      var i = 0
      while (i < 3) {
        if (c.gethand().getlistOfCards().length == 10){
          i = 3
        }
        else {
          c.takeCard()
          i += 1
        }
      }
    }
    context.board.resetBoard()
    context.state = new HumanTurnState(context)
  }

  /** Overrides the method endGame from GameState
   * 
   * This method changes the state to GameOverState.
   * 
   * @see [[cl.uchile.dcc.gwent.controller.states.GameOverState]]
   * 
   * @example {{{
   *          val context = new GameController()
   *          val state = new NewRoundState(context)
   *          state.endGame()
   *          }}}
   * 
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0       
   */
  override def endGame(): Unit = {
    context.state = new GameOverState(context)
    
  }
}
