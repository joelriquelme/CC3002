package cl.uchile.dcc
package gwent.model.players

import cl.uchile.dcc.gwent.controller.Observer

import scala.collection.mutable.ListBuffer

abstract class AbstractPlayer extends IPlayer {
  protected val observers: ListBuffer[Observer] = ListBuffer()

  def registerObserver(o: Observer): Unit = observers += o
  

  
}
