Tarea 1 de Joel Riquelme 20.499.444-7

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

