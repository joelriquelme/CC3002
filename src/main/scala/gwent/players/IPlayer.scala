package cl.uchile.dcc
package gwent.players

trait IPlayer {
  def playCard() : Unit
  
  def takeCard() : Unit
}