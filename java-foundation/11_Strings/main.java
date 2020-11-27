/*
Strings
*******

String s1 = "hello";
String s2 = "hello";
String s3 = new String("hello");

Now there is an area in the heap called Intern pool where these strings get stored.
A unique string gets stored only once.

Suppose hello is stored in the Intern Pool and has a base address 4k.

Now s1 & s2 will point to the same address 4k in the stack. This phenomenon is called as interning.

Interning : If a string already exists in the Intern Pool, during a new assignment of the same string to a new variable, the existing
string in the intern pool will get reused again, i.e, the new varaible s2 will also point to the base address of the same string in the Intern Pool. 
This is called as interning.
A benefit of interning is that - it saves space.

Using the "new String()" method will prevent interning. Here in the case of s3, a new "hello" is formed in the intern pool at a different
base address and s3 will point to this new base address.

What happens inside intern pool?
    The base addresses actually point to a shell. The shell in turn points to the actual character array of the string which is stored in
    the heap. Here s1,s2 points to the shell 4k and s3 points to the shell 5k. And both theses shells points to the same character array
    containing "hello".

String comparisions :
    For string comparisons we use .equals() method.
    == will just do the address comparison and not the actual content of the string.

    eg: s1 == s2  //true
        s1 == s3 //false
    
    but,
        s1.equals(s2) //true
        s1.eauals(s3) //true

String Immutability :
    String reference is mutable but the instance is immutable.

    String s1 = "hello";    
    String s2 = "hello"; //now both s1 and s2 points to "hello" in the intern pool

    s1 = "bye" // Now "bye" is created in the intern pool with a different base address and s1 will point to that 

    Strings are made immutable in java because if s1 & s2 are pointing to the same string in the intern pool and if we mutate the string
    s1, then the changes will also reflect in s2 ( which is not the intented behaviour ). Hence string mutability is prevented in Java.

    Preformance Issues :
        The immutable nature of strings actually has serious performance issues in Java.

        Suppose String s1 = "hello";
        s1 += "e";

        Now what happes is that a new string is formed by appending "hello" and "e" => "helloe".
        This new string will be stored again in the intern pool at a different base address. 
        This new base address is then mapped to the s1 variable.
        It will take O(n) complexity for n characters to be copied to the new address space and 0(1) complexity to 
        copy appending string "e". Hence total complexity will be O(n + 1) ~ O(n)

        Suppose we do,

        for ( int i = 0; i < n; i ++ ) {
            s1 += i;
        }

        You may suppose that it has O(n) complexity, but it actually has O(n^2) complexity.
        At each iteration, a new string is stored into a new address space and mapped back to s1.
        And that takes n + 1 complexity for iteration.

        So tatal compexity will be n(n + 1) / 2 ~ O(n^2). 

        Inorder to overcome this limitation, we will use String Builder.
*/

import java.util.*;
import java.io.*;

/*
input
abcc

output
a
b
c
cc
c
*/
class PalindromicSubstrings {
    public static boolean isPalindrome(String subs) {
        int li = 0;
        int ri = subs.length() - 1;

        while ( li < ri ) {
            char ch1 = subs.charAt(li);
            char ch2 = subs.charAt(ri);

            if ( ch1 != ch2 ) {
                return false;
            }

            li ++;
            ri --;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String s = scn.nextLine();

        for ( int i = 0; i < s.length(); i ++ ) {
            for ( int j = i + 1; j <= s.length(); j ++ ) {
                String subs = s.substring(i,j);

                if (isPalindrome(subs)) {
                    System.out.println(subs);
                }
            }
        }
    }
}

/*
input
wwwwaaadexxxxxx

output
wadex       //first compression
w4a3dex6    //second compression

If count > 1 only then display it, else not.
*/
class StringCompression {
    public static String firstCompression(String s) {
        String str = "" + s.charAt(0);

        for ( int i = 1; i < s.length(); i ++ ) {

            int curr = s.charAt(i);
            int prev = s.charAt(i - 1);

            if ( curr != prev ) {
                str += curr;    //Append curr if it is found not wqual to prev
            }
        }

        return str;
    }

