package module_two.war_game;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        CardDeck deck = new CardDeck();
        Player lori = new Player("Lori");
        Player grigor = new Player("Grigor");
        deck.dealingCards(lori, grigor);

        System.out.println(Arrays.toString(lori.getInitCards()));
        System.out.println(Arrays.toString(grigor.getInitCards()));

        /*
        [7, 4, 12, 10, 11, 9, 11, 10, 8, 9, 7, 6, 7, 3, 4, 4, 6, 2, 3, 3, 13, 13, 12, 10, 13, 14]
        [8, 11, 10, 9, 9, 5, 11, 8, 6, 2, 8, 2, 6, 7, 2, 3, 5, 4, 5, 13, 14, 12, 12, 5, 14, 14]

        [11, 13, 12, 10, 11, 8, 4, 9, 7, 5, 4, 8, 2, 8, 7, 5, 3, 3, 3, 11, 10, 13, 14, 14, 3, 13]
        [12, 13, 6, 12, 10, 10, 6, 2, 8, 2, 9, 6, 7, 7, 6, 4, 5, 4, 5, 9, 9, 11, 14, 14, 2, 12]

        [11, 13, 6, 2, 4, 8, 11, 10, 9, 5, 7, 6, 8, 7, 2, 5, 2, 3, 4, 14, 7, 14, 9, 13, 13, 8]
        [11, 13, 4, 11, 12, 8, 10, 10, 3, 9, 5, 6, 4, 7, 5, 2, 6, 3, 3, 10, 14, 12, 14, 12, 12, 9]
         */

        Game.war(lori, grigor);
    }
}
