package cl.uchile.dcc
package gwent.players

import gwent.cards.Cards

class Player (private val name : String,
              private var gems : Int,
              private val deck : Deck,
              private val hand : Hand){
  
  def playCard(carta: Cards): Unit = {
    carta.play()
  }
  def takeCard() : Unit = {
    
  }

}
