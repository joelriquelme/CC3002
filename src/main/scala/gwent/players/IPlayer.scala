package cl.uchile.dcc
package gwent.players

trait IPlayer {
  val name : String
  var gems : Int
  val deck : Deck
  val hand : Hand
  def playCard : Unit
  def takeCard : Unit
}
