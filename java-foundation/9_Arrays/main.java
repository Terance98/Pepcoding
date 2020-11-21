/*
THEORY

When an array is declared, the base address is stored in the stack. 
The rest of the memory is allocated in a heap.

a [500] = 10;
a [700] = 20;

Both of these will take the same amount of time, since we are specifying the memory correctly.
Suppose base memory of a is 4000,
then 4000 + 500 x 4 = 6000 will be memory block for 10.
And 6800 will be the memory block for 20.

also if a is an array,
now, b = a 

b[500] = 1;

now a[500] will also change to 1.

This is because Java does shallow copy of array by default.
*/

import java.util.*;

//Span is defined as difference of maximum value and minimum value.
class SpanOfAnArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];
       
        for (int i = 0; i < arr.length; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int greatest = arr[0];
        int smallest = arr[0];

        for ( int i = 0; i < arr.length; i ++ ) {
            
            if ( arr[i] > greatest ) {
                greatest = arr [i];
            }

            if ( arr[i] < smallest ) {
                smallest = arr[i];
            }

        }

        int span = greatest - smallest;
        System.out.println(span);
    } 
}
/*
If number exists, print its index else -1
input
2
34
54
1

output
-1
*/
class CheckNumberExistsInArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < arr.length; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int d = scn.nextInt();
        int idx = -1;
        for ( int i = 0; i < arr.length; i ++ ) {
            if ( arr[i] == d ) {
                idx = i;
                break;
            } 
        }

        System.out.println(idx);
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
			*		
			*		
			*	*	
			*	*	
*			*	*	
*			*	*	
*	*		*	*	
*/
class BarChart {
    public static int findGreatest(int[] arr) {
        int greatest = arr[0];

        for ( int i = 0; i < arr.length; i ++ ) {
            if ( arr[i] > greatest ) {
                greatest = arr [i];
            }
        }

        return greatest;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < arr.length; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int max = findGreatest(arr);

        for ( int floor = max; floor > 0; floor -- ) {
            for ( int j = 0; j < arr.length; j ++ ) {
                if ( arr[j] >= floor ) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
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

6
1
1
1
1
1
1

output
1
4
2
1
8
6
*/

class SumOfTwoArrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];

        for ( int i = 0; i < n1; i ++ ) {
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();

        int[] arr2 = new int[n2];
        for ( int i = 0; i < n2; i ++ ) {
            arr2[i] = scn.nextInt();
        }
        
        int[] sum = new int[ n1 > n2 ? n1 : n2 ];

        int c = 0; //carry
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = sum.length - 1;

        while ( k >= 0 ) {
            int d  = c;

            if ( i >= 0 ) {
                d += arr1[i];
            }

            if ( j >= 0 ) {
                d += arr2[j];
            }

            c = d / 10;
            d = d % 10;

            sum[k] = d;

            i --;
            j --;
            k --;
        }

        if ( c != 0 ) {
            System.out.println(c);
        }

        for ( int val: sum ) {
            System.out.println(val);
        }

    }
}

/*
input
3
2
6
7

4
1
0
0
0

output
7
3
3
*/
class DifferenceOfTwoArrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int[] a1 = new int[n1];

        for ( int i = 0; i < a1.length; i ++ ) {
            a1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] a2 = new int[n2];

        for ( int i = 0; i < a2.length; i ++ ) {
            a2[i] = scn.nextInt();
        }

        int subCarry = 0;

        int[] difference = new int[n2];

        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = difference.length - 1;

        while ( k >= 0 ) {
            int d = 0;

            int a1v = i >= 0 ? a1[i] : 0;
 
            if (a2[j] + subCarry >= a1v) {
                d = a2[j] + subCarry - a1v;
                subCarry = 0;
            } else {
                d = a2[j] + 10 + subCarry - a1v; // borrow a 10 from the penultimate number and set subcarry
                subCarry = -1;
            }

            difference[k] = d;

            k --;
            j --;
            i --;
        }

        int idx = 0;

        //Skip through all the zeroes preceeding the actual result. eg: if difference is [ 0, 0, 2]. The idx skips till idx = 2.
        while(idx < difference.length) {
            if(difference[idx] == 0) {
                idx ++;
            } else {
                break;
            }
        }

        while(idx < difference.length) {
            System.out.println(difference[idx]);
            idx ++;
        }
    }
}

/*
input
3
256
444
24

output
24 444 256 
*/
class ReverseArray_a {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
        sb.append(val + " ");
        }
        System.out.println(sb);
  }

  public static void reverse(int[] arr){
    // write your code here
    int revIndex = (arr.length) - 1;
    for ( int i = 0; i < arr.length / 2; i ++ ) {
       int temp = arr[revIndex];
       arr[revIndex] = arr[i];
       arr[i] = temp;
       revIndex --;
    }
  }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < arr.length; i ++ ) {
            arr[i] = scn.nextInt();
        }

        reverse(arr);
        display(arr);
    }
}

//Another method
class ReverseArray_b {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
        sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void reverse(int[] arr){
        // write your code here
        int li = 0; // left index
        int ri = arr.length - 1; //right index

        while (li < ri) {
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;

            li ++;
            ri --;
        }
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < arr.length; i ++ ) {
            arr[i] = scn.nextInt();
        }

        reverse(arr);
        display(arr);
    }
}


/*
5

1
2
3
4
5

3      (k)

if k is +ve ,rotate to the right else to the left
*/
class RotateArray_a {  
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
        sb.append(val + " ");
        }
        System.out.println(sb);
  }

    public static void rotate(int[] a, int k){
        // write your code here
        if ( k == 0) return;
        k %= a.length;

        //For an array of length 5, k = -1 is equilvalent to k = 4. Hence we can do k + arr.length
        if ( k < 0 ) k = k + a.length;

        while ( k > 0 ) {
            int last = a[a.length - 1];
            int prev = a[0];
            for ( int i = 0; i < a.length - 1; i ++ ) {
                int next = a[i + 1];
                a[i + 1] = prev;
                prev = next;
            }
            a[0] = last;
            k --;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < arr.length; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        rotate(arr, k);
        display(arr);

    }
}

/*
Another method
input
a b c d e f g h
k = 3

P1              P2
a b c d e    |    f g h

Now reverse P1      Now reverse p2
e d c b a        |     h g f

Now reverse the whole thing

f g h a b c d e   => required output
*/
class RotateArray_b {
    public static void reverse(int[] a, int i, int j) {
        int li = i; //left index
        int ri = j; //right index

        while ( li < ri ) {
            int temp = a[li];
            a[li] = a[ri];
            a[ri] = temp;

            li ++;
            ri --;
        }
    }

    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
        sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void rotate(int[] arr, int k) {
        k = k % arr.length;
        if(k < 0) 
            k += arr.length;
        //reverse part 1
        reverse(arr, 0, arr.length - 1 - k);

        //reverse part 2
        reverse(arr, arr.length - k, arr.length - 1 );

        //reverse the whole thing
        reverse(arr, 0, arr.length - 1);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < n; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        rotate(arr, k);
        display(arr);
    }
}

