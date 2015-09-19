package codechallenges.dynamicprogramming;

/**
 * StrategyGameOne
 *
 * AI for the game.
 *
 * Each SCV has some amount of hit points. When hero attacks, it can target up
 * to three different SCVs. The first targeted SCV will lose 9 hit points. The
 * second targeted SCV (if any) will lose 3 hit points. The third targeted SCV
 * (if any) will lose 1 hit point.
 *
 * You are given a int[] x containing the current hit points of your enemy's
 * SCVs. Return the smallest number of attacks in which you can destroy all
 * these SCVs.
 *
 * @link http://community.topcoder.com/stat?c=problem_statement&pm=13761
 *
 */
public class StrategyGameOne {

    public int solve(int[] hitPoints) {
        return 0;
    }

    int hitPoints(int current) {
        return current > 1 ? current / 3 : 0;
    }

    public static void main(String[] args) {
        StrategyGameOne solver = new StrategyGameOne();
        int[] hitPoints = new int[]{10, 20, 30};
        int hitCount = solver.solve(hitPoints);
        System.out.println("# of hits: " + hitCount);
    }

}
