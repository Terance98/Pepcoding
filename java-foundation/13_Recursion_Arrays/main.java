import java.util.*;
import java.io.*;

/*
input
5
3
1
0
7
5

output
3
1
0
7
5
*/
class ArrayElements {
    public static void printElements(int[] arr, int n) {
        if ( n == 0 ) {
            return;
        }

        printElements(arr, n - 1);
        System.out.println(arr[n - 1]);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < n; i ++ ) {
            arr[i] = scn.nextInt();
        }

        printElements(arr, n);
    }
}

/*
input
5
3
1
0
7
5

output
5
7
0
1
3
*/
class ArrayElementsReverse {
    public static void printElements(int[] arr, int n) {
        if ( n == 0 ) {
            return;
        }

        System.out.println(arr[n - 1]);
        printElements(arr, n - 1);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < n; i ++ ) {
            arr[i] = scn.nextInt();
        }

        printElements(arr, n);
    }
}

/*
input
6
15
30
40
4
11
9

output
40
*/
class MaxOfAnArray {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < n; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int max = maxOfArray(arr, 0);
        System.out.println(max);
    }

    public static int maxOfArray(int[] arr, int idx) {

        if ( idx == arr.length - 1 ) {
            return arr[idx];
        }

        //Max in smaller array
        int misa = maxOfArray(arr, idx + 1);

        if (misa > arr[idx]) {
            return misa;
        } else {
            return arr[idx];
        }
    }
}

/*
input
4 //n

2
3
4
4

4 //x

output
2
*/
class FirstIndex {
     public static int firstIndex(int[] arr, int idx, int x){
        //print the first index of x if x exists in arr, else print -1

        if ( idx == arr.length) {
            return -1;
        }
        
        if (arr[idx] == x) {
            return idx;
        } else {
            //first index in small array
            int fiisa = firstIndex(arr, idx + 1, x);
            return fiisa;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < n; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int x = scn.nextInt();

        int fidx = firstIndex(arr, 0, x);
        System.out.println(fidx);
    }
}

/*
input
4 //n

2
2
3
2

2 //x

output
3
*/
class LastIndex_a {
    public static int lastIndex(int[] arr, int idx, int x) {

        if ( idx == -1 ) {
            return -1;
        }

        if ( arr[idx] == x ) {
            return idx;
        } else {
            int liisa = lastIndex(arr, idx - 1, x);
            return liisa;
        }
        
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < n; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int x = scn.nextInt();

        int lidx = lastIndex(arr, arr.length - 1, x);
        System.out.println(lidx);
    }
}

//Another method
class LastIndex_b {
    public static int lastIndex(int[] arr, int idx, int x) {

        if ( idx == arr.length ) {
            return -1;
        }

        int liisa = lastIndex(arr, idx + 1, x);

        if ( liisa == -1 ) {
            if (arr[idx] == x) {
                return idx;
            } else {
                return -1;
            }
        } else {
            return liisa;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < n; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int x = scn.nextInt();

        int lidx = lastIndex(arr, 0, x);
        System.out.println(lidx);
    }
}

/*
input
6 //n

15
11
40
4
4
9

4 //x

output
3
4
*/
class AllIndicesOfAnArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int x = Integer.parseInt(br.readLine());

        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        //fsf stands for found so far
        if ( idx == arr.length) {
            //Return a new array with size = fsf
            return new int[fsf];
        }

        if ( arr[idx] == x ) {
            int[] iarr = allIndices(arr, x, idx + 1, fsf + 1);
            iarr[fsf] = idx;
            return iarr;
        } else {
            int[] iarr = allIndices(arr, x, idx + 1, fsf);
            return iarr;
        }
    }
}