package cl.uchile.dcc
package gwent.jugador

trait IPlayer {
  private val name : String
  private var gems : Int
  private val deck : Deck
  private val hand : Hand
  def playCard(Card) : Unit
  def takeCard(Deck) : Unit
}
