import java.io.*;
import java.util.*;

/*
input
8
8
0 1 0 0 0 0 0 0
0 1 0 1 1 1 1 0
0 1 0 1 0 0 0 0
0 1 0 1 0 1 1 1
0 0 0 0 0 0 0 0
0 1 0 1 1 1 1 0
0 1 0 1 1 1 1 0
0 1 0 0 0 0 0 0

output
ddddrrttttrrrrrddlllddrrrddd
ddddrrdddrrrrr
ddddrrrrrrrddd
*/
class FloodFill {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for ( int i = 0; i < arr.length; i ++ ) {
            for ( int j = 0; j < arr[0].length; j ++ ) {
                arr[i][j] = scn.nextInt();
            }
        }

        boolean[][] visited = new boolean[n][m];
        floodfill(arr, 0, 0, "", visited);
    }

    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited) {

        if ( row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1 || visited[row][col] == true) {
            return;
        }

        if ( row == maze.length - 1 && col == maze[0].length - 1 ) {
            System.out.println(psf);
            return;
        }

        visited[row][col] = true;
        floodfill(maze, row - 1, col, psf + "t", visited);
        floodfill(maze, row, col - 1, psf + "l", visited);
        floodfill(maze, row + 1, col, psf + "d", visited);
        floodfill(maze, row, col + 1, psf + "r", visited);
        visited[row][col] = false;
    }
}

/*
input
5
10
20
30
40
50
60

output
10, 20, 30, .
10, 50, .
20, 40, .
*/

class TargetSumSubsets {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for ( int i = 0; i < n ; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int tar = scn.nextInt();

        printTargetSumSubsets(arr, 0, "", 0, tar);
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {

        /*
        For some subsets, the sos can go bigger than the tar. This is an early return method.
        It is not necessary to use this base case since when idx becomes equal to arr.length, we will check for the equality 
        of the sum anyways. At that point if sos mismatches with tar, we will return without printing anything.
        */
        if (sos > tar) {
            return;
        }

        if ( idx == arr.length ) {
            if ( sos == tar ) {
                System.out.println(set + ".");
            }
            return;
        }
        
        //move on to the next stage with the the present element
        printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", sos +  arr[idx], tar);

        //move on to the next stage without the present element
        printTargetSumSubsets(arr, idx + 1, set, sos, tar);
    }
}

/*
input
4

output
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .
*/
class NQueens {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] chess = new int[n][n];

