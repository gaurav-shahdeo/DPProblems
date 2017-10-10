package problems;

// Coin Change Problem using recursion.

public class CoinChangeProblem {

    public static void main(String args[]) {
        int changeFor = 4;
        int[] coins = {1,2,3};

        int result = coinChange(coins, changeFor);
        System.out.println(result);
    }

    private static int coinChange(int[] coins, int changeFor) {
        int m = coins.length;
        return coinChange(coins, m, changeFor);
    }

    private static int coinChange(int[] coins, int m, int changeFor) {
        if(changeFor == 0) return 1;
        if(changeFor < 0) return 0;
        if(m <= 0 && changeFor >= 1) return 0;

        return coinChange(coins, m-1, changeFor) + coinChange(coins, m, changeFor-coins[m-1]);

    }
}
