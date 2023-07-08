package cl.uchile.dcc
package gwent.controller

import gwent.controller.states.*

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.Card
import cl.uchile.dcc.gwent.model.players.{Cpu, IPlayer, Player}

import scala.collection.mutable.ListBuffer

/** This class is the controller of the game. It is in charge of creating the game, and
 * changing the state of the game. It also has a list of the players, the board and the
 * state of the game.
 *
 * @constructor creates a new game controller without players and cpu. The state of the
 *              game is PreGameState. The board is empty.
 *
 * @example {{{
 *          val gameController = new GameController()
 *          }}}
 *
 *
 * @author Joel Riquelme
 * @since 1.0
 * @version 1.0
 */
class GameController extends Observer {
  /** The list of players in the game. */
  var playerCharacters = ListBuffer.empty[Player]
  /** The list of cpu in the game */
  var cpuCharacters = ListBuffer.empty[Cpu]
  /** The state of the game. */
  var state: GameState = new PreGameState(this)
  /** The board of the game. */
  var board: Board = new Board()

  /** getter of the val getplayerCharacters */
  def getplayerCharacters(): ListBuffer[Player] = playerCharacters.clone()

  /** getter of the val getcpuCharacters */
  def getcpuCharacters(): ListBuffer[Cpu] = cpuCharacters.clone()

  /** Update method for a player.
   *
   * This update method is called when a is was removed a gem from the player.
   * If the player has 0 gems, the enemy has won. Otherwise, it prints the number
   * of gems that the player has.
   *
   * @param o the player that was updated.
   * @param arg the number of gems that the player has.
   *
   * @example {{{
   *          updatePlayer(player, 0)
   *          //prints "Player has 0 gems remaining. The enemy has won."
   *          updatePlayer(player, 1)
   *          //prints "Player has 1 gems remaining."
   *          }}}
   *
   * @see [[cl.uchile.dcc.gwent.controller.Observer]]
   *
   * @author Joel Riquelme
   * @version 1.0
   * @since 1.0
   *
   */
  def updatePlayer(o: IPlayer, arg: Any): Unit = {
    if (arg.asInstanceOf[Int] <= 0) {
      println(s"Player has $arg gems remaining. The enemy has won.")
    }
    else {
      println(s"Player has $arg gems remaining.")
    }
  }

  /** Update method for a cpu.
   *
   * This update method is called when a is was removed a gem from the cpu.
   * If the cpu has 0 gems, the player has won. Otherwise, it prints the number
   * of gems that the cpu has.
   *
   * @param o the cpu that was updated.
   * @param arg the number of gems that the cpu has.
   *
   * @example {{{
   *          updateCpu(cpu, 0)
   *          //prints "Enemy has 0 gems remaining. The player has won."
   *          updateCpu(cpu, 1)
   *          //prints "Enemy has 1 gems remaining."
   *          }}}
   *
   * @see [[cl.uchile.dcc.gwent.controller.Observer]]
   *
   * @author Joel Riquelme
   * @version 1.0
   * @since 1.0
   *
   */
  def updateCpu(o: IPlayer, arg: Any): Unit = {
    if (arg.asInstanceOf[Int] <= 0) {
      println(s"Enemy has $arg gems remaining. The player has won.")
    }
    else {
      println(s"Enemy has $arg gems remaining.")
    }
  }

  /** Update method for both players.
   *
   * This update method is called when a is was removed a gem from both players.
   * If both players have 0 gems, it's a draw. Otherwise, it calls the updateCpu
   * or updatePlayer method depending on which player has 0 gems.
   *
   * @param arg a list of the number of gems that both players have. The first element
   *            is the number of gems of the cpu, and the second element is the number
   *            of gems of the player.
   *
   * @example {{{
   *          updateCpuAndPlayer(List[Int](0, 0))
   *          //prints "Both players have 0 gems remaining. It's a draw."
   *          updateCpuAndPlayer(List[Int](0, 1))
   *          //call updateCpu(player, 0)
   *          updateCpuAndPlayer(List[Int](1, 0))
   *          //call updatePlayer(cpu, 0)
   *          }}}
   *
   * @see [[cl.uchile.dcc.gwent.controller.Observer]]
   *
   * @author Joel Riquelme
   * @version 1.0
   * @since 1.0
   *
   */
  def updateCpuAndPlayer(arg: List[Int]): Unit = {
    arg match {
      case List(0, 0) =>
        println("Both players have 0 gems remaining. It's a draw.")
      case List(0, _) =>
        updateCpu(cpuCharacters.head, 0)
      case List(_, 0) =>
        updatePlayer(playerCharacters.head, 0)
    }
  }

