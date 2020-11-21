import java.util.*;

class PrimeCheck {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = Integer.parseInt(scn.nextLine());

        for( int i = 1; i <= t; i++) {
            int n = Integer.parseInt(scn.nextLine());

            int count = 0;
            for (int j = 1; j <= n/2; j++) {
                if(n % j == 0)
                    count++;
            }

            if (count == 1) 
                System.out.println("prime");
            else 
                System.out.println("not prime");
        }

    }
}

// A more optimized solution
/*
For every number n, if we take the square root of n, there won't be any factors for n which are greater than the square root of n
that are unique.

for eg : 36, it's square root is 6. Now there aren't any unique factors for 36 > 6

1 X 36         36 X 1
2 X 18         18 X 2
3 X 12         12 X 3
4 X 9           9 X 4
        6 X 6   

Another eg : 24, it's square root is ~4.9. There aren't any unique factors > 5

1 X 24  24 X 1
2 X 12  12 X 2
3 X 8   8 X 3
4 X 6   6 X 4

For every factor p X q = n, either p or q will be less than square root of n.

So we can take the first condition, i.e, p < sqrt(n) => can also be written as p*p <= n
The reason we chose p is because it comprises of the first half of factors. And q is p repeated itself again anyways.

This is the condition that we use.

We can call p as div here, since it will be the divisor.

Now if we start div from 2, then at the end of the iteration, count will remain 0 for prime number.

In addition to this improved condition, we also add in a `break` statement to break out of the loop if atleast one item value of div 
will divide the number. That would verify it to be not prime anyways. There is no need for further iterations.
*/
class PrimeCheckOptimized {
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = Integer.parseInt(scn.nextLine());

        for( int i = 1; i <= t; i++) {
            int n = Integer.parseInt(scn.nextLine());

            int count = 0;
            
            for (int div = 2; div * div <= n; div++) {
                if(n % div == 0) {
                    count++;
                    break;
                }
            }

            if (count == 0) 
                System.out.println("prime");
            else 
                System.out.println("not prime");
        }

    }
}


//Primes within a range
class PrimeTillLimit {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();

        int n = low;

        while ( n <= high ) {
            int count = 0;
            for ( int div = 2; div * div <= n; div++ ) {
                if ( n % div == 0) {
                    count++;
                    break;
                }
            }

            if ( count == 0 ) {
                System.out.println(n);
            }
            n++;
        }
    }
}

class Fibonacci_N {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int limit = scn.nextInt();

        int prev = 0;
        int next = 1;
        for ( int i = 1; i <= limit; i++ ) {
            System.out.println(prev);
            int sum = prev + next;
            prev = next;
            next = sum;
        }
    }
}

class CountDigits {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();

        int d = 0;
        while(num > 0) {
            num = num/10;
            d++;
        }
        System.out.println(d);
    }
}

class PrintDigits {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
       
        int num = scn.nextInt();

        int pow = 1;
        int temp = num;

        while ( temp >= 10 ) {
            temp /= 10;
            pow *= 10;
        }

        temp = num;
        while ( pow != 0 ) {
            int digit = temp / pow;
            System.out.println(digit);

            temp = temp % pow;
            pow /= 10;
        }
        
    }
}

class ReverseNumber {
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int digit;
        int num = scn.nextInt();

        while ( num > 0 ) {
            digit = num % 10;
            System.out.println(digit);
            num = num/10;
        }

    }
}
/*
Sample input :
8 1 4 5 6 2 7 3    =>  are in positions  8 7 6 5 4 3 2 1 respectively.

Now 3 is in position 1, then 1 will come in the 3rd position of the output

///ly 1 is in position 7, so 7 will come in position 1

7 is in position 2, so 2 will come in position 7 and so on.

Sample output:
8 2 4 5 6 1 3 7
*/
class InverseNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();
        int position = 1;
        int temp = num;

        int result = 0;
        while ( temp > 0 ) {
            int digit = temp % 10;
            int pow = 1;
            for (int i = 1; i < digit; i++) {
                pow *= 10;
            }
            result += pow * position;
            position++;
            temp /= 10;
        }
        System.out.println(result);
    }
}

class RotateNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();
        int times = scn.nextInt();

        int count = 0;
        int temp = num;
        while ( temp > 0 ) {
            count ++;
            temp /= 10;
        }

        /* (no.of times to rotate % count of digits) will give a more opitmized rotation
         suppose number is 23412. Now count is 5. If we are to rotate 352 times, then by 350th rotation, the number will be the same.
         Now 2 more rotations needs to be performed. So we take 352 % 5 => 2 (which is the optimal number of rotations);
        */
        times = times % count;

        // if the no.of times to rotate is inputted as a negative number, then we rotate the number times + count times
        // eg: if times = -2 and count = 5, we rotate it 3 times
        // Since -2 implies rorate 2 digits to the left, it is equivalent as rotating 3 digits to the right
        if(times < 0)
            times += count;

        int divisor = (int) Math.pow(10, times);
        int multiplier = (int) Math.pow(10, (count - times));

        int remainder = num % divisor;
        num = num / divisor;

        int result = (remainder * multiplier) + num;

        System.out.println(result);
    }
}


class GCD_AND_LCM {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int a = scn.nextInt();
        int b = scn.nextInt();

        int smaller, greater, gcd = 1, lcm = 1;

        if ( a > b ) {
            smaller = b;
            greater = a;
        } else {
            smaller = a;
            greater = b;
        }

        for ( int i = greater;; i ++ ) {
            if ( i % a == 0 && i % b == 0) {
                lcm *= i;
                break;
            } 
        }

        for ( int i = smaller;; i--) {
            if ( a % i == 0 && b % i == 0 ) {
                gcd = i;
                break;
        }
    }

    System.out.println(gcd);
    System.out.println(lcm);

    }
}

class PrimeFactorization {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for (int i = 2; i <= n; i++) {
            if ( n % i == 0 ) {
                int count = 0;
                for ( int j = 2; j * j <= i; j++ ) {
                    if ( i % j == 0 ) {
                        count ++;
                    }
                }

                if ( count == 0 ) {
                    while ( n % i == 0 ) {
                        n = n/i;
                        System.out.print(i + "\t");
                    }
                }
            }
        }
        System.out.println();
    }
}


class PythagoreanTriplet {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();
        int hypotenuse, base, perpendicular;

        if ( a > b && a > c) {
            hypotenuse = a;
            base = c;
            perpendicular = b;
        } else 
            if ( b > c ) {
                hypotenuse = b;
                base = c;
                perpendicular = a;
            }
            else {
                hypotenuse = c;
                base = b;
                perpendicular = a;
            }
        

        int lhs = hypotenuse * hypotenuse;
        int rhs = base * base + perpendicular * perpendicular;

        if ( lhs == rhs ) 
            System.out.println(true);
        else 
            System.out.println(false);
        
    }
}

/*
Question
*********
1. You are given n number of bulbs. They are all switched off. 
A weird fluctuation in voltage hits the circuit n times. 
In the 1st fluctuation all bulbs are toggled, in the 2nd fluctuation every 2nd bulb is toggled, 
in the 3rd fluctuation every 3rd bulb is toggled and so on. You've to find which bulbs will be switched on after n fluctuations.
( like multiples of i will toggle each time)
2. Take as input a number n, representing the number of bulbs.
3. Print all the bulbs that will be on after the nth fluctuation in voltage.

Solution
********

Here, after n fuluctations are over, only the bulbs which are perfect square will be  still toggled on.
The reason being,
eg : take 6 as input

when i = 4, the multiples of 4 are

1 X 4   4 X 1
2 X 2   2 X 2

The multiples of 4 are : { 1, 2, 4}

when i = 6, the mutiples of 6 are

1 X 6   6 X 1
2 X 3   3 X 2

The multiples of 6 are {1,2,3,6}

Therefore, each perfect square numbered bulb will toggle an odd number of times and every other bulb will toggle an even number of times.
Since the default value of toggle is false, an odd set of toggles will only change the value of toggle to true. Even set of toggles will result in keeping it as false itself.

Therefore, we just need to print out the perfect squares within the range of 1 to n
*/

class BenjaminBulbs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for ( int i = 1; i * i <= n; i++ ) {
                System.out.println(i * i);
        }
    }
}