        printNQueens(chess, "", 0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        /*
            During the recursion, the row gets incremented by 1 at each call. If at any point of the recursion, if we fail to place
            a queen in that particular row, the row will fall back and decrement. And also, the value in that [row][col] will  be made 0.
            This falling back of row ensures that the row won't get equal to chess.length. Hence that path won't be printed.
            Only if we are able to place a queen in each row, will we be able to make the required recursive calls such that
            the value of row will get equal to the chess.length
        */
        if ( row == chess.length ) {
            System.out.println(qsf + ".");
            return;
        }

        for ( int col = 0; col < chess.length; col ++ ) {
            if ( isItASafePlaceForTheQueen(chess, row, col) == true ) {
                chess[row][col] = 1;
                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    public static boolean isItASafePlaceForTheQueen(int[][] chess, int row, int col) {
        //checking the top
        for ( int i = row - 1, j = col; i >= 0; i -- ) {
            if ( chess[i][j] == 1 ) {
                return false;
            }
        }

        //checking the left diagonal
        for ( int i = row - 1, j = col - 1; i >= 0 && j >= 0; i -- , j -- ) {
            if ( chess[i][j] == 1 ) {
                return false;
            }
        }

        //checking the right diagonal
        for ( int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i -- , j ++ ) {
            if ( chess[i][j] == 1 ) {
                return false;
            }
        }

        return true;
    }
}

/*
input 
5
3
3

output
21 6 17 12 19 
16 11 20 7 2 
5 22 3 18 13 
10 15 24 1 8 
23 4 9 14 0 

23 6 17 12 0 
16 11 24 7 2 
5 22 3 18 13 
10 15 20 1 8 
21 4 9 14 19 

0 6 17 12 23 
16 11 24 7 2 
5 18 3 22 13 
10 15 20 1 8 
19 4 9 14 21 

19 6 17 12 21 
16 11 20 7 2 
5 18 3 22 13 
10 15 24 1 8 
0 4 9 14 23 

0 8 3 14 19 
4 13 18 9 2 
7 24 5 20 15 
12 17 22 1 10 
23 6 11 16 21 

19 8 3 14 0 
4 13 18 9 2 
7 20 5 24 15 
12 17 22 1 10 
21 6 11 16 23 

21 8 3 14 19 
4 13 20 9 2 
7 22 5 18 15 
12 17 24 1 10 
23 6 11 16 0 

23 8 3 14 0 
4 13 24 9 2 
7 22 5 18 15 
12 17 20 1 10 
21 6 11 16 19 

21 12 3 8 19 
4 17 20 13 2 
11 22 9 18 7 
16 5 24 1 14 
23 10 15 6 0 

23 12 3 8 0 
4 17 24 13 2 
11 22 9 18 7 
16 5 20 1 14 
21 10 15 6 19 

23 12 3 8 21 
4 17 22 13 2 
11 24 9 20 7 
16 5 18 1 14 
0 10 15 6 19 

21 12 3 8 23 
4 17 22 13 2 
11 20 9 24 7 
16 5 18 1 14 
19 10 15 6 0 

21 14 3 8 19 
4 9 20 15 2 
13 22 11 18 7 
10 5 24 1 16 
23 12 17 6 0 

23 14 3 8 0 
4 9 24 15 2 
13 22 11 18 7 
10 5 20 1 16 
21 12 17 6 19 

0 14 3 8 23 
4 9 24 15 2 
13 18 11 22 7 
10 5 20 1 16 
19 12 17 6 21 

19 14 3 8 21 
4 9 20 15 2 
13 18 11 22 7 
10 5 24 1 16 
0 12 17 6 23 

23 16 3 8 21 
4 9 22 17 2 
15 24 13 20 7 
10 5 18 1 12 
0 14 11 6 19 

21 16 3 8 23 
4 9 22 17 2 
15 20 13 24 7 
10 5 18 1 12 
19 14 11 6 0 

0 16 3 8 23 
4 9 24 17 2 
15 18 13 22 7 
10 5 20 1 12 
19 14 11 6 21 

19 16 3 8 21 
4 9 20 17 2 
15 18 13 22 7 
10 5 24 1 12 
0 14 11 6 23 

0 14 3 8 19 
4 9 18 13 2 
17 24 15 20 7 
10 5 22 1 12 
23 16 11 6 21 

19 14 3 8 0 
4 9 18 13 2 
17 20 15 24 7 
10 5 22 1 12 
21 16 11 6 23 

23 14 3 8 21 
4 9 22 13 2 
17 24 15 20 7 
10 5 18 1 12 
0 16 11 6 19 

21 14 3 8 23 
4 9 22 13 2 
17 20 15 24 7 
10 5 18 1 12 
19 16 11 6 0 

23 10 3 16 21 
4 15 22 11 2 
9 24 7 20 17 
14 5 18 1 12 
0 8 13 6 19 

21 10 3 16 23 
4 15 22 11 2 
9 20 7 24 17 
14 5 18 1 12 
19 8 13 6 0 

0 10 3 16 19 
4 15 18 11 2 
9 24 7 20 17 
14 5 22 1 12 
23 8 13 6 21 

19 10 3 16 0 
4 15 18 11 2 
9 20 7 24 17 
14 5 22 1 12 
21 8 13 6 23 

0 16 5 10 19 
6 11 18 15 4 
17 24 3 20 9 
12 7 22 1 14 
23 2 13 8 21 

19 16 5 10 0 
6 11 18 15 4 
17 20 3 24 9 
12 7 22 1 14 
21 2 13 8 23 

23 16 5 10 21 
6 11 22 15 4 
17 24 3 20 9 
12 7 18 1 14 
0 2 13 8 19 

21 16 5 10 23 
6 11 22 15 4 
17 20 3 24 9 
12 7 18 1 14 
19 2 13 8 0 

21 4 17 10 19 
14 9 20 5 16 
3 22 15 18 11 
8 13 24 1 6 
23 2 7 12 0 

23 4 17 10 0 
14 9 24 5 16 
3 22 15 18 11 
8 13 20 1 6 
21 2 7 12 19 

0 4 17 10 23 
14 9 24 5 16 
3 18 15 22 11 
8 13 20 1 6 
19 2 7 12 21 

19 4 17 10 21 
14 9 20 5 16 
3 18 15 22 11 
8 13 24 1 6 
0 2 7 12 23 

0 4 15 10 19 
16 9 18 5 14 
3 24 13 20 11 
8 17 22 1 6 
23 2 7 12 21 

19 4 15 10 0 
16 9 18 5 14 
3 20 13 24 11 
8 17 22 1 6 
21 2 7 12 23 

21 4 15 10 19 
16 9 20 5 14 
3 22 13 18 11 
8 17 24 1 6 
23 2 7 12 0 

23 4 15 10 0 
16 9 24 5 14 
3 22 13 18 11 
8 17 20 1 6 
21 2 7 12 19 

23 4 13 10 21 
14 9 22 5 12 
3 24 11 20 17 
8 15 18 1 6 
0 2 7 16 19 

21 4 13 10 23 
14 9 22 5 12 
3 20 11 24 17 
8 15 18 1 6 
19 2 7 16 0 

0 4 13 10 19 
14 9 18 5 12 
3 24 11 20 17 
8 15 22 1 6 
23 2 7 16 21 

19 4 13 10 0 
14 9 18 5 12 
3 20 11 24 17 
8 15 22 1 6 
21 2 7 16 23 

21 4 11 16 19 
12 17 20 5 10 
3 22 9 18 15 
8 13 24 1 6 
23 2 7 14 0 

23 4 11 16 0 
12 17 24 5 10 
3 22 9 18 15 
8 13 20 1 6 
21 2 7 14 19 

23 4 11 16 21 
12 17 22 5 10 
3 24 9 20 15 
8 13 18 1 6 
0 2 7 14 19 

21 4 11 16 23 
12 17 22 5 10 
3 20 9 24 15 
8 13 18 1 6 
19 2 7 14 0 

21 4 9 14 19 
10 15 20 5 8 
3 22 7 18 13 
16 11 24 1 6 
23 2 17 12 0 

23 4 9 14 0 
10 15 24 5 8 
3 22 7 18 13 
16 11 20 1 6 
21 2 17 12 19 

0 4 9 14 23 
10 15 24 5 8 
3 18 7 22 13 
16 11 20 1 6 
19 2 17 12 21 

19 4 9 14 21 
10 15 20 5 8 
3 18 7 22 13 
16 11 24 1 6 
0 2 17 12 23 

23 4 7 12 21 
8 13 22 17 6 
3 24 5 20 11 
14 9 18 1 16 
0 2 15 10 19 

21 4 7 12 23 
8 13 22 17 6 
3 20 5 24 11 
14 9 18 1 16 
19 2 15 10 0 

0 4 7 12 23 
8 13 24 17 6 
3 18 5 22 11 
14 9 20 1 16 
19 2 15 10 21 

19 4 7 12 21 
8 13 20 17 6 
3 18 5 22 11 
14 9 24 1 16 
0 2 15 10 23 
*/
class KnightsTour {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] chess = new int[n][n];

        int row = scn.nextInt();
        int col = scn.nextInt();

        printKnightsTour(chess, row, col, 1);
    }

    public static void printKnightsTour(int[][] chess, int row, int col, int move) {

        if ( row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] > 0 ) {
            return;
        }

        if ( move == chess.length * chess.length ) { //the last move
            chess[row][col] = move;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }
        
        chess[row][col] = move;
        printKnightsTour(chess, row - 2, col + 1, move + 1);
        printKnightsTour(chess, row - 1, col + 2, move + 1);
        printKnightsTour(chess, row + 1, col + 2, move + 1);
        printKnightsTour(chess, row + 2, col + 1, move + 1);

        printKnightsTour(chess, row + 2, col - 1, move + 1);
        printKnightsTour(chess, row + 1, col - 2, move + 1);
        printKnightsTour(chess, row - 1, col - 2, move + 1);
        printKnightsTour(chess, row - 2, col - 1, move + 1);
        chess[row][col] = 0;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
