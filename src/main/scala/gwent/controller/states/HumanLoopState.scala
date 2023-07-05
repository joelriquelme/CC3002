package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states.*
import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.Card

class HumanLoopState(context: GameController) extends GameState(context){

  override def isHumanLoopState(): Boolean = true

  override def playCard(card: Card, board: Board): Unit = {
    context.playerCharacters.foreach(c => c.playCard(card, board))
    context.state = new HumanLoopState(context)
  }

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
