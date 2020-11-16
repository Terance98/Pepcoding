import java.util.*;

class Tutorial {
    public static void main(String[] args) {
        int x = 11;

        if ( x % 2 == 0 ) {
            System.out.println(x + " is even.");
        } else {
            System.out.println(x + " is odd.");
        }

        System.out.println("Hardwork is better than smart work!\n\n");

        int n1 = 10;
        int n2 = 20;

        if ( n1 == n2 ) {
            System.out.println(n1 + " is equal to " + n2);
        } else if ( n1 > n2 ) {
            System.out.println(n1 + " is greater than " + n2);
        } else {
            System.out.println(n1 + " is smaller than " + n2);
        }

    }
}

class Exercise {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        if ( (x % 2 == 0) && (y % 2 == 0) ) {
            System.out.println(x + " and " + y + " are even numbers.");
        } else {
            System.out.println("Both are not even numbers");
        }
    }
}

class Exercise2 {
    public static void main(String[] args) {
        int marks = 93;

        if ( marks > 90 ) {
            System.out.println("Excellent");
        } else if ( marks > 80 && marks <= 90 ) {
            System.out.println("Good");
        } else if ( marks > 70 && marks <= 80 ) {
            System.out.println("Fair");
        } else if ( marks > 60 && marks <= 70 ) {
            System.out.println("Meets expectations");
        } else {
            System.out.println("Below par");
        }
    }
}