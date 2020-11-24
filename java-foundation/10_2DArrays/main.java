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

/*
input
3
5

11
12
13
14
15
21
22
23
24
25
31
32
33
34
35

output
11
21
31
32
33
34
35
25
15
14
13
12
22
23
24

*/
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

/*
input
4
4

0
0
1
0
1
0
0
0
0
0
0
0
1
0
1
0

output
1
3
*/
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

/*
input
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
41
42
43
44

output
41 31 21 11
42 32 22 12
43 33 23 13
44 34 24 14
*/

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

/*
5  //n
7  //m

11
12
13
14
15
16
17
21
22
23
24
25
26
27
31
32
33
34
35
36
37
41
42
43
44
45
46
47
51
52
53
54
55
56
57

2 //s
3 //r
*/
class ShellRotate {
    public static void reverse( int[] one_D, int li, int ri) {
        while ( li < ri) {
            int temp = one_D[li];
            one_D[li] = one_D[ri];
            one_D[ri] = temp;

            li ++;
            ri --;
        }
    }

    public static void rotate(int[] one_D, int r) {
        r = r % one_D.length;

        if ( r < 0 ) {
            r += one_D.length;
        }

        reverse(one_D, 0, one_D.length - r - 1);
        reverse(one_D, one_D.length - r, one_D.length - 1);
        reverse(one_D, 0, one_D.length - 1);
    }

    public static int[] fillOneDFromShell(int[][] arr, int s) {
        int min_row = s - 1;
        int min_col = s - 1;

        int max_row = arr.length - s;
        int max_col = arr[0].length - s;

        /*
        size of 1 D array = ( left_wall + bottom_wall + right_wall + top_wall ) - 4 
        (4 is subracted because corners will be repeated each time and since there are 4 corners, 4 repeats.)

        left_wall = (max_row - min_row) + 1 . 
        (One is added because if we take 4 - 1, we will get 3 but actually there are 4 elements => (1 2 3 4 ))

        bottom_wall = (max_col - min_col) + 1.

        Since left_wall == right wall && bottom_wall == top_wall , we can write

        size = (2 * left_wall + 2 * bottom_wall) - 4
             = 2 * (max_row - min_row + 1) + 2 * (max_col - min_col + 1) - 4
             = 2 * (max_row - min_row) + 2 * (max_col - min_col) + 2 + 2 - 4     ( +4 and -4 will cancel)
             = 2 * (max_row - min_row + max_col - min_col)

        */
        int sz =  2 * (max_row - min_row + max_col - min_col );

        int[] one_D = new int[sz];

        int k = 0;
        //Read and assign left wall
        for ( int i = min_row, j = min_col; i <= max_row; i ++ ) {
            one_D[k ++] = arr[i][j];
        }

        //Read and assign bottom wall
        for ( int i = max_row, j = min_col + 1; j <= max_col; j ++ ) {
            one_D[k ++] = arr[i][j];
        }

        //Read and assign right wall
        for ( int i = max_row - 1, j = max_col; i >= min_row; i -- ) {
            one_D[k ++] = arr[i][j];
        }

        //Read and assign top wall
        for ( int i = min_row, j = max_col - 1; j >= min_col + 1; j -- ) {
            one_D[k ++] = arr[i][j];
        }


        return one_D;
    }

    public static void fillShellFromOneD(int[][] arr, int s, int[] one_D) {
        int min_row = s - 1;
        int min_col = s - 1;

        int max_row = arr.length - s;
        int max_col = arr[0].length - s;

        int k = 0;
        //Read and assign left wall
        for ( int i = min_row, j = min_col; i <= max_row; i ++ ) {
            arr[i][j] = one_D[k ++];
        }

        //Read and assign bottom wall
        for ( int i = max_row, j = min_col + 1; j <= max_col; j ++ ) {
            arr[i][j] = one_D[k ++];
        }

        //Read and assign right wall
        for ( int i = max_row - 1, j = max_col; i >= min_row; i -- ) {
            arr[i][j] = one_D[k ++];
        }

        //Read and assign top wall
        for ( int i = min_row, j = max_col - 1; j >= min_col + 1; j -- ) {
            arr[i][j] = one_D[k ++];
        }
    }

    public static void rotateShell(int[][] arr, int s, int r) {
        int[] one_D = fillOneDFromShell(arr, s);
        rotate(one_D , r);
        fillShellFromOneD(arr, s, one_D);
    }

    public static void display(int[][]arr) {
        for ( int i = 0; i < arr.length; i ++ ) {
            for ( int j = 0; j < arr[0].length; j ++ ) {
                System.out.print(arr[i][j] +  "\t");
            }
            System.out.println();
        }
    }
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

        int s = scn.nextInt();  //shell number
        int r = scn.nextInt(); //no.of times to rotate

        rotateShell(arr, s, r);
        display(arr);
    }
}

