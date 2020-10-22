import java.util.ArrayList;
import java.util.Random;

public class Deck {


private int numberOfCards;
private boolean shuffled;
ArrayList<Card> cards;
ArrayList<Card> discardPile;

public Deck(){
    this.cards = new ArrayList<>();
    this.discardPile = new ArrayList<>();

    this.numberOfCards = 52;
    this.shuffled = false;

    for (int value = 1; value <= 13; value++) {
        for (int suit = 0; suit < 4; suit++) {
            Card card = new Card(Suit.values()[suit], value);
            cards.add(card);
        }
    }
}

public Card dealCard(){
    Card card = cards.get(0);
    cards.remove(0);
    this.numberOfCards--;
    return card;
}

public void shuffleCards(){
    Random num = new Random();

    Card temporaryCard;
    int j;

    for (int i = 0; i < this.numberOfCards; i++) {
        j = num.nextInt(this.numberOfCards);

        temporaryCard = this.cards.get(i);
        this.cards.set(i, this.cards.get(j));
        this.cards.set(j, temporaryCard);
    }
        
    }

public void discardCard(Card card){
    discardPile.add(card);

}

public boolean getShuffled(){
    return this.shuffled;
}
@Override
public String toString(){
    String result = "";
    for (Card card : cards) {
        result += (card + "\n");  
    }
    return result;
}
}
