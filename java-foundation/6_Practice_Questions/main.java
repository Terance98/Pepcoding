import java.util.*;

class Solution_1 {
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
To elaborate, for 1 till n/2 , p will be less than square root of n
From n/2 till n, q will be less than square root of n.

So we can take the first condition, i.e, p < sqrt(n) => can also be written as p*p <= n

This is the condition that we use.

We can call p as div here, since it will be the divisor.

Now if we start div from 2, then at the end of the iteration, count will remain 0 for prime number.

In addition to this improved condition, we also add in a `break` statement to break out of the loop if atleast one item value of div 
will divide the number. That would verify it to be not prime anyways. There is no need for further iterations.
*/
class Solution_2 {
     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = Integer.parseInt(scn.nextLine());

        for( int i = 1; i <= t; i++) {
            int n = Integer.parseInt(scn.nextLine());

            int count = 0;
            
            for (int div = 2; div * div <=n; div++) {
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
