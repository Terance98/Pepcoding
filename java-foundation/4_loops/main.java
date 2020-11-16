import java.util.*;

class Tutorial {
    public static void main(String[] args) {
        // int i = 1;

        // while(i <= 9) {
        //     System.out.println(i);
        //     i++;
        // }

        for (int i = 1; i <= 9; i++) {
            System.out.println(i);
        }
        System.out.println("Done!");
    }
}

class Exercise {
    public static void main(String[] args) {
        /*
        1. i returns the current value at memory location of i
        2. ++i increments the value at memory location and returns new value
        3. i++ increments the value at memory location and returns old value
        4. lhs == rhs is evaluated left to right
        */
        int i = 10;
        if(i++ == i) // i++ is use then change, so LHS evaluates to 10. Then 10 increments to 11. Now RHS is 11. Hence it evaluates to false.
        System.out.println(i + " is good");
        else
        System.out.println(i + " is bad");
    
        int j = 20;
        if(++j == j) // ++j is change then use. So LHS evaluates to 21. Then RHS is also already 21. So it evaluates to true
        System.out.println(j + " is good");
        else
        System.out.println(j + " is bad");
        }
}