import cl.uchile.dcc.gwent.cards.unitCards.UnitCard

/**
 * @param name
 * @param strength
 * @param ability
 */
class RangeCard (private val name : String,
                private var strength : Int,
                private val ability : String) extends UnitCard (name, strength, ability) {
  
}
