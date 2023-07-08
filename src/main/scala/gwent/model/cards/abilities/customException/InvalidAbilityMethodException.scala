package cl.uchile.dcc
package gwent.model.cards.abilities.customException

/** Exception thrown when a method is called that is not valid for the ability or card. */
class InvalidAbilityMethodException(message: String) 
  extends Exception(message)
