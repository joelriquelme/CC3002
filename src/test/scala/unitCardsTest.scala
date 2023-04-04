package cl.uchile.dcc


import cl.uchile.dcc.gwent.cards.UnitCard

class testCards extends FunSuite {
  val name = "TestCard"
  val tipoU = "Unit"
  val fuerza = 5
  val subtipo = "TestSubTipo"
  val subtipoM = "melee"
  val subtipoR = "ranger"
  val subtipoS = "siege"
  val habilidad = "TestHabilidad"
  val habilidadRM = "Refuezo moral"
  val habilidadVE = "Vinculo estrecho"
  var cartaU : UnitCard = _

  val tipoC = "Climate"
  var cartaC : ClimateCard = _
  val habilidadEM = "Escarcha mordiente"
  val habilidadNI = "Niebla impenetrable"
  val habilidadLT = "Lluvia torrencial"
  val habilidadCD = "Clima despejado"
  override def beforeEach(context: BeforeEach): Unit = {
    cartaU = new UnitCard(name, tipoU, subtipo, fuerza, habilidad)
    cartaC = new ClimateCard(name, tipoC)
    cartaR = new UnitCard(name, tipoU, subtipoR, fuerza, habilidad)
    cartaM = new UnitCard(name, tipoU, subtipoM, fuerza, habilidad)
    cartaS = new UnitCard(name, tipoU, subtipoS, fuerza, habilidad)
  }
  test("A unit card can be created with a name, type, sub-type, strength and ability") {
    assertNotEquals(cartU.name, "") // name cant be void string
    assertEquals(cartaU.name, name)
    assertEquals(cartaU.cardType, tipoU)
    assertEquals(cartaU.cardSubType, subtipo)
    assertNotEquals(cartaU.strength, 0 ) // strength cant be 0
    assert(cartaU.strength >= 1) // strength should be greater than or equal to 1
    assertEquals(cartaU.strength, fuerza)
    assertEquals(cartaU.ability, habilidad)
  }
  test("A climate card can be created with a name, type and ability"){
    assertEquals(cartaC.name, name)
    assertEquals(cartaC.cardType, tipoC)
  }
  test("ability Refuerzo moral works"){
    cartaRM1.play() // play a card type range
    cartaRM3.play() // play a card type melee with Refuerzo moral
    cartaRM2.play() // play a card type range with Refuerzo moral
    assertEquals(cartaRM1.strength, 6) // strength of
    assertEquals(cartaRM2.strength, 5)
    assertEquals(cartaRM3.strength, 5)
  }








}