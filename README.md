**Tarea 1 de Joel Riquelme 20.499.444-7**

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

**Tarea 2 de Joel Riquelme 20.499.444-7**

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

Aplicando así el patrón de diseño dobledispach.







