package cl.uchile.dcc
package gwent.controller

import gwent.controller.states.*

import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.Card
import cl.uchile.dcc.gwent.model.players.{Cpu, IPlayer, Player}

import scala.collection.mutable.ListBuffer

class GameController extends Observer {
  var playerCharacters = ListBuffer.empty[Player]
  var cpuCharacters = ListBuffer.empty[Cpu]
  var state: GameState = new PreGameState(this)
  var board: Board = new Board()

  def updatePlayer(o: IPlayer, arg: Any): Unit = {
    if (arg.asInstanceOf[Int] <= 0) {
      println(s"Player has $arg gems remaining. The enemy has won.")
    }
    else {
      println(s"Player has $arg gems remaining.")
    }
  }

  def updateCpu(o: IPlayer, arg: Any): Unit = {
    if (arg.asInstanceOf[Int] <= 0) {
      println(s"Enemy has $arg gems remaining. The player has won.")
    }
    else {
      println(s"Enemy has $arg gems remaining.")
    }
  }

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

  def removeGemsToBoth(): Unit = {
    var a = 0
    var b = 0
    cpuCharacters.foreach(c => {c.removeGems(1); a = c.getgems()})
    playerCharacters.foreach(p => {p.removeGems(1); b = p.getgems()})
    this.updateCpuAndPlayer(List[Int](a, b))
  }

  def createGame(player: Player, cpu: Cpu): Unit = {
    player.registerObserver(this)
    cpu.registerObserver(this)
    playerCharacters += player
    cpuCharacters += cpu
    board = new Board()
    state = new PreGameState(this)
  }
  def startGame(): Unit = {
    state.startGame()
  }

  def playCard(card: Card, board: Board): Unit = {
    state.playCard(card, board)
  }

  def pass(): Unit = {
    state.pass()
  }

  def shuffleAndDraw(): Unit = {
    state.shuffleAndDraw()
  }

  def endGame(): Unit = {
    state.endGame()
  }

  def reset(): Unit = {
    state.reset()
  }

  def isCpuLoopState(): Boolean = state.isCpuLoopState()
  def isCpuTurnState(): Boolean = state.isCpuTurnState()
  def isGameOverState(): Boolean = state.isGameOverState()
  def isHumanLoopState(): Boolean = state.isHumanLoopState()
  def isHumanTurnState(): Boolean = state.isHumanTurnState()
  def isNewRoundState(): Boolean = state.isNewRoundState()
  def isPreGameState(): Boolean = state.isPreGameState()
}
