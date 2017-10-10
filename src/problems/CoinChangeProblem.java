package problems;


import java.util.Arrays;

public class CoinChangeProblem {

    public static void main(String args[]) {
        int changeFor = 4;
        int[] coins = {1,2,3};

        int result = coinChange(coins, changeFor);
        System.out.println(result);
    }

    private static int coinChange(int[] coins, int changeFor) {
        int m = coins.length;
        return coinChangeDP(coins, m, changeFor);
    }

    private static int coinChangeDP(int[] coins, int m, int changeFor) {
        int[] table = new int[changeFor+1];
        table[0] = 1;

        for(int i = 0; i < m; i++) {
            for(int j=coins[i]; j<=changeFor; j++) {
                table[j] += table[j-coins[i]];
            }
        }

        return table[changeFor];
    }

    // Coin Change Problem using recursion.
    private static int coinChangeRecursion(int[] coins, int m, int changeFor) {
        if(changeFor == 0) return 1;
        if(changeFor < 0) return 0;
        if(m <= 0 && changeFor >= 1) return 0;

        return coinChangeRecursion(coins, m-1, changeFor) + coinChangeRecursion(coins, m, changeFor-coins[m-1]);
    }

    // Coin Change Problem using Dynamic Programming.



}
