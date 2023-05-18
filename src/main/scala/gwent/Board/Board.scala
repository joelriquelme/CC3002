package cl.uchile.dcc
package gwent.Board

import gwent.cards.*
import scala.collection.mutable.ListBuffer

class Board (private val climateZone: ListBuffer[Card])
            (private val meleeZone1: ListBuffer[Card])
            (private val meleeZone2: ListBuffer[Card])
            (private val rangeZone1: ListBuffer[Card])
            (private val rangeZone2: ListBuffer[Card])
            (private val siegeZone1: ListBuffer[Card])
            (private val siegeZone2: ListBuffer[Card]) {
}
