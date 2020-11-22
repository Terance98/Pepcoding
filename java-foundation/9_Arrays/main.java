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

/*
The logic is same as the inverse of a number

eg : 6 1 2 5 4 3 => 6 3 2 1 4 5

Here the position in determined from the index

input 
5

4
0
2
3
1

output
1
4
2
3
0

The difference here in this question is that the numbers range from 0 to n - 1
*/
class InversOfAnArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];
        int[] res = new int[n];

        for ( int i = 0; i < arr.length; i ++ ) {
            arr[i] = scn.nextInt();
        }

        //Can also be done with a for loop. Using while for readability's sake.
        int startIndex = arr.length - 1;
        while(startIndex >= 0) {
            //Since the numbers range from 0 to n-1, we don't need to subract 1.
            int num = arr[startIndex];  

            res[num] = startIndex;

            startIndex --;
        }

        for ( int i = 0; i < res.length; i ++ ) {
            System.out.println(res[i]);
        }

    }
}
/*
input
3
10
20
30

output
10	
10	20	
10	20	30	
20	
20	30	
30	
*/
class PrintAllSubArrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < n; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int startIndex = 0;
        while ( startIndex < arr.length ) {
            for ( int i = startIndex; i < n; i ++ ) {
                for ( int j = startIndex; j <= i; j ++ ) {
                    System.out.print(arr[j] + "\t");
                }
                System.out.println();
            }
            startIndex ++;
        }
    }
}

/*
For n elements, there will be 2^n subsets

input 
3
10
20
30

output
-	-	-	
-	-	30	
-	20	-	
-	20	30	
10	-	-	
10	-	30	
10	20	-	
10	20	30	

The the output follows the pattern of binary from 0 to 2^n
So we iterate i from 0 -> 2^n. Compute the binary of i at each stage and use 1s and 0s to determine whether to print the num or not.

Here the binaries are considered as 000, 001, 010 ... etc when n = 3
Hence we can store i to a variable temp. Iterate over the array from n - 1 -> 0
We are iterating in reverse order because, each time we compute a binary bit, it will be in the reverse order.
i.e, the first bit computed will be in the last position and the next will be pre-last and so on. 

Then at each iteration over the array, we check if the bit computed over i is 0 or 1. If 0, we append "-" to the string output. 
Else we append arr[j] to the string output.

Then we print the string value for each iteraiton of i.
*/
class SubsetsOfAnArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < arr.length; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int index = 0;
        int limit = (int) Math.pow(2, arr.length);

        for ( int i = 0; i < limit; i ++ ) {
            // Convert i to its equilvalent binary and use 1s and 0s to determine whether to print the number or not 
            int temp = i;
            String set = "";
            for ( int j = arr.length - 1; j >= 0; j -- ) {
                // a[j] will hold the value and the loop is iterated in reverse order such that we get the last element of arr first 
                int d = temp % 2;
                temp /= 2;

                if ( d == 0 ) {
                    set = "-\t" + set;
                } else {
                    set = arr[j] + "\t" + set;
                }
            }
            System.out.println(set);
        }
    }
}

class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int data = 20;

        int low = 0;
        int high = arr.length - 1;

        while ( low <= high ) {
            int mid = ( low + high ) / 2;

            if (data > arr[mid]) {
                low = mid + 1;
            } else if ( data < arr[mid]) {
                high = mid - 1;
            } else {
                System.out.println(mid);
                return;
            }
        }
        System.out.println(-1);
    }
}

/*
input
10

1
5
10
15
22
33
40
42
55
66

34

output
40 //ceil
33 //floor

Logic :
Whenever we move the low, set the floor as array[mid]
Whenever we move the high, set the ceil as array[mid]
*/

class CeilAndFloorInAnArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < arr.length; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int data = scn.nextInt();

        int low = 0;
        int high = arr.length - 1;

        int floor = 0;
        int ceil = 0;
        
        while ( low <= high ) {
            int mid = ( low + high ) / 2;

            if ( data > arr[mid] ) {
                floor = arr[mid];
                low = mid + 1;
            } else if ( data < arr[mid] ) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                ceil = arr[mid];
                floor = arr[mid];
                break; 
            }
        }

        System.out.println(ceil);
        System.out.println(floor);
    }
}
/*
A modification of the binary serach.
Here we use two sets of binary searches to fnd the lowest and highest indexes

To find the highest index, even after finding the element, we will move the low to mid + 1 and continue to loop unitl the loop breaks
eventually when low exceeds high

Similarly to find the lowest index, after findind the first match, we will move high to mid - 1 and continue looping until the loop breaks

In both these loops, each time a match happens, we will assign its corresponding index to the respective firstIndex or lastIndex variable.
*/
class FirstIndexAndLastIndex {
    public static void main(String [] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for ( int i = 0; i < arr.length; i ++ ) {
            arr[i] = scn.nextInt();
        }

        int data = scn.nextInt();

        int low = 0;
        int high = arr.length - 1;

        int lastIndex = -1;
        while ( low <= high ) {
            int mid = ( low + high ) / 2;

            if ( data > arr[mid] ) {
                low = mid + 1;
            } else if ( data < arr[mid] ) {
                high = mid - 1;
            } else {
                lastIndex = mid;
                low = mid + 1; //looking further to the right to see if the elements still repeats or not.
            }
        }

        int firstIndex = -1;
        low = 0;
        high = arr.length - 1;

        while ( low <= high ) {
            int mid = ( low + high ) / 2;

            if ( data > arr[mid] ) {
                low = mid + 1;
            } else if ( data < arr[mid] ) {
                high = mid - 1;
            } else {
                firstIndex = mid;
                high = mid - 1; //looking further to the left to see if the elements still repeats or not.
            }
        }

        System.out.println(lastIndex);
        System.out.println(firstIndex);
        
    }
}