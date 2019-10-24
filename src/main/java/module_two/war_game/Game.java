package module_two.war_game;

import java.util.ArrayList;
import java.util.List;

public final class Game {

    private Game() {
    }

    static void war(Player player1, Player player2) {
        int round = 1;
        int index = 0;

        while (player1.getInitCards()[0] != 0 || player2.getInitCards()[0] != 0) {
            System.out.print(round + " ");
            int player1Card = player1.getTopCard();
            int player2Card = player2.getTopCard();

            if (player1Card > player2Card) {
                System.out.println(String.format("%s takes this hand!", player1.getName()));
                takeWonCards(player1, player1Card, player2Card);
                index++;
            } else if (player2Card > player1Card) {
                System.out.println(String.format("%s takes this hand!", player2.getName()));
                takeWonCards(player2, player1Card, player2Card);
                index++;
            } else {
                // check if players have 3 more cards
                // if they don't -> compare their last cards -> those who has larger card, wins the hand

                System.out.println("WAR!");

                if (index == 25) {
                    System.out.println("You don't have any cards! Game over!");
                    break;
                }

                if (index + 3 > 25) {
                    System.out.println("You don't have another 3 cards!");
                    System.out.println(player1.getLastCard());
                    System.out.println(player2.getLastCard());
                    break;
                }

                int player1ThirdCard = 0;
                int player2ThirdCard = 0;

                int[] p1ThreeCards = new int[3];
                int[] p2ThreeCards = new int[3];

                for (int i = 0; i < 3; i++) {
                    player1ThirdCard = player1.getTopCard();
                    player2ThirdCard = player2.getTopCard();
                    p1ThreeCards[i] = player1ThirdCard;
                    p2ThreeCards[i] = player2ThirdCard;
                }

                if (player1ThirdCard > player2ThirdCard) {
                    //take all 8 cards (2 + 2 * 3);
                    System.out.println(String.format("  %s won the war!", player1.getName()));
                    takeWonCards(player1, player1Card, player2Card);
                    takeWarCards(player1, p1ThreeCards, p2ThreeCards);
                    index += 4;
                } else if (player2ThirdCard > player1ThirdCard) {
                    System.out.println(String.format("  %s won the war!", player2.getName()));
                    takeWonCards(player2, player1Card, player2Card);
                    takeWarCards(player2, p1ThreeCards, p2ThreeCards);
                    index += 4;
                } else {
                    // gold card
                    List<Integer> cards = new ArrayList<>();
                    int p1NextCard = player1.getTopCard();
                    int p2NextCard = player2.getTopCard();
                    cards.add(p1NextCard);
                    cards.add(p2NextCard);

                    while (p1NextCard == p2NextCard) {
                        p1NextCard = player1.getTopCard();
                        p2NextCard = player2.getTopCard();
                        cards.add(p1NextCard);
                        cards.add(p2NextCard);
                        index++;
                    }

                    if (p1NextCard > p2NextCard) {
                        System.out.println(String.format("  %s won the war!", player1.getName()));
                        cards.forEach(c -> takeWonCards(player1, c));
                    } else {
                        System.out.println(String.format("  %s won the war!", player2.getName()));
                        cards.forEach(c -> takeWonCards(player2, c));
                    }
                }
            }

            System.out.println(index);
            round++;
        }

        printWinner(player1, player2);
    }

    private static void printWinner(Player player1, Player player2) {
        if (player1.getWonCards().length > player2.getWonCards().length) {
            System.out.println(String.format("%s WINS THE GAME!", player1.getName()));
        } else {
            System.out.println(String.format("%s WINS THE GAME!", player2.getName()));
        }
    }

    private static void takeWonCards(Player winner, int... cards) {
        for (int card : cards) {
            winner.addWonCard(card);
        }
    }

    private static void takeWarCards(Player player, int[] p1ThreeCards, int[] p2ThreeCards) {
        for (int card : p1ThreeCards) {
            takeWonCards(player, card);
        }
        for (int card : p2ThreeCards) {
            takeWonCards(player, card);
        }
    }
}