/*
input
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
41
42
43
44

output
11
22
33
44
12
23
34
13
24
14
*/
class DiagonalTraversal {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] arr = new int[n][n];

        for ( int i = 0; i < n; i ++ ) {
            for ( int j = 0; j < n; j ++ ) {
                arr[i][j] = scn.nextInt();
            }
        }

        //Here g denotes each diagonal
        for ( int g = 0; g < arr.length; g ++ ) {
            for ( int i = 0, j = g; j < arr.length; i ++, j ++ ) {
                System.out.println(arr[i][j]);
            }
        }
    }
}

/*
input
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
41
42
43
44

output
41
*/
class SaddlePoint_a {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] arr = new int[n][n];
        int saddlePoint = -1;

        for ( int i = 0; i < n; i ++ ) {
            for ( int j =0; j < n; j ++ ) {
                arr[i][j] = scn.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i ++ ) {
            //smallj is used to store the column index of smallest element while traversing row wise.
            int smallj = 0;

            //Set the first element in the row as the smallest
            int smallest = arr[i][0];

            //Iterate through the row to determine the smallest.
            //Once the iteration is done, we have the smallest element and its column index at smallj
            for ( int j = 1; j < arr[0].length; j ++ ) {
                if ( arr[i][j] < smallest ) {
                    smallest = arr[i][j];
                    smallj = j;
                }
            }

            //Store the first element in the column as the largest
            int largest = arr[0][smallj];

            //Iterate through the rest of the elements in the column to determine the largest
            for ( int k = 1, j = smallj; k < arr.length; k ++ ) {
                if ( arr[k][j] > largest ) {
                    largest = arr[k][j];
                }
            }

            if ( smallest == largest ) {
                saddlePoint = smallest;
            }
        }

        if ( saddlePoint < 0 ) {
            System.out.println("Invalid input");
        } else {
            System.out.println(saddlePoint);
        }
    }
}

//Another method
class SaddlePoint_b {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] arr = new int[n][n];
        int saddlePoint = -1;

        for ( int i = 0; i < n; i ++ ) {
            for ( int j =0; j < n; j ++ ) {
                arr[i][j] = scn.nextInt();
            }
        }

        //Iterate through each row
        for ( int i = 0; i < arr.length; i ++ ) {
            int svj = 0; // Used to store the index j which holds the smallest element in the row

            for ( int j = 1; j < arr[0].length; j ++ ) {
                if ( arr[i][j] < arr[i][svj]) {
                    svj = j; //Storing the smallest value of j to svj
                }
            }

            /*
            Now arr[i][svj] will contain the smallest element in the row
            We will iterate through the column and check if any element arr[k][svj] is greater than arr[i][svj].
            If yes then we set flag as flase and break.
            */
            Boolean flag = true;
            for ( int k = 0; k < arr.length; k ++ ) {
                if ( arr[k][svj] > arr[i][svj]) {
                    flag = false;
                    break;
                }
            }

            if ( flag == true ) {
                System.out.println(arr[i][svj]);
                return;
            }

        }

        //If the loop exists and still the function hasn't returned, then no saddle point was found
        System.out.println("Invalid input");
    }
}

class SearchInASortedArray_a {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] arr = new int[n][n];

        for ( int i = 0; i < arr.length; i ++ ) {
            for ( int j = 0; j < arr[0].length; j ++ ) {
                arr[i][j] = scn.nextInt();
            }
        }

        int data = scn.nextInt();

        for ( int i = 0; i < arr.length; i ++ ) {

            int high = arr[0].length - 1;
            int low = 0;
            
            while ( low <= high ) {
                int mid = (low + high) / 2;

                if ( data > arr[i][mid] ) {
                    low = mid + 1;
                } else if ( data < arr[i][mid] ) {
                    high = mid - 1;
                } else {
                    System.out.println(i);
                    System.out.println(mid);
                    return;
                }
            }
        }
        System.out.println("Not Found");
    }
}

/*
Another solution

11 12 13 14
21 22 23 24
31 32 33 34
41 42 43 44

If we take a look at the above array, since its sorted, we can start the iteration from arr[0][arr[0].length - 1] ( which is elem 14 here )

Now we can iterate either to the left with j -- if arr[i][j] is less than X
Or to the bottom with i ++ if arr[i][j] is greater than X
*/
class SearchInASortedArray_b {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] arr = new int[n][n];

        for ( int i = 0; i < arr.length; i ++ ) {
            for ( int j = 0; j < arr[0].length; j ++ ) {
                arr[i][j] = scn.nextInt();
            }
        }

        int data = scn.nextInt();

        int i = 0;
        int j = arr[0].length - 1;
        while ( i < arr.length && j >= 0 ) {
            if ( arr[i][j] == data ) {
                System.out.println(i);
                System.out.println(j);
                return;
            } else if ( data < arr[i][j] ) { //Iterate to the left with j --
                j --;
            } else { // i.e, if arr[i][j] > data. Then we iterate downwards with i ++
                i ++;
            }
        }
        System.out.println("Not Found");
    }
}
