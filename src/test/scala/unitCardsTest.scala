package cl.uchile.dcc


import cl.uchile.dcc.gwent.cards

class unitCardsTest extends FunSuite {
  val name = "TestCard"
  val name1 = "TestCard1"
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
  var cartaR : UnitCard = _
  var cartaM : UnitCard = _
  var cartaS : UnitCard = _
  var cartaR1 : UnitCard = _
  var cartaM1 : UnitCard = _
  var cartaS1 : UnitCard = _
  var cartaRRM : UnitCard = _
  var cartaMRM : UnitCard = _
  var cartaSRM : UnitCard = _
  var cartaRVE : UnitCard = _
  var cartaMVE : UnitCard = _
  var cartaSVE : UnitCard = _


  override def beforeEach(context: BeforeEach): Unit = {
    cartaU = new UnitCard(name, tipoU, subtipo, fuerza, habilidad)
    cartaR = new UnitCard(name, tipoU, subtipoR, fuerza, habilidad)
    cartaM = new UnitCard(name, tipoU, subtipoM, fuerza, habilidad)
    cartaS = new UnitCard(name, tipoU, subtipoS, fuerza, habilidad)
    cartaR1 = new UnitCard(name1, tipoU, subtipoR, fuerza, habilidad)
    cartaM1 = new UnitCard(name1, tipoU, subtipoM, fuerza, habilidad)
    cartaS1 = new UnitCard(name1, tipoU, subtipoS, fuerza, habilidad)
    cartaRRM = new UnitCard(name, tipoU, subtipoR, fuerza, habilidadRM)
    cartaMRM = new UnitCard(name, tipoU, subtipoM, fuerza, habilidadRM)
    cartaSRM = new UnitCard(name, tipoU, subtipoS, fuerza, habilidadRM)
    cartaRVE = new UnitCard(name1, tipoU, subtipoR, fuerza, habilidadVE)
    cartaMVE = new UnitCard(name1, tipoU, subtipoM, fuerza, habilidadVE)
    cartaSVE = new UnitCard(name1, tipoU, subtipoS, fuerza, habilidadVE)

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
  test("ability Refuerzo moral works"){
    cartaR.play() // play a card type range
    cartaM.play() // play a card type melee
    cartaS.play() // play a card type siege

    cartaRRM.play() // play a card type range with Refuerzo moral
    assertEquals(cartaRRM.strength, 5) // strength of the lasted played card dont change
    assertEquals(cartaR.strength, 6) // strength of the range card change
    assertEquals(cartaM.strength, 5) // strength of the melee card dont change
    assertEquals(cartaS.strength, 5) // strength of the siege card dont change

    cartaMRM.play() // play a card type melee with Refuerzo moral
    assertEquals(cartaMRM.strength, 5) // strength of the lasted played card dont change
    assertEquals(cartaM.strength, 6) // strength of the melee card change
    assertEquals(cartaR.strength, 6) // strength of the range card dont change
    assertEquals(cartaS.strength, 5) // strength of the siege card dont change

    cartaSRM.play() // play a card type siege with Refuerzo moral
    assertEquals(cartaSRM.strength, 5) // strength of the lasted played card dont change
    assertEquals(cartaS.strength, 6) // strength of the siege card change
    assertEquals(cartaR.strength, 6) // strength of the range card dont change
    assertEquals(cartaM.strength, 6) // strength of the melee card dont change
  }
  test("ability Vinculo Estrecho works"){
    cartaR.play() // play a card type range with name "TestCard"
    cartaM.play() // play a card type melee with name "TestCard"
    cartaS.play() // play a card type siege with name "TestCard"
    cartaR1.play() // play a card type range with name "TestCard1"
    cartaM1.play() // play a card type melee with name "TestCard1"
    cartaS1.play() // play a card type siege with name "TestCard1"

    cartaRVE.play() // play a cart type range with name "TestCard1"
    assertEquals(cartaRVE.strength, 10) // strength of the lasted played card change
    assertEquals(cartaR1.strength, 10) // strength of the range card "TestCard1" change
    assertEquals(cartaM1.strength, 5) // strength of the range card "TestCard1" dont change
    assertEquals(cartaS1.strength, 5) // strength of the range card "TestCard1" dont change
    assertEquals(cartaR.strength, 5) // strength of the range card "TestCard" dont change
    assertEquals(cartaM.strength, 5) // strength of the melee card "TestCard" dont change
    assertEquals(cartaS.strength, 5) // strength of the siege card "TestCard" dont change

    cartaMVE.play() // play a cart type melee with name "TestCard1"
    assertEquals(cartaMVE.strength, 10) // strength of the lasted played card change
    assertEquals(cartaM1.strength, 10) // strength of the melee card "TestCard1" change
    assertEquals(cartaR1.strength, 10) // strength of the range card "TestCard1" dont change
    assertEquals(cartaS1.strength, 5) // strength of the range card "TestCard1" dont change
    assertEquals(cartaR.strength, 5) // strength of the range card "TestCard" dont change
    assertEquals(cartaM.strength, 5) // strength of the melee card "TestCard" dont change
    assertEquals(cartaS.strength, 5) // strength of the siege card "TestCard" dont change

    cartaSVE.play() // play a cart type melee with name "TestCard1"
    assertEquals(cartaSVE.strength, 10) // strength of the lasted played card change
    assertEquals(cartaS1.strength, 10) // strength of the siege card "TestCard1" change
    assertEquals(cartaR1.strength, 10) // strength of the range card "TestCard1" dont change
    assertEquals(cartaM1.strength, 10) // strength of the melee card "TestCard1" dont change
    assertEquals(cartaR.strength, 5) // strength of the range card "TestCard" dont change
    assertEquals(cartaM.strength, 5) // strength of the melee card "TestCard" dont change
    assertEquals(cartaS.strength, 5) // strength of the siege card "TestCard" dont change
  }
}