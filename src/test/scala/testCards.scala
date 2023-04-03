package cl.uchile.dcc.gwent.cards

import munit.FunSuite

class testCards extends FunSuite {
  val name = "TestCard"
  val tipoU = "Unit"
  val fuerza = 5
  val subtipo = "TestSubTipo"
  val habilidad = "TestHabilidad"
  var cartaU : UnitCard = _


  val tipoC = "Climate"



  var cartaC : ClimateCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    cartaU = new UnitCard(name, tipoU, subtipo, fuerza)
    cartaC = new ClimateCard(name, tipoC)
  }
  test("A unit card can be created with a name, type, sub-type, strength and ability") {
    assertNotEquals(cartU.name, "")
    assertEquals(cartaU.name, name)
    assertEquals(cartaU.cardType, tipoU)
    assertEquals(cartaU.cardSubType, subtipo)
    assertNotEquals(cartaU.strength, 0 )
    assert(cartaU.strength >= 1)
    assertEquals(cartaU.strength, fuerza)
    assertEquals(cartaU.ability, habilidad)
  }
  test("A climate card can be created with a name and type"){
    assertEquals(cartaC.name, name)
    assertEquals(cartaC.cardType, tipoC)
  }



}