  /** Remove a gem to both players.
   *
   * This method removes a gem to both players. It calls the removeGems method of
   * both players, and then calls the updateCpuAndPlayer method.
   *
   * @example {{{
   *          removeGemsToBoth()
   *          //call updateCpuAndPlayer(List[Int](a, b))
   *          //where a is the number of gems of the cpu, and b is the number of gems
   *          }}}
   *
   * @see [[cl.uchile.dcc.gwent.controller.Observer]]
   *
   * @author Joel Riquelme
   * @version 1.0
   * @since 1.0
   *
   */
  def removeGemsToBoth(): Unit = {
    var a = 0
    var b = 0
    cpuCharacters.foreach(c => {c.removeGems(1); a = c.getgems()})
    playerCharacters.foreach(p => {p.removeGems(1); b = p.getgems()})
    this.updateCpuAndPlayer(List[Int](a, b))
  }

  /** Create a new game.
   *
   * This method creates a new game. It creates a new board, and sets the state
   * to a new PreGameState. It also adds the player and the cpu to the list of
   * characters. It also registers the observer to both players.
   *
   * @param player the player of the game.
   * @param cpu the cpu of the game.
   *
   * @example {{{
   *          createGame(player, cpu)
   *          //creates a new game with the player and the cpu
   *          }}}
   *
   * @see [[cl.uchile.dcc.gwent.controller.Observer]]
   *
   * @author Joel Riquelme
   * @version 1.0
   * @since 1.0
   *
   */
  def createGame(player: Player, cpu: Cpu): Unit = {
    player.registerObserver(this)
    cpu.registerObserver(this)
    playerCharacters += player
    cpuCharacters += cpu
    board = new Board()
    state = new PreGameState(this)
  }

  /** Start the game.
   *
   * This method starts the game. It calls the startGame method of the state.
   */
  def startGame(): Unit = {
    state.startGame()
  }

  /** Play a card.
   *
   * This method plays a card. It calls the playCard method of the state.
   *
   * @param card the card to be played.
   * @param board the board of the game.
   */
  def playCard(card: Card, board: Board): Unit = {
    state.playCard(card, board)
  }

  /** Pass the turn.
   *
   * This method passes the turn. It calls the pass method of the state.
   */
  def pass(): Unit = {
    state.pass()
  }

  /** Shuffle And Draw to go a new round.
   *
   * This method Suffle and Draw. It calls the shuffleAndDraw method of the state.
   */
  def shuffleAndDraw(): Unit = {
    state.shuffleAndDraw()
  }

  /** End the game.
   *
   * This method ends the game. It calls the endGame method of the state.
   */
  def endGame(): Unit = {
    state.endGame()
  }

  /** Reset the game.
   *
   * This method resets the game. It calls the reset method of the state.
   */
  def reset(): Unit = {
    state.reset()
  }

  /** This method asks for the type of the State calling to the isCpuLoopState method of the state. */
  def isCpuLoopState(): Boolean = state.isCpuLoopState()
  /** This method asks for the type of the State calling to the isCpuTurnState method of the state. */
  def isCpuTurnState(): Boolean = state.isCpuTurnState()
  /** This method asks for the type of the State calling to the isGameOverState method of the state. */
  def isGameOverState(): Boolean = state.isGameOverState()
  /** This method asks for the type of the State calling to the isHumanLoopState method of the state. */
  def isHumanLoopState(): Boolean = state.isHumanLoopState()
  /** This method asks for the type of the State calling to the isHumanTurnState method of the state. */
  def isHumanTurnState(): Boolean = state.isHumanTurnState()
  /** This method asks for the type of the State calling to the isNewRoundState method of the state. */
  def isNewRoundState(): Boolean = state.isNewRoundState()
  /** This method asks for the type of the State calling to the isPreGameState method of the state. */
  def isPreGameState(): Boolean = state.isPreGameState()
}
