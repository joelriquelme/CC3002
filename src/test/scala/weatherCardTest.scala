import cl.uchile.dcc.gwent.cards
import cl.uchile.dcc.gwent.cards.weather.WeatherCard
import cl.uchile.dcc.gwent.cards.unit.AbstractUnitCard
import munit.FunSuite

class weatherCardTest extends FunSuite {
  val name = "TestCard"
  val name1 = "CardTest"
  val ability: String = "Ab"
  var carta1 : WeatherCard = _
  var carta2 : WeatherCard = _
  var carta3 : WeatherCard = _



  override def beforeEach(context: BeforeEach): Unit = {
    carta1 = new WeatherCard(name, ability)
    carta2 = new WeatherCard(name, ability)
    carta3 = new WeatherCard(name1, ability)
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
    assert(!carta1.equals("Test"))
    assert(carta1.hashCode == carta2.hashCode)
  }
  test("A method play can be called"){
    carta1.play()
  }
}
