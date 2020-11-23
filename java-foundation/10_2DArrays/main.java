/*
2D Arrays Theory

When creating a 2D arryay, two heaps are formed.

The stack will contain the base address to the first heap.
The first heap will contain base address to the corresponding next set of heaps.

eg : 3 X 4 array,

Stack will contain a varaible pointer to the base address 4000 of the array
The first heap will have its base address and its next set of values will be base addresses to the corresponding next set of heaps.
i.e, 5k , 6k, 7k etc..
Then next set of heaps will have its base address starting from the correspoinding above values and will have correspoinding addresses 
equivlaent to the no.of columns, here 4
i.e, 5k, 5k + 4, 5k + 8, 5k + 12 etc..
*/

import java.io.*;
import java.util.*;


class TwoD_Array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for ( int i = 0; i < arr.length; i ++ ) {
            for ( int j = 0; j < arr[i].length; j ++ ) {
                arr[i][j] = scn.nextInt();
            }
        }

        //Printing
        for ( int i = 0; i < arr.length; i ++ ) {
            for ( int j = 0; j < arr[i].length; j ++ ) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

/*
Matrix multiplication logic

first row of matrix 1 X each column of matrix 2
second row of matrix 1 X each column of matrix 2
..
nth row of matrix 1 X each column of matrix 2

n1 x m1   X    n2 x m2    => n1 x m2 ( only if m1 == n2 ,i.e, no.of rows for first matrix = no.of columns of second matrix )
*/
class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int m1 = scn.nextInt();

        int[][] n1m1 = new int[n1][m1];

        //Initializing array 1
        for ( int i = 0; i < n1m1.length; i ++ ) {
            for ( int j = 0; j < n1m1[i].length; j ++ ) {
                n1m1[i][j] = scn.nextInt();
            }
        }

        int n2 = scn.nextInt();
        int m2 = scn.nextInt();

        if(m1 != n2) {
            System.out.println("Invalid input");
            return;
        }

        int[][] n2m2 = new int[n2][m2];

        //Initializing array 2
        for ( int i = 0; i < n2m2.length; i ++ ) {
            for ( int j = 0; j < n2m2[i].length; j ++ ) {
                n2m2[i][j] = scn.nextInt();
            }
        }
        

        int[][] prdt = new int[n1][m2];

        for ( int i = 0; i < n1; i ++ ) {  // till no.of rows of first array
            for ( int j = 0; j < m2; j ++ ) { // till no.of columns of 2nd array
                int product = 0;
                for ( int k = 0; k < n2; k ++ ) {  // till no.of rows of 2nd array = no.of columns of the first array
                    product += n1m1[i][k] * n2m2[k][j]; //n1m1[i][k] will be the first array's row & n2m2[k][j] will be second  array's column
                }
                prdt[i][j] = product;
            }
        }


        //Printing
        for ( int i = 0; i < prdt.length; i ++ ) {
            for ( int j = 0; j < prdt[i].length; j ++ ) {
                System.out.print(prdt[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
/*
input
3
4

11
12
13
14
21
22
23
24
31
32
33
34

11 12 13 14
21 22 23 24
31 32 33 34      

First print in downward direction, then up, then down and so on

output
11
21
31

32
22
12

13
23
33

34
24
14
*/
class WaveTraversal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for ( int i = 0; i < n; i ++ ) {
            for ( int j = 0; j < m; j ++ ) {
                arr[i][j] = scn.nextInt();
            }
        }

        for ( int j = 0; j < arr[0].length; j ++ ) {
            if ( j % 2 == 0 ) {
                //For event columns, print arr[i][j] in downward direction
                for ( int i = 0; i < arr.length; i ++ ) {
                    System.out.println(arr[i][j]);
                } 
            } else {
                //For odd columns, print arr[i][j] in upward direction
                for ( int i = arr.length - 1; i >= 0; i -- ) {
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
}

class SpiralTraversal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();  
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        //input the values
        for ( int i = 0; i < arr.length; i ++ ) {
            for ( int j = 0; j < arr[0].length; j ++ ) {
                arr[i][j] = scn.nextInt();
            }
        }  

        int min_row = 0;
        int min_col = 0;
        int max_row = arr.length - 1;
        int max_col = arr[0].length - 1;

        int total_elements = n * m;
        int count = 0;

        while(count < total_elements) {
            //Also we add count < total_elements check in each of th 4 loops so that repeated elements don't get printed.
            //Repeated element print could happen if the matrix is not a perfectly square shaped matrix.

            //left waill
            for ( int i = min_row, j = min_col; i <= max_row && count < total_elements; i ++ ) {
                System.out.println(arr[i][j]);
                count ++;
            }
            min_col ++;
            
            //bottom wall
            for ( int i = max_row, j = min_col; j <= max_col && count < total_elements; j ++ ) {
                System.out.println(arr[i][j]);
                count ++;
            }
            max_row --;

            //right wall
            for ( int i = max_row, j = max_col; i >= min_row && count < total_elements; i -- ) {
                System.out.println(arr[i][j]);
                count ++;
            }
            max_col --;

            //top wall
            for ( int i = min_row, j = max_col; j >= min_col && count < total_elements; j -- ) {
                System.out.println(arr[i][j]);
                count ++;
            }
            min_row ++;
        }
    }
}

class ExitPointOfAMatrix_a {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for ( int i = 0; i < n; i ++ ) {
            for ( int j = 0; j < m; j ++ ) {
                arr[i][j] = scn.nextInt();
            }
        }

        // The user enters from east. Hence we start with direction = 0 which is east.
        /*
        0 -> east
        1 -> south
        2 -> west
        3 -> north
        */
        int direction = 0;

        int i = 0;
        int j = 0;

        while ( i < n && j < m ) {
            //continue moving right
            while (direction == 0 && i < n && j < m) {
                if (arr[i][j] == 1 ) {
                    //turn 90, i.e, to the bottom
                    direction ++;
                    direction %= 4;
                    i ++;
                } else {
                    j ++;
                }
            }
        // System.out.println(i + ", " + j);

            
        //move down
        while (direction == 1 && i < n && j < m) {
            if (arr[i][j] == 1 ) {
                //turn 90, i.e, to the bottom
                direction ++;
                direction %= 4;
                j --;
            } else {
                i ++;
            }
        }

        //move left
        while (direction == 2 && i < n && j < m) {
            if (arr[i][j] == 1 ) {
                //turn 90, i.e, to the bottom
                direction ++;
                direction %= 4;
                i --;
            } else {
                j --;
            }
        }

        //move top
        while (direction == 3 && i < n && j < m) {
            if (arr[i][j] == 1 ) {
                //turn 90, i.e, to the bottom
                direction ++;
                direction %= 4;
                j ++;
            } else {
                i --;
            }
        }
    }

    if ( i > n - 1 ) i --;
    if ( j > m - 1 ) j --;

    System.out.println(i);
    System.out.println(j);
    }
}

//Another solution
class ExitPointOfAMatrix_b {
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

        /*
         The user enters from east. Hence we start with direction = 0 which is east.
        0 -> east
        1 -> south
        2 -> west
        3 -> north
        */
        int direction = 0;

        int i = 0;
        int j = 0;

        while ( true ) {
            direction = ( direction + arr[i][j] ) % 4;

            if (direction == 0) { //east
                j ++;
            } else if (direction == 1) { //south
                i ++;
            } else if (direction == 2) { //west
                j --;
            } else {
                i --; //north
            }


            if ( i < 0 ) {
                i ++;
                break;
            } else if ( j < 0 ) {
                j ++;
                break;
            } else if ( i == arr.length ) {
                i --;
                break;
            } else if ( j == arr[0].length ) {
                j --;
                break;
            }

        }

        System.out.println(i);
        System.out.println(j);
    }
}

class RotateArrayBy90Degree {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] arr = new int[n][n];
        int[][] rotatedArr = new int[n][n];

        for ( int i = 0; i < arr.length; i ++ ) {
            for ( int j = 0; j < arr[0].length; j ++ ) {
                arr[i][j] = scn.nextInt();
            }
        }

        for ( int j = 0; j < arr[0].length; j ++ ) {
            int newIndex = 0;
            for  ( int i = arr.length - 1; i >= 0; i -- ) {
                rotatedArr[j][newIndex] = arr[i][j];
                newIndex ++;
            }
        }

        for ( int i = 0; i < rotatedArr.length; i ++ ) {
            for ( int j = 0; j < rotatedArr[0].length; j ++ ) {
                System.out.print(rotatedArr[i][j] +  " ");
            }
            System.out.println();
        }
    }
}