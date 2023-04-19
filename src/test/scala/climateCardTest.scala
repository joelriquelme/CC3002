import cl.uchile.dcc.gwent.cards
import cl.uchile.dcc.gwent.cards.climateCards.ClimateCard
import cl.uchile.dcc.gwent.cards.unitCards.UnitCard
import munit.FunSuite

class climateCardTest extends FunSuite {
  val name = "TestCard"
  val name1 = "CardTest"
  val ability: String = "Ab"
  var carta1 : ClimateCard = _
  var carta2 : ClimateCard = _
  var carta3 : ClimateCard = _



  override def beforeEach(context: BeforeEach): Unit = {
    carta1 = new ClimateCard(name, ability)
    carta2 = new ClimateCard(name, ability)
    carta3 = new ClimateCard(name1, ability)
  }
  test("A unit card can be created with a name, strength and ability") {
    assertNotEquals(carta1.getname(), "") // name cant be void string
    assertEquals(carta1.getname(), name)
    assertEquals(carta1.getability(), ability)
  }
  test("Testing an equals method for UnitCard class") {
    assert(carta1.equals(carta2))
    assert(carta2.equals(carta1))
    assert(!carta1.equals(carta3))
  }
}
