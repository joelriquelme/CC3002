package cl.uchile.dcc
package gwent.controller

import gwent.model.players.IPlayer

trait Observer {
  def updatePlayer(o: IPlayer, arg: Any) : Unit
  def updateCpu(o: IPlayer, arg: Any) : Unit
}
