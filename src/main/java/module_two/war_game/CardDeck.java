package module_two.war_game;

import java.util.Random;

public class CardDeck {
    private static int[] cards;
    private int idxTopCard;

    CardDeck() {
        CardDeck.cards = new int[52];
        this.idxTopCard = 51;
        this.fillDeck();
    }

    private void fillDeck() {
        int cardValue = 1;
        for (int i = 0; i < 52; i++) {
            if (i % 4 == 0) {
                cardValue++;
            }
            cards[i] = cardValue;
        }
    }

    private void shuffleDeck() {
        Random r = new Random();
        int bound = 14;
        int idx = 0;
        for (int i = 0; i < 52; i++) {
            int temp = CardDeck.cards[idx];
            int randomIdx = r.nextInt(bound);
            CardDeck.cards[idx] = CardDeck.cards[randomIdx];
            CardDeck.cards[randomIdx] = temp;
            idx++;
        }
    }

    void dealingCards(Player p1, Player p2) {
        this.shuffleDeck();
        for (int i = 0; i < 26; i++) {
            p1.addCard(this.getTopCard());
            p2.addCard(this.getTopCard());
        }
    }

    private int getTopCard() {
        return CardDeck.cards[this.idxTopCard--];
    }

    int[] showDeck() {
        return CardDeck.cards;
    }
}
