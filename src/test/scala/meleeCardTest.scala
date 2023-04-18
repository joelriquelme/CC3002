import cl.uchile.dcc.gwent.cards
import cl.uchile.dcc.gwent.cards.unitCards.UnitCard
import munit.FunSuite

class meleeCardTest extends FunSuite {
  val name = "TestCard"
  val name1 = "TestCard1"
  var strength: Int = _
  val ability: String = "Ab"
  var carta1 : MeleeCard = _
  var carta2 : MeleeCard = _



  override def beforeEach(context: BeforeEach): Unit = {
    strength = 5
    carta1 = new MeleeCard(name, strength, ability)
    carta2 = new MeleeCard(name, strength, ability)
  }
  test("A siege card can be created with a name, strength and ability") {
    assertNotEquals(carta1.getname(), "") // name cant be void string
    assertEquals(carta1.getname(), name)
    assertNotEquals(carta1.getstrength(), 0 ) // strength cant be 0
    assert(carta1.getstrength() >= 1) // strength should be greater than or equal to 1
    assertEquals(carta1.getstrength(), strength)
    assertEquals(carta1.getability(), ability)
  }
  test("Testing an equals method for MeleeCard class") {
    assert(carta1.equals(carta2))
    assert(carta2.equals(carta1))
  }
}
