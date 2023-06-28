import cl.uchile.dcc.gwent.model.cards
import cl.uchile.dcc.gwent.model.board.Board
import cl.uchile.dcc.gwent.model.cards.abilities.{Ability, NullAbility}
import cl.uchile.dcc.gwent.model.cards.unit.AbstractUnitCard
import cl.uchile.dcc.gwent.model.cards.weather.WeatherCard
import munit.FunSuite

class weatherCardTest extends FunSuite {
  val name = "TestCard"
  val name1 = "CardTest"
  val ability: Ability = new NullAbility
  var carta1 : WeatherCard = _
  var carta2 : WeatherCard = _
  var carta3 : WeatherCard = _
  var testBoard = new Board()



  override def beforeEach(context: BeforeEach): Unit = {
    carta1 = new WeatherCard(name, ability)
    carta2 = new WeatherCard(name, ability)
    carta3 = new WeatherCard(name1, ability)
    testBoard = new Board()
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
  
  test("A method play can be called") {
    carta1.playHuman(testBoard)
    carta1.playCpu(testBoard)
  }
}
