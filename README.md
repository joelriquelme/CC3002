# Tarea 1 de Joel Riquelme 20.499.444-7

Sobre *Cartas*:

Para este apartado se creó un Trait llamado "Card" donde se especifica el método (aún no implemetado) play().

Se creó este Trait para relacionar las clases UnitCard y ClimateCard. Por lo tanto las clases antes nombradas extienden de Card. 
Para ambas se definieron los getters de todos los parametros con la intención de testear el constructor. A su vez se hizo Override de el método equals y hashCode como fue pedido en el enunciado.

Por parte de UnitCard, existen subclases de esta misma, llamados MeleeCard, RangeCard y SiegeCard; especificando el subtipo correspondiente al tablero de la carta, esto para no ponerlo dentro de un String como parametro. Misma intención con la que separo UnitCard y ClimateCard como clases y no Strings de una única clase Card.

Para estas subclases se heredaron los getters ya que extienden de UnitCard, caso contrario sucede con el método equals. Este fue sobreescrito para adaptarlo a cada clase, detectando el momento en que se comparen subclases de UnitCard diferentes, entregando un false.

Sobre *Jugador*:

Para este apartado se creó un Trait llamado "IPlayer" donde se especifica los métodos playCard(carta: Card) y takeCard() documentados debidamente en la clase Player que logicamente extiende de Iplayer.

La clase Player antes mencionada se crea a partir de un name, gems, hand y deck. Estos dos últimos son de tipo Hand y Deck correspondientemente.

Clase Hand: esta clase representa la mano del jugador. La idea de crear una clase para la mano viene dado por la necesidad de quitarle responsabilidad a Player sobre la lista de cartas que posee, por lo tanto al hacer player.playCard() simplemente se llama a un método de hand.

Clase Deck: el proposito de esta clase es básicamente la misma que Hand pero orientada al mazo del jugador. Por ejemplo al momento de hacer player.takeCard() se llama a un método de hand que a su vez llama a un método de deck. Delegando así lo más posible la responsabilidad de clases.

# Tarea 2 de Joel Riquelme 20.499.444-7

->Actualización de Clases:

Sobre *Player*: 

Se actualizó el método playCard(). Ahora llama a hand.playHuman() de hand, esto para hacer la distición entre la jugada de un humano y cpu.

Sobre *Hand*:

Se actualizo el metodo play(), dividiendolo en dos, playHuman() y playCpu() para diferenciar el llamado desde un humano o una cpu. Uno llama a c.playHuman() y el otro a c.playCpu() ambos metodos de la clase carta.

Sobre *Cartas*:

Al igual que para las clases anteriores se dividio el play() en dos, playHuman() y playCpu()

->Creación de Clases:

*Cpu*: Clase que de momento es una copia casi exacta de la clase player, su creacion unicamente se realizó pensando en implementaciones futuras.

*Tablero*: Se creo la clase tablero que se basa en 7 listas para cada sección del tablero, la sección de cartas para melee, rango y asedio, duplicadas para cada jugador y la sección compartida de las cartas de clima.

Los metodos de esta clase se explicarán en la siguiente seccion.

**¿¿COMO SE JUEGAN LAS CARTAS??**:

Para jugar una carta, tanto el humano como la cpu lo hacen de la misma forma de momento por lo que se explicará solo el caso de que un humano juegue una carta, para la cpu es lo mismo pero cambiando el nombre de los metodos.

1- El player llama al metodo playCard(c: Card, b: Board): 
    Este metodo lo que hace es llamar a hand.playHuman(c, b)

2- Se hace el llamado de playHuman(c: Card, b: Board) (metodo de Hand):
    Aquí nuevamente se hace otro llamado a otro metodo, esta vez uno de la misma carta.
    Primero se llama a c.playHuman(b) y luego se quita esa carta de la mano.

3- Se hace el llamado de playHuman(b: Board) (metodo de Card):
    Aquí depende mucho del tipo de la carta, se llama al metodo b.play<tipo-de-la-carta><Human-o-Cpu>(this)
    Por ejemplo se puede hacer el llamado a b.playMeleeHuman(this).
    En el caso de que fuera una carta de clima será unicamente b.playWeather(this), ya que no hay comportamiento diferente entre que un humano o una cpu juegue una carta de clima.

