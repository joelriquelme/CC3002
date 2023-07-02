package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.controller.states._

class NewRoundState(context: GameController) extends GameState(context){

  override def isNewRoundState(): Boolean = true

  override def shuffleAndDraw(): Unit = {
    for (p <- context.playerCharacters) {
      p.getdeck().shuffleDeck()
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
      c.getdeck().shuffleDeck()
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
    context.state = new HumanTurnState(context)
  }

  override def endGame(): Unit = {
    context.state = new GameOverState(context)
    
  }
}
