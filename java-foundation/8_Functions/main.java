import java.util.*;

class nPr {
    public static void display( int n, int r, int npr ) {
        System.out.println(n + "P" + r + " = " + npr);
    }

    public static int fact( int x ) {
        int factorial = 1;

        for ( int i = 1; i <= x; i ++ ) {
            factorial *= i;
        }

        return factorial;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int r = scn.nextInt();

        int nfact = fact(n);
        int nmrfact = fact(n-r);

        int npr = nfact / nmrfact;

        display(n, r, npr);
    }
}

class FrequencyOfDigit {
    public static void display(int count) {
        System.out.println(count);
    }

    public static int countDigits(int n, int digit) {
        int count = 0;

        while ( n > 0 ) {
            int d = n % 10;
            if ( d == digit ) {
                count ++;
            }
            n = n / 10;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int digit = scn.nextInt();

        int count = countDigits(n, digit);

        display(count);

    }
}
/*
Sample input
57
 2
 
Sample output
111001
*/
class DecimalToAnyBase {
    public static int convert( int n, int base ) {
        int convertedNumber = 0;
        int power = 0;
        while ( n > 0 ) {
            int digit = n % base;
            convertedNumber += digit * Math.pow(10, power);

            power ++;
            n /= base;
        }
        return convertedNumber;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int base = scn.nextInt();
        int convertedNumber = convert(n, base);
        

        System.out.println(convertedNumber);

    }
}

class AnyBaseToDecimal {
    public static int convert( int n, int b ) {
        int pow = 0;
        int convertedNumber = 0;
        while ( n > 0 ) {
            int digit = n % 10;
            convertedNumber += digit * Math.pow(b, pow);

            pow ++;
            n /= 10;
        }
        return convertedNumber;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int b = scn.nextInt();

        int convertedNumber = convert(n, b);
       

        System.out.println(convertedNumber);
    }
}

class AnyBaseToAnyBase {
    public static int convertAnyBaseToDecimal( int n, int b ) {
        int pow = 0;
        int convertedNumber = 0;
        while ( n > 0 ) {
            int digit = n % 10;
            convertedNumber += digit * Math.pow(b, pow);

            pow ++;
            n /= 10;
        }
        return convertedNumber;
    }
    public static int convertDecimalToAnyBase( int n, int base ) {
        int convertedNumber = 0;
        int power = 0;
        while ( n > 0 ) {
            int digit = n % base;
            convertedNumber += digit * Math.pow(10, power);

            power ++;
            n /= base;
        }
        return convertedNumber;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int b1 = scn.nextInt(); //Existing base
        int b2 = scn.nextInt(); //New base

        int convertedDecimal = convertAnyBaseToDecimal( n, b1);
        int convertedNumber = convertDecimalToAnyBase(convertedDecimal, b2);
        

        System.out.println(convertedNumber);
    }
}
/*
In base 8,

577 + 777 = 1576
*/
class AnyBaseAddition {
    public static int getSum(int b, int n1, int n2) {

        int carry = 0;
        int result = 0;
        int pow = 1;

        while ( n1 > 0 || n2 > 0 || carry > 0 ) {
            /*
            For each iteration, the last digits of both the numbers are taken,
            thier sum is found and normalized/capped to the base value. 
            The carry value is held on to the next iteration.
            In the last iteration where greater = 0, only carry value will be present. n1 & n2 would have become 0 by then.
            */
            int lastDigitOf_n1 = n1 % 10;
            int lastDigitOf_n2 = n2 % 10;

            int sumOfDigits = carry + lastDigitOf_n1 + lastDigitOf_n2;
          
            // Here sum is sumOfDigits capped by base value, i.e, remainder after dividing it by base 
            int sum = (sumOfDigits % b);  
            
            result += sum * pow;
            carry = sumOfDigits / b;

            n1 /= 10;
            n2 /= 10;
            pow *= 10;
        }

        return result;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        
        int sum = getSum(b, n1, n2);

        
        System.out.println(sum);
    }
}

class AnyBaseSubtraction {
    public static int getDifference(int b, int n1, int n2) {
        int subCarry = 0;
        int result = 0;
        int pow = 1;
        while ( n1 > 0 || n2 > 0 || subCarry > 0 ) {
            int digit1 = n1 % 10;
            int digit2 = n2 % 10;

            digit2 = digit2 - subCarry;

            if ( digit2 < digit1 ) {
                subCarry = 1;
                digit2 += b;
            } else {
                subCarry = 0;
            }

            int diff = digit2 - digit1;

            result += pow * diff;

            pow *= 10;
            n1 /=10;
            n2 /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int difference = getDifference(b, n1, n2);
        System.out.println(difference);
    }
}

class AnyBaseMultiplication {
    public static int getProductWithASingleDigit(int n1, int b, int digit2) {
        //holds the carry value for each multiplicaiton
        int multCarry = 0;
        int pow = 1;
        int multiplied = 0;

        //The second loop that goes through each digit of n1 to find a multiplied value for the corresponding digit of n2
        while ( n1 > 0 || multCarry > 0) {
            int digit1 = n1 % 10;

            int mult = digit1 * digit2 + multCarry;

            multCarry = mult / b;
            mult = mult % b;

            multiplied += mult * pow;

            n1 /= 10;
            pow *= 10;
        }
        return multiplied;
    }

    public static int getSum(int b, int firstNumber, int secondNumber) {
        int sumCarry = 0;
        int result = 0;
        int pow = 1;

        while ( firstNumber > 0 || secondNumber > 0 || sumCarry > 0) {
            int digit1 = secondNumber % 10;
            int digit2 = firstNumber % 10;

            int sum = sumCarry + digit1 + digit2;

            sumCarry = sum / b;
            sum = sum % b;

            result += sum * pow;

            pow *= 10;
            firstNumber /= 10;
            secondNumber /= 10;
        }
        return result;
    }

    public static int getProduct(int b, int n1, int n2) {
        int pow = 1;

        // Result hold the sums of each digit's multiplicated values in place.
        int result = 0;

        //The first loop n2, which will generate multiplied values for (each of its digit X n1) and sums it.
        while ( n2 > 0) {
            int d2 = n2 % 10;

            //singleProduct holds the multiplication results at each iteration of n2
            int singleProduct = getProductWithASingleDigit(n1, b, d2);

            int result = getSum(b, result, singleProduct * pow);
            
            n2 /= 10;
            pow *= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int product = getProduct(b, n1, n2);

        System.out.println(product);
    }
}