4- Se hace el llamado de b.play<tipo-de-la-carta><Human-o-Cpu>(this):
    Aquí existen 7 metodos distintos de play en la clase tablero, uno para cada caso, dependiendo de la combinación de tipo de carta y si lo juega un humano o una cpu.
    Cada uno de estos situa a la carta en su sección del tablero correspondiente.

Aplicando así el patrón de diseño doubleispach.


# Tarea 3 de Joel Riquelme 20.499.444-7

## Entrega Parcial 4 (States y Controller)

### Diagrama de Estados

![Diagrama de Estados](../gwen-t-joelriquelme/Diagrama%20de%20Estados.png)

En primer lugar se creó una Class grande llamada GameState de la cual todos los demas States heredan. Esta clase contiene todos los metodos para cambiar de estados de manera que todos lanzan una Exception Custom por defecto, además tiene los metodos que preguntan que estado es el actual, tambien por defecto todos entregan un False.

Cada subclase de GameState corresponde a un State concreto del juego, en cada una se hace override de los metodos que corresponden a cada estado, por ejemplo en el estado Pre-Game se sobre escribio el metodo StartGame() para revolver los mazos y robar 10 cartas para cada jugador y el metodo isPreGameState() para entregar True.

## Entrega Parcial 5 (Abilities)

### Habilidades:

Se ultilizo el patron de diseño composite para las habilidades. En primer lugar se creo una interfaz llamada Ability que contiene el metodo apply() que recibe la carta(self) y la zona donde se aplica el efecto, dicho metodo es el que se encarga de aplicar la habilidad.

### Habilidades de Cartas de Unidad:

Se crearon 3 habilidades para las cartas de unidad, "RefuerzoMoral", "VinculoEstrecho" y "NullAbility" este ultimo correspondiente al metodo de diseño de NullObject, que como dice su nombre fue creada como representativa de las cartas sin habilidades, ya que todas las cartas tienen habilidades pero pueden tener efecto o no.
Las primeras 2 habilidades mencionadas anteriormente se crearon como clases que implementan la interfaz Ability, en ellas se sobreescribe el metodo apply() para que realice la accion correspondiente a cada habilidad. 

### Habilidades de Cartas de Clima:

Estas habilidades tambien implementan la interfaz Ability, pero esta vez fueron creadas 4 habilidades:
"ClimaDespejado","EscarchaMordiente","LluviaTorrencial" y "TormentaImpenetrable", cada una con su metodo apply() correspondiente.

Para aplicar estos efectos se tuvo que implementar otra vez doubleDispatch, esta vez para saber de que tipo es la habilidad que se juega.
En primera instancia se sabe que se juega una carta de tipo clima, pero se necesita saber de que tipo es la habilidad, para aquello dentro del metodo playWeather de Board, se llama a ability.doEffect(card,this). Dentro de este ultimo metodo se hace el llamado a board.affectTo<Melee-Range-Siege-All>(card, this) dependiendo de que tipo de habilidad es. Luego una vez teniendo la informacion de que tipo de habilidad es y donde se tiene que aplicar dicho efecto, se llama al metodo apply del efecto entregando la zona donde se tiene que aplicar.

Cabe destacar que el metodo doEffect de la clase Ability solo deberia ser llamado por habilidades de cartas de clima, por lo tanto si es llamado por una abillidad de cartas de unidad, se lanza el error "InvalidAbilityMethodException" que es una Exception Custom para este caso.
## Entrega Parcial 6 (Observer)

Para implementar el descuento de gemas y ver quien gana el juego se utilizo el patron de diseño Observer.
Con este objetivo se creo la interfaz Observer de la cual GameController hereda. GameController implementa los updaters tanto de Cpu como de Player así como el updater de ambos a la vez.

Con esta logica, el Observer corresponde al controlador. Por otro lado los observables son los jugadores, ya que son ellos los que tienen que avisarle al controlador cuando se les descuenta una gema o cuando se les acaban las gemas.
Para esto Player y Cpu contienen los metodos registerObserver y notifyObservers, que son los que se encargan de registrar al controlador como observador y avisarle cuando se les descuenta una gema o cuando se les acaban las gemas.
Este ultimo metodo se llama desde el metodo removeOneGem o desde el metodo removeGemsToBoth segun corresponda.

Los metodos de Update son los responsbles de mostrar en pantalla si se le descuenta una gema a un jugador o si se le acaban las gemas a un jugador, tambien se encargan de mostrar en pantalla quien gana el juego o si hay empate.









