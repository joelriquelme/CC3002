package cl.uchile.dcc
package gwent.model.players

trait IPlayer {
  def playCard() : Unit
  
  def takeCard() : Unit
}