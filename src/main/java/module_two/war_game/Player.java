package module_two.war_game;

public class Player {
    private String name;
    private int[] initCards;
    private int[] wonCards;
    private int initCardIdx;
    private int wonCardIdx;
    private boolean hasCardsInDeck;

    Player(String name) {
        this.setName(name);
        this.initCards = new int[26];
        this.initCardIdx = 0;
        this.wonCards = new int[52];
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    //test
//    public void setInitCards(int[] initCards) {
//        this.initCards = initCards;
//    }

    void addCard(int card) {
        this.initCards[initCardIdx++] = card;
        this.hasCardsInDeck = true;
    }

    void addWonCard(int wonCard) {
        if (this.wonCardIdx < 52) {
            this.wonCards[wonCardIdx++] = wonCard;
        }
    }

    int getTopCard() {
        if (initCardIdx < 1) {
            this.hasCardsInDeck = false;
            return this.initCards[0];
        }
        int returnedCard = this.initCards[--initCardIdx];
        this.initCards[initCardIdx] = 0; // remove the card from player's deck
        return returnedCard;
    }

    int getLastCard(){
        return this.initCards[this.initCards.length - 1];
    }

    int[] getInitCards() {
        return this.initCards;
    }

    int[] getWonCards() {
        return this.wonCards;
    }
}