    public static String secondCompression(String s) {
        int count = 1;
        String str = "" + s.charAt(0);

        for ( int i = 1; i < s.length(); i ++ ) {

            int curr =  s.charAt(i);
            int prev = s.charAt(i - 1);

            if ( prev == curr ) {
                count ++;
            } else {
                if ( count > 1 ) {
                    str += count; //append the count if count > 1
                    count = 1;
                }
                str += curr;    //append the current element
            }

        }

        if ( count > 1 ) {  //At the end of the iteration, count will contain the count of the last element
            str += count;
            count = 1;
        }

        return str;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String s = scn.nextLine();

        System.out.println(firstCompression(s));
        System.out.println(secondCompression(s));
    }
}

/*
String Builder

It removes the limitations of String, it will allow to update, insert, delete characters in an existing string

Commonly used string builder functions are :

s.charAt(0)          // get
s.setCharAt(0, 'd')  //update
s.insert(1, 1000)    //insertion
s.deleteCharAt(2)    //deletion
s.append('g')        //append to the end

*/
class StringBuilderTutorial {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello");

        System.out.println(sb);

        char ch = sb.charAt(0); //get
        System.out.println(ch);

        sb.setCharAt(0, 'd'); //update
        System.out.println(sb);

        sb.insert(2, 'y'); //insert
        System.out.println(sb);

        sb.deleteCharAt(2); //delete
        System.out.println(sb);

        sb.append('g'); //append
        System.out.println(sb);

        System.out.println(sb.length());


        //String vs String Builder performance

        int n = 100000;

        long start = System.currentTimeMillis();

        //String method : Took 2396 milliseconds
        // String s = "";

        // for ( int i = 0; i < n; i ++ ) {
        //     s += i;
        // }


        // String Builder method : Took 8 milliseconds
        StringBuilder s = new StringBuilder();

        for ( int i = 0; i < n; i ++ ) {
            s.append(i);
        }
        
        long end = System.currentTimeMillis();

        long duration = end - start;
        System.out.println(duration);
    }
}

/*
input
pepCODinG

output
PEPcodINg

p - a = P - A      //The distance between small p and a is same as the distance between P and A

Therefore, p = a + P - A
or, lower_case = a + upper_case - A

Similarly, P = A + p - a
or upper_case = A + lower_case - a

Equations :
    lower_case = a + upper_case - A
    upper_case = A + lower_case - a
*/
class ToggleCase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        StringBuilder s = new StringBuilder(scn.nextLine());
    
        for ( int i = 0; i < s.length(); i ++ ) {
            int ch = s.charAt(i);

            if ( ch >= 'A' && ch <= 'Z' ) {   //uppercase to lowercase
                int lowerCase = 'a' + ch - 'A';
                char lowerCaseEqvl = (char) lowerCase;
                s.setCharAt(i, lowerCaseEqvl);
            } else if ( ch >= 'a' && ch <= 'z') {  //lowercase to uppercase
                int upperCase = 'A' + ch - 'a';
                char upperCaseEqvl = (char) upperCase;
                s.setCharAt(i, upperCaseEqvl);
            }
        }
        System.out.println(s);
    }
}

/*
input
abgcpq

output
a1b5g-4c13p1q
*/
class StringAsciiDifference {
    public static String solution(String s){

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        for ( int i = 1; i < s.length(); i ++ ) {
            char curr = s.charAt(i);
            char prev = s.charAt(i - 1);
            
            int gap = curr - prev;
            
            sb.append(gap);
            sb.append(curr);
        }
        
        return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}
}

