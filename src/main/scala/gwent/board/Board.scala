package cl.uchile.dcc
package gwent.board

import gwent.cards.*

import cl.uchile.dcc.gwent.players.IPlayer

import scala.collection.mutable.ListBuffer

class Board (private val climateZone: ListBuffer[Card])
            (private val meleePlayerZone: ListBuffer[Card])
            (private val rangePlayerZone: ListBuffer[Card])
            (private val siegePlayerZone: ListBuffer[Card])
            (private val meleeCpuZone: ListBuffer[Card])
            (private val rangeCpuZone: ListBuffer[Card])
            (private val siegeCpuZone: ListBuffer[Card]) {
}
