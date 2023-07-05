package cl.uchile.dcc
package gwent.presetsItems

import gwent.model.cards.Card
import gwent.model.board.Board
import gwent.model.cards.Card
import gwent.model.cards.abilities.{ClimaDespejado, EscarchaMordiente, LluviaTorrencial, NieblaImpenetrable, NullAbility, RefuerzoMoral, VinculoEstrecho}
import gwent.model.cards.unit.IUnitCard
import gwent.model.cards.unit.subclass.{MeleeCard, RangeCard, SiegeCard}
import gwent.model.cards.weather.WeatherCard
import gwent.model.deck.Deck
import gwent.model.hand.Hand
import gwent.model.players.{Cpu, Player}

import scala.collection.mutable.ListBuffer

var Card1 = new MeleeCard("Barbarian",2,new NullAbility())
var Card2 = new MeleeCard("Barbarian",2,new NullAbility())
var Card3 = new MeleeCard("Barbarian",2,new NullAbility())
var Card4 = new MeleeCard("Warrior",3,new NullAbility())
var Card5 = new MeleeCard("Warrior",3,new NullAbility())
var Card6 = new MeleeCard("Ogre",4,new NullAbility())

var Card7 = new RangeCard("Archer",1,new NullAbility())
var Card8 = new RangeCard("Archer",1,new NullAbility())
var Card9 = new RangeCard("Archer",1,new NullAbility())
var Card10 = new RangeCard("Crossbowman",2,new NullAbility())
var Card11 = new RangeCard("Crossbowman",2,new NullAbility())
var Card12 = new RangeCard("Wizard",3,new NullAbility())

var Card13 = new SiegeCard("Catapult",2,new NullAbility())
var Card14 = new SiegeCard("Catapult",2,new NullAbility())
var Card15 = new SiegeCard("Catapult",2,new NullAbility())
var Card16 = new SiegeCard("Ballista",3,new NullAbility())
var Card17 = new SiegeCard("Ballista",3,new NullAbility())
var Card18 = new SiegeCard("Trebuchet",6,new NullAbility())

var Card19 = new MeleeCard("Knight",4,new RefuerzoMoral())
var Card20 = new MeleeCard("Crusader",3,new VinculoEstrecho())
var Card21 = new MeleeCard("Crusader",3,new VinculoEstrecho())

var Card22 = new RangeCard("Ranger",2,new RefuerzoMoral())
var Card23 = new RangeCard("Witch Hunter",3,new VinculoEstrecho())
var Card24 = new RangeCard("Witch Hunter",3,new VinculoEstrecho())

var Card25 = new SiegeCard("Cannon",6,new RefuerzoMoral())
var Card26 = new SiegeCard("Siege Tower",4,new VinculoEstrecho())
var Card27 = new SiegeCard("Siege Tower",4,new VinculoEstrecho())

var Card28 = new WeatherCard("Frost", new EscarchaMordiente())
var Card29 = new WeatherCard("Frost", new EscarchaMordiente())
var Card30 = new WeatherCard("Fog", new NieblaImpenetrable())
var Card31 = new WeatherCard("Fog", new NieblaImpenetrable())
var Card32 = new WeatherCard("Rain", new LluviaTorrencial())
var Card33 = new WeatherCard("Rain", new LluviaTorrencial())
var Card34 = new WeatherCard("Sun", new ClimaDespejado())

var listOfCards = ListBuffer[Card](Card1,Card2,Card3,Card4,Card5,Card6,Card7,Card8,Card9,Card10,Card11,Card12,Card13,Card14,Card15,Card16,Card17,Card18,Card19,Card20,Card21,Card22,Card23,Card24,Card25,Card26,Card27,Card28,Card29,Card30,Card31,Card32,Card33,Card34)

var Deck1 = new Deck(listOfCards)
var Deck2 = new Deck(listOfCards)

var Hand1 = new Hand(ListBuffer[Card]())
var Hand2 = new Hand(ListBuffer[Card]())

var Player = new Player("Player", 2, Deck1, Hand1)
var Cpu = new Cpu("CPU", 2, Deck2, Hand2)






