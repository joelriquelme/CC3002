package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states.*
import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.Card

/** Represents the state of the game when the CPU is playing its cards in loop.
 *
 * @param context the game controller.
 *
 * @constructor creates a cpu loop state with the given game controller.
 *
 * @see [[cl.uchile.dcc.gwent.controller.states.GameState]]
 *
 * @throws InvalidActionException if the action is invalid for this state.
 * 
 * @example {{{
 *            val cpuLoopState = CpuLoopState(gameController)
 *          }}}
 *
 * @author Joel Riquelme
 * @since 1.0
 * @version 1.0
 */
class CpuLoopState(context: GameController) extends GameState(context){
  
  /** Override the method default of GameState.
   * 
   * This method is used to know if the state is a cpu loop state.
   * 
   * @return return true.
   * 
   * @see [[cl.uchile.dcc.gwent.controller.states.GameState]]
   * 
   * @example {{{
   *          val cpuLoopState = CpuLoopState(gameController)
   *          cpuLoopState.isCpuLoopState() // returns true
   *          }}}
   * 
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   *          
   */
  override def isCpuLoopState(): Boolean = true

  /** Override the method playCard of GameState.
   * 
   * This method is used to play a card in the game. It is used when the cpu is playing its cards.
   *
   * @param card the card to be played.
   * @param board the board of the game.
   * 
   * @see [[cl.uchile.dcc.gwent.controller.states.GameState]]
   * 
   * @example {{{
   *          val cpuLoopState = CpuLoopState(gameController)
   *          cpuLoopState.playCard(card, board)
   *          }}}
   * 
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   *          
   */
  override def playCard(card: Card, board: Board): Unit = {
    context.cpuCharacters.foreach(c => c.playCard(card, board))
    context.state = new CpuLoopState(context)
  }
  
  /** Override the method pass of GameState.
   * 
   * This method is used to pass the turn of the game. It is used when the cpu is playing its cards.
   * Counts the points of the player and the cpu and removes gems to the loser.
   * Prints the points of the player and the cpu.
   * 
   * @see [[cl.uchile.dcc.gwent.controller.states.GameState]]
   *      
   * @example {{{
   *          val cpuLoopState = CpuLoopState(gameController)
   *          cpuLoopState.pass()
   *          // prints the points of the player and the cpu
   *          // removes gems to the loser
   *          }}}
   * 
   * @author Joel Riquelme
   * @since 1.0
   * @version 1.0
   *          
   */
  override def pass(): Unit = {
    context.state = new NewRoundState(context)
    var playerPoints: Int = 0
    context.board.getmeleePlayerZone().foreach(c => playerPoints += c.getstrength())
    context.board.getrangePlayerZone().foreach(c => playerPoints += c.getstrength())
    context.board.getsiegePlayerZone().foreach(c => playerPoints += c.getstrength())
    var cpuPoints: Int = 0
    context.board.getmeleeCpuZone().foreach(c => cpuPoints += c.getstrength())
    context.board.getrangeCpuZone().foreach(c => cpuPoints += c.getstrength())
    context.board.getsiegeCpuZone().foreach(c => cpuPoints += c.getstrength())

    println(s"playerPoints: $playerPoints, cpuPoints: $cpuPoints")

    if (playerPoints > cpuPoints) {
      context.cpuCharacters.foreach(c => c.removeOneGem())
    } else if (playerPoints < cpuPoints) {
      context.playerCharacters.foreach(c => c.removeOneGem())
    } else {
      context.removeGemsToBoth()
    }
  }
}
