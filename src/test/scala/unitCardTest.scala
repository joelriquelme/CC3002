import cl.uchile.dcc.gwent.cards
import cl.uchile.dcc.gwent.cards.unitCards.AbstractUnitCard
import cl.uchile.dcc.gwent.cards.unitCards.subclass.MeleeCard
import munit.FunSuite

class unitCardTest extends FunSuite {
  val name = "TestCard"
  val name1 = "TestCard1"
  var strength: Int = _
  val ability: String = "Ab"
  var carta1 : AbstractUnitCard = _
  var carta2 : AbstractUnitCard = _



  override def beforeEach(context: BeforeEach): Unit = {
    strength = 5
    carta1 = new MeleeCard(name, strength, ability)
    carta2 = new MeleeCard(name, strength, ability)
  }
  test("A unit card can be created with a name, strength and ability") {
    assertNotEquals(carta1.getname(), "") // name cant be void string
    assertEquals(carta1.getname(), name)
    assertNotEquals(carta1.getstrength(), 0 ) // strength cant be 0
    assert(carta1.getstrength() >= 1) // strength should be greater than or equal to 1
    assertEquals(carta1.getstrength(), strength)
    assertEquals(carta1.getability(), ability)
  }
  test("Testing an equals method for UnitCard class") {
    assert(carta1.equals(carta2))
    assert(carta2.equals(carta1))
    assert(!carta1.equals("Test"))
    assert(carta1.hashCode == carta2.hashCode)
  }
  test("A method play can be called") {
    carta1.play()
  }
}
