package PlayingCards;

import java.util.Collections;
import java.util.Stack;

public class Deck {

    private Stack Cards = new Stack();

    public Deck(){
         initializeDeck();
    }
    private void initializeDeck() {
        for (CardsColour cardsColour : CardsColour.values()) {
            for (CardsNumber cardsNumber : CardsNumber.values()) {
                Cards.push(cardsNumber + " of " + cardsColour);
            }
        }
    }
    public Object pop(){
        return Cards.pop();
    }
    public void burn(){ Cards.pop(); }
    public void shuffle(){
        Collections.shuffle(Cards);
    }
    public int cardsLeft(){ return Cards.size(); }

}
