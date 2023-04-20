import cl.uchile.dcc.gwent.cards
import cl.uchile.dcc.gwent.cards.unitCards.UnitCard
import cl.uchile.dcc.gwent.cards.unitCards.subclass.SiegeCard
import munit.FunSuite

class siegeCardTest extends FunSuite {
  val name = "TestCard"
  val name1 = "TestCard1"
  var strength: Int = _
  val ability: String = "Ab"
  var carta1 : SiegeCard = _
  var carta2 : SiegeCard = _



  override def beforeEach(context: BeforeEach): Unit = {
    strength = 5
    carta1 = new SiegeCard(name, strength, ability)
    carta2 = new SiegeCard(name, strength, ability)
  }
  test("A siege card can be created with a name, strength and ability") {
    assertNotEquals(carta1.getname(), "") // name cant be void string
    assertEquals(carta1.getname(), name)
    assertNotEquals(carta1.getstrength(), 0 ) // strength cant be 0
    assert(carta1.getstrength() >= 1) // strength should be greater than or equal to 1
    assertEquals(carta1.getstrength(), strength)
    assertEquals(carta1.getability(), ability)
  }
  test("Testing an equals method for SiegeCard class") {
    assert(carta1.equals(carta2))
    assert(carta2.equals(carta1))
    assert(!carta1.equals("Test"))
    assert(carta1.hashCode == carta2.hashCode)
  }
}
