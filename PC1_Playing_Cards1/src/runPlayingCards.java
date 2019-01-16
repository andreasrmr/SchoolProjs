import PlayingCards.Deck;

public class runPlayingCards {

    public static void main(String[] args){
        Deck deck = new Deck();
        deck.shuffle();

        System.out.println(deck.pop());
        System.out.println(deck.cardsLeft());
        System.out.println(deck.pop());
        System.out.println(deck.cardsLeft());
    }
}
