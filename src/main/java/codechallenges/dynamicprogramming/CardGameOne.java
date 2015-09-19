package codechallenges.dynamicprogramming;

import java.util.Arrays;

/**
 * CardGameOne
 *
 * YetAnotherCardGame @see
 *
 * http://community.topcoder.com/stat?c=problem_statement&pm=13912
 *
 */
public class CardGameOne {

    public int[] solve(int[] cards1, int[] cards2) {

        int pileIndex = 0;
        int pileCard = 0;
        int[] pile = new int[cards1.length + cards2.length];
        pile[pileIndex] = 0;

        Arrays.sort(cards1);
        Arrays.sort(cards2);

        for (int i = 0; i < cards1.length; i++) {

            for (int j = i; j < cards1.length; j++) {

                if (cards1[j] > pileCard) {
                    pileCard = pile[pileIndex] = cards1[j];
                    pileIndex += 1;
                    break;
                }
            }

            for (int j = 0; j < cards2.length; j++) {

                if (cards2[j] > pileCard) {
                    pileCard = pile[pileIndex] = cards2[j];
                    pileIndex += 1;
                    break;
                }
            }
        }

        return Arrays.copyOf(pile, pileIndex);
    }

    public static void main(String[] args) {
        CardGameOne solver = new CardGameOne();
        int[] cards1 = new int[]{2, 5};
        int[] cards2 = new int[]{3, 1};
        int[] pile = solver.solve(cards1, cards2);
        System.out.println("Pile: " + Arrays.toString(pile) + ", count: " + pile.length);
    }

}
