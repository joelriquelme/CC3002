/* import cl.uchile.dcc.gwent.cards.climateCards.ClimateCard
import cl.uchile.dcc.gwent.cards.unitCards.UnitCard
import munit.FunSuite


class climateCardsTest extends FunSuite {

  val name = "TestCard"
  val tipoC = "Climate"
  val habilidad = "TestHabilidad"
  val habilidadEM = "Escarcha mordiente"
  val habilidadNI = "Niebla impenetrable"
  val habilidadLT = "Lluvia torrencial"
  val habilidadCD = "Clima despejado"


  var cartaC: ClimateCard = _
  var cartaR: UnitCard = _
  var cartaM: UnitCard = _
  var cartaS: UnitCard = _
  var cartaCEM: ClimateCard = _
  var cartaCNI: ClimateCard = _
  var cartaCLT: ClimateCard = _
  var cartaCCD: ClimateCard = _


  val tipoU = "Unit"
  val fuerza = 5
  val subtipo = "TestSubTipo"
  val subtipoM = "melee"
  val subtipoR = "ranger"
  val subtipoS = "siege"

  override def beforeEach(context: BeforeEach): Unit = {
    cartaC = new ClimateCard(name, tipoC, habilidad)
    cartaCEM = new ClimateCard(name, tipoC, habilidadEM)
    cartaCNI = new ClimateCard(name, tipoC, habilidadNI)
    cartaCLT = new ClimateCard(name, tipoC, habilidadLT)
    cartaCCD = new ClimateCard(name, tipoC, habilidadCD)
    cartaR = new UnitCard(name, tipoU, subtipoR, fuerza, habilidad)
    cartaM = new UnitCard(name, tipoU, subtipoM, fuerza, habilidad)
    cartaS = new UnitCard(name, tipoU, subtipoS, fuerza, habilidad)
  }

  test("A climate card can be created with a name, type and ability") {
    assertNotEquals(cartaC.name, "") // name cant be void string
    assertEquals(cartaC.name, name)
    assertEquals(cartaC.cardType, tipoC)
    assertEquals(cartaC.ability, habilidad)
  }
  test("ability Escarcha mordiente works") {
    cartaR.play() // play a card type range
    cartaM.play() // play a card type melee
    cartaS.play() // play a card type siege

    cartaCEM.play() // play a climate card with Escarcha mordiente
    assertEquals(cartaM.strength, 6) // strength of the melee card change
    assertEquals(cartaR.strength, 5) // strength of the range card dont change
    assertEquals(cartaS.strength, 5) // strength of the siege card dont change
  }
  test("ability Niebla impenetrable works"){
    cartaR.play() // play a card type range
    cartaM.play() // play a card type melee
    cartaS.play() // play a card type siege

    cartaCNI.play() // play a climate card with Niebla impenetrable
    assertEquals(cartaR.strength, 6) // strength of the range card change
    assertEquals(cartaM.strength, 5) // strength of the melee card dont change
    assertEquals(cartaS.strength, 5) // strength of the siege card dont change
  }
  test("ability Lluvia torrencial works"){
    cartaR.play() // play a card type range
    cartaM.play() // play a card type melee
    cartaS.play() // play a card type siege

    cartaCLT.play() // play a climate card with Lluvia torrencial
    assertEquals(cartaS.strength, 6) // strength of the siege card change
    assertEquals(cartaR.strength, 5) // strength of the range card dont change
    assertEquals(cartaM.strength, 5) // strength of the melee card dont change
  }
  test("ability Clima despejado works"){
    cartaR.play() // play a card type range
    cartaM.play() // play a card type melee
    cartaS.play() // play a card type siege

    cartaCEM.play() // play a climate card with Escarcha mordiente
    assertEquals(cartaM.strength, 6) // strength of the melee card change
    cartaCCD.play() // play a climate card with Clima despejado
    assertEquals(cartaM.strength, 5) // strength of the melee card change

    cartaCNI.play() // play a climate card with Niebla impenetrable
    assertEquals(cartaR.strength, 6) // strength of the range card change
    cartaCCD.play() // play a climate card with Clima despejado
    assertEquals(cartaR.strength, 5) // strength of the range card change

    cartaCLT.play() // play a climate card with Lluvia torrencial
    assertEquals(cartaS.strength, 6) // strength of the siege card change
    cartaCCD.play() // play a climate card with Clima despejado
    assertEquals(cartaS.strength, 5) // strength of the siege card change
  }
}


 */