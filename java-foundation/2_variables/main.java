import java.util.*;

class ArithmeticOperations {
    public static void main(String[] args) {
        int x = 15;
        int y = 10;
        //Sum
        int sum = x + y;
        System.out.println("Sum of "+ x + " and " + y +" is "+ sum);

        //Product
        int product = x * y;
        System.out.println("Product of "+ x + " and "+ y + " is "+ product);

        int v1 = x / y;
        int v2 = y / x;
        int v3 = x % y;

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        // [*, % , /] > [+, -]  (Doesn't follow BODMAS rule)
        int wrongExp = x * y / x + y;  // => 10 * 15 / 15 + 10 => 150/15 + 10 => 10 + 10 => 20
        int rightExp = (x * y) / (x + y);

        System.out.println(wrongExp);
        System.out.println(rightExp);

    }
}

class Exercise {
    public static void main(String[] args) {
        double x = Math.pow(2,3);
        int y = (int) Math.pow(2,3);

        System.out.println("X : " + x + " and Y : " + y);
    }
}