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

/*
intput
10

3
3
0
2
1
2
4
2
0
0

output
5
*/
class ClimbStairsWithVariableJumps {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < arr.length; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int[] dp = new int[n + 1];

        dp[n] = 1;

        for ( int i = n - 1; i >= 0; i -- ) {
            // i + j should be less than the length of dp, because the indexing should not exceed the dp
            for ( int j = 1; j <= arr[i] && i + j < dp.length; j ++ ) {
                dp[i] += dp[i + j];
            }
        }   

        System.out.println(dp[0]);
    }
}

/*
input
10

3
3
0
2
1
2
4
2
0
0

output
4
*/
class ClimbStairsWithMinimumMoves {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for ( int i = 0; i < arr.length; i ++ ) {
            arr[i] = scn.nextInt();
        }

        Integer[] dp = new Integer[n + 1];

        //At the nth position, there will be 1 path but the no.of moves will be 0
        dp[n] = 0;

        // We set the direction from n - 1 to 0 for the input array containing jumps
        for ( int i = n - 1; i >= 0; i -- ) {
            //Only if the jumps possible are greater than 0
            if ( arr[i] > 0 ) {
                int min = Integer.MAX_VALUE;

                // j represents the jumps possible, from 1 to arr[i]. Also i + j should be less than dp.length since it shouldn't 
                // go out of index from the array
                for ( int j = 1; j <= arr[i] && i + j < dp.length; j ++ ) {
                    if ( dp[i + j] != null ) {
                        //From every jump possible, we will choose the jump with the least jumps required to reach the desitnation as min
                        //Later on we add 1 to that min value to set the dp[i]
                        min = Math.min(min, dp[i + j]);
                    }
                }
                
                // If min didn't undergo any change, it means that the value at all the jumps dp[i + j] was null.
                // So we won't set the value of dp[i] and hence it will remain as null
                // Else if it has been changed, then we update dp[i] = min + 1.
                // Since it takes one extra jump from dp[i] to the set of jumps already in min inorder to reach the final destination
                if ( min != Integer.MAX_VALUE ) {
                    dp[i] = min + 1;
                }
            }
        }

        System.out.println(dp[0]);
    }
}

/*
input
6
6

0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1

output
23
*/
class MinCostInMazeTraversal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for ( int i = 0; i < arr.length; i ++ ) {
            for ( int j = 0; j < arr[0].length; j ++ ) {
                arr[i][j] = scn.nextInt();
            }
        }

        Integer[][] dp =  new Integer[n][m];

        for ( int i = dp.length - 1; i >= 0; i -- ) {
            for ( int j = dp[0].length - 1; j >= 0; j -- ) {

                if ( i == dp.length - 1 && j == dp[0].length - 1 ) { //last most item ( bottom right )
                    dp[i][j] = arr[i][j];
                } else if ( i == dp.length - 1 ) { // last row
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                } else if ( j == dp[0].length - 1 ) { // last colummn
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                } else  { // the rest of it
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + arr[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}

/*
input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1

output
33
*/
class GoldMine {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for ( int i = 0; i < arr.length; i ++ ) {
            for ( int j = 0; j < arr[0].length; j ++ ) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][m];

        for (int j = arr[0].length - 1; j >= 0; j--) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (j == arr[0].length - 1) { //right most column with no value change
                    dp[i][j] = arr[i][j];
                } else if (i == 0) { //first row
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if (i == arr.length - 1) { //last row
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else { //the rest of it
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
                }
            }
        }


        int max = dp[0][0];
        for ( int i = 1; i < dp.length; i++ ) {
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }

        System.out.println(max);
    } 
}