package cl.uchile.dcc
package gwent.controller

import gwent.controller.states._

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.Card

class GameController {
  var state: GameState = new PreGameState(this)

  def NewGame(): Unit = {
    state = new PreGameState(this)
  }

  def StartGame(): Unit = {
    state.toHumanTurnState()
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
}
