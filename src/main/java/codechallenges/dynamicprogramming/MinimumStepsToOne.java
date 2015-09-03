/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechallenges.dynamicprogramming;

/**
 *
 * Problem Statement: On a positive integer, you can perform any one of the
 * following 3 steps. 1.) Subtract 1 from it. ( n = n - 1 ) , 2.) If its
 * divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2 ) , 3.) If its
 * divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3 ).
 *
 * Now the question is, given a positive integer n, find the minimum number of
 * steps that takes n to 1
 *
 * Examples: 1.)For n = 1 , output: 0 2.) For n = 4 , output: 2 ( 4 /2 = 2 /2 =
 * 1 ) 3.) For n = 7 , output: 3 ( 7 -1 = 6 /3 = 2 /2 = 1 )
 */
public class MinimumStepsToOne {

    void solve(int n) {

        int x = n;
        int counter = 0;

        if (x == 0) {
            System.out.println("0");
            return;
        }

        while (x > 1) {
            x = min(x);
            counter++;
        }

        System.out.println("For n = " + n + " step count: " + counter + "\n");
    }

    int min(int n) {
        if (n % 3 == 0) {
            System.out.println(n + " % 3");
            return n - ((n - n % 3) / 3);
        }
        if (n % 2 == 0) {
            System.out.println(n + " % 2");
            return n - ((n - n % 2) / 2);
        }
        System.out.println(n + " - 1");
        return n - 1;
    }

    public static void main(String[] args) {
        MinimumStepsToOne solver = new MinimumStepsToOne();
        solver.solve(1);
        solver.solve(2);
        solver.solve(3);
        solver.solve(7);
        solver.solve(10);
        solver.solve(20);
    }

}