/*
input
abc

output
abc
bac
cab
acb
bca
cba
*/
class PermuatationsOfAString {
    public static int fact(int n) {
        int factorial = 1;

        for ( int i = 2; i <= n; i ++ ) {
            factorial *= i;
        }
        
        return factorial;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String s = scn.nextLine();

        int n = s.length();
        int nPermutations = fact(n);    //no.of permutations of n = factiorial(n)

        for ( int i = 0; i < nPermutations; i ++ ) {
            //for each i, divide it by length and use the character at remainder index
            //a0 b1 c2 are the indexes here since there are 3 characters only in the string
            //After dividing the character at remainder index is deleted
            //Then the length is reduced by 1. (since there will be only n-1 characters left after removal)
            int tempi = i;
            StringBuilder sb = new StringBuilder(s);

            for ( int div = n; div > 0; div -- ) {
                //get the remainder of i / length.
                int idx = tempi % div;

                //Use the remainder as index to get the character. Print each character in sequence
                System.out.print(sb.charAt(idx));

                //Remove the character from the main string once used. This will normalize the indexes of the rest of the characters
                //eg: abc => a0 b1 c2
                //deleteCharAt(1) => a0 c1
                sb.deleteCharAt(idx);

                //Divide i by the length of the string
                tempi /= div;
            }
            System.out.println();
        }
    }
}

/*
Array Lists : commonly used methods :

list.add(10);           //appending
list.add(1, 10000);     //insertion
list.set(1, 2000);      //updation
list.remove(1);         //deletion 
list.get(1);            //reading
list.size();            //length of array list

*/
class ArrayListTutorial {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        //lists can be print directly unlike arrays
        System.out.println(list + " -> " + list.size());

        list.add(10);   //similar to append
        list.add(20);
        list.add(30);

        System.out.println(list + " -> " + list.size());

        list.add(1, 1000); //insert at a particular index
        System.out.println(list + " -> " + list.size());

        int val = list.get(1);  //read
        System.out.println(val);

        list.set(1, 2000); //update
        System.out.println(list + " -> " + list.size());

        list.remove(1);
        System.out.println(list + " -> " + list.size());

        ArrayList<String> l2 = new ArrayList<>();

        l2.add("hello");
        l2.add("bello");
        l2.add("sello");

        System.out.println(l2 + " -> " + list.size());


        for ( int i = 0; i < list.size(); i ++ ) {
            int val1 = list.get(i);
            System.out.println(val1);
        }

        //Another looping method (also works with normal arrays)
        for (int val1 : list) {
            System.out.println(val1);
        }
    }
}
/*
input
4
3 12 13 15

output
[12, 15]
*/
class RemovePrimes {
    public static Boolean isPrime(int num) {
        for ( int j = 2; j * j <= num; j ++ ) {
            if ( num % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for ( int i = 0; i < n; i ++ ) {
            arr.add(scn.nextInt());
        }

        /*
        Here we iterate loop from the end to start index
        Because, if we are moving from 0 -> n, suppose we remove an item, then the element to the right of it shifts to its poisition
        But i will get incremeneted in the next iteration, so this element will be missed.
        eg : 2 13 17 19 22

        Here if we iterate from start, when i = 1, it will remove 13, now i ++ and i becomes 2.
        Now 17 would have shifted to index 1 and 17 will get missed.

        So to prevent that we will iterate from end -> start

        Here, when i = 3, we remove the element, now 22 will shift from right to this position.
        Now now the array list becomes 2 13 17 22
        Now i is decremeneted to 2, and will check 17 ( which is intented).
        arr -> [2, 13, 22]
        i beomces 1
        arr -> [2 ,22]

        Therefore by iterating the array list in the reverse order, we were able to mitigate this index jump issue.
        */
        for ( int i = arr.size() - 1; i >= 0; i -- ) {
            int num = arr.get(i);

            if (isPrime(num)) {
                arr.remove(i);
            }
        }
        System.out.println(arr);
    }
}