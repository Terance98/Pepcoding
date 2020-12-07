import java.util.*;
import java.io.*;

/*
input
10

output
55

Print the nth fibonacci number in the series
*/
class Fibonacci {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        //For an input n, there will be n + 1 fibonacci elements. Because we have to store elements from 0 till n (including n)
        int fib = FibMemoized(n, new int[n + 1]);
        System.out.println(fib);
    }

    /*
        There are so many repeated recursion calls in this method. Therefore the time complexity is worse in this method.
        It follows 2^n complexity.
    */
    public static int Fib( int n ) {
        if ( n == 0 || n == 1 ) {
            return n;
        }

        int fibnm1 = Fib( n - 1 );
        int fibnm2 = Fib( n - 2 );

        int fibn = fibnm1 + fibnm2;

        return fibn; 
    }

    //This method folllows linear complexity, i.e, n
    public static int FibMemoized( int n, int[] qb ) {
        if ( n == 0 || n == 1 ) {
            return n;
        }

        if ( qb[n] != 0 ) {
            return qb[n];
        }

        int fibnm1 = FibMemoized( n - 1, qb );
        int fibnm2 = FibMemoized( n - 2, qb );

        int fibn = fibnm1 + fibnm2;

        qb[n] = fibn;
        return fibn; 
    }
}

//Another method of DP -> tabulation
class ClimbStairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        // int cp = countPaths(n, new int[n + 1]);  //Memoization
        int cp = countPathsTab(n);  //Tabulation
        System.out.println(cp);
    }

    //Memoization method
    public static int countPaths(int n, int[] qb) {

        if ( n < 0 ) {
            return 0;
        }

        if ( n == 0 ) {
            return 1;
        }

        int nm1 = countPaths(n - 1, qb);
        int nm2 = countPaths(n - 2, qb);
        int nm3 = countPaths(n - 3, qb);

        int cp = nm1 + nm2 + nm3;

        qb[n] = cp;
        return cp;
    }

    //Tabulation method
    public static int countPathsTab(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for ( int i = 1; i <= n; i ++ ) {
            if ( i == 1 ) {
                dp[i] = dp[i - 1];
            } else if ( i == 2 ) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }

        return dp[n];
    }
}