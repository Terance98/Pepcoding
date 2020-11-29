import java.util.*;
import java.io.*;

/*
input
5

output
5
4
3
2
1
*/
class PrintDecreasing {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        printDecreasing(n);
    }

    public static void printDecreasing(int n){
        if ( n == 0 ) {
            return;
        }

        System.out.println(n);
        printDecreasing(n - 1);
    }

}

/*
input
3

output
1
2
3
*/
class PrintIncreasing {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        printIncreasing(n);
    }

    public static void printIncreasing(int n) {
        if ( n == 0 ) {
            return;
        }

        printIncreasing( n - 1);
        System.out.println(n);
    }

}

/*
input 
3

output
3
2
1
1
2
3
*/
class PrintDecreasingIncreasing {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        pdi(n);
    }

    public static void pdi(int n) {
        if ( n == 0 ) {
            return;
        }

        System.out.println(n);
        pdi( n - 1);
        System.out.println(n);
    }
}

/*
input 
5

output
120
*/
class FactorialRecursive {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int f = factorial(n);
        System.out.println(f);
    }

    public static int factorial(int n){
        if ( n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

}

/*
input
2   //input
5   //output


output
32
*/
class PowerLinear {
     public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int x = scn.nextInt();
        int n = scn.nextInt();

        int pow = power(x, n);
        System.out.println(pow);
    }

    public static int power(int x, int n){
        // return 0;
        if ( n == 0 ) {
            return 1;
        } 
        
        return x * power (x , n - 1);
    }
}


/*
input
2   //input
5   //output


output
32

Unlike the above method, this will take only log(n) complexity
Here log is log to the base 2

So for n = 1024, it will take only log(1024) = log(2^10) = 10

*/
class PowerLogarithmic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int x = scn.nextInt();
        int n = scn.nextInt();

        int pow = powerLog(x, n);
        System.out.println(pow);
    }

    public static int powerLog(int x, int n) {

        if ( n == 0 ) {
            return 1;
        }

        int xn2 = powerLog(x, n / 2);

        int xn = xn2 * xn2;

        if ( n % 2 == 1 ) {
            xn = xn * x;
        }

        return xn;
    }
}

class ZigZag {
    public static void pzz(int n) {
        if ( n == 0 ) {
            return;
        }

        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        pzz(n);
    }
}

class TowerOfHanoi {
    public static void toh(int n, int t1id, int t2id, int t3id) {

        if ( n == 0 ) {
            return;
        }

        //Will print the instructions to move n - 1 disks from t1 to t3 using t2 ( * )
        toh(n - 1, t1id, t3id, t2id);

        //After the above line, only one disk will be left in t1 ( which will be the nth disk )
        //We are moving it from t1 to t3
        System.out.println(n + "[" + t1id + " -> " + t2id + "]");

        //Will print the instruction to move n - 1 disks from t3 to t2 using t1 ( * )
        toh(n - 1, t3id, t2id, t1id);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int t1id = scn.nextInt();
        int t2id = scn.nextInt();
        int t3id = scn.nextInt();

        toh(n, t1id, t2id, t3id);
    }
}