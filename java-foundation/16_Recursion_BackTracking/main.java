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