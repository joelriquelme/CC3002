package cl.uchile.dcc
package gwent.controller.states.customException

/** Exception thrown when the user tries to perform an invalid action in the state. */
class InvalidActionException(message: String) 
  extends Exception(message)

