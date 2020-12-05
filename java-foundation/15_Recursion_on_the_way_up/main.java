import java.util.*;
import java.io.*;

/*
The difference between getting the resulsts into an array vs printing them directly is the reduced space complexity.
For getSubsequence as an array, it will take 2^(n - 1) * n space complexity
By printing it directly, we will reduce the complexity to (n + 1)n
*/


/*
input
yvTA

output
yvTA
yvT
yvA
yv
yTA
yT
yA
y
vTA
vT
vA
v
TA
T
A
*/
class PrintSubSequence {
     public static void main(String[] args) throws Exception {
         Scanner scn = new Scanner(System.in);

         String str = scn.next();
         printSS(str, "");
    }

    public static void printSS(String ques, String ans) {

        if ( ques.length() == 0 ) {
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        //Rest of the question
        String roq = ques.substring(1);

        printSS(roq, ans + ch);
        printSS(roq, ans + "");
    }

}

/*
input
78

output
tv
tw
tx
uv
uw
ux
*/
class PrintKPC {
     public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.next();
        printKPC(str, "");
    }

    static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void printKPC(String ques, String ans) {

        if ( ques.length() == 0 ) {
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        
        String code = codes[ch - '0'];

        for (int i = 0; i < code.length(); i ++ ) {
            printKPC(roq, ans + code.charAt(i));
        }
    }
}

/*
input
3

output
111
12
21
3
*/
class PrintStairPaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        printStairPaths(n, "");
    }

    public static void printStairPaths(int n, String path) {

        if ( n < 0 ) {
            return;
        }

        if ( n == 0 ) {
            System.out.println(path);
            return;
        }


        printStairPaths(n - 1, path + "1");
        printStairPaths(n - 2, path + "2");
        printStairPaths(n - 3, path + "3");
    }
}

/*
input
2
2

output
hv
vh
*/
class PrintMazePaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        printMazePaths(1, 1, n, m, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) { //psf = path so far

        if ( sc > dc || sr > dr ) {
            return;
        }

        if (sc == dc && sr == dr) {
            System.out.println(psf);
            return;
        }
        
        printMazePaths(sr, sc + 1, dr, dc, psf + "h");
        printMazePaths(sr + 1, sc, dr, dc, psf + "v");
    }
}


/*
input
3
3

output
h1h1v1v1
h1h1v2
h1v1h1v1
h1v1v1h1
h1v1d1
h1v2h1
h1d1v1
h2v1v1
h2v2
v1h1h1v1
v1h1v1h1
v1h1d1
v1h2v1
v1v1h1h1
v1v1h2
v1d1h1
v2h1h1
v2h2
d1h1v1
d1v1h1
d1d1
d2
*/

class PrintMazePathWithJump {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        printMazePaths(1, 1, n, m, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

        if (sc == dc && sr == dr) {
            System.out.println(psf);
            return;
        }
        
        for ( int h = 1; h <= dc - sc; h ++ ) {
            printMazePaths(sr, sc + h, dr, dc, psf + "h" + h);
        }

        for ( int v = 1; v <= dr - sr; v ++ ) {
            printMazePaths(sr + v, sc, dr, dc, psf + "v" + v);
        }

        for ( int d = 1; d <= dc - sc && d <= dr - sr; d ++ ) {
            printMazePaths(sr + d, sc + d, dr, dc, psf + "d" + d);
        }
    }
}

/*
input
abc

output
abc
acb
bac
bca
cab
cba
*/
class PrintPermutations {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.next();
        printPermutations(str, "");
    }

    public static void printPermutations(String ques, String ans) {

        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        
        for ( int i = 0; i < ques.length(); i ++ ) {
            char ch = ques.charAt(i);

            String qlpart = ques.substring(0, i);   //when i = 0, qlpart = ""
            String qrpart = ques.substring( i + 1 ); // when i = 0, qrpart = "bc"
            String ros = qlpart + qrpart;   // when i = 0, ros = "bc"

            printPermutations(ros, ans + ch);
        }
    }
}

/*
input
655196

output
feeaif
feesf
*/
class PrintEncodings_a {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.next();
        printEncodings(str, "");
    }

    static char[] alphabets = { 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' };
    public static void printEncodings(String ques, String ans) {
        
        if ( ques.length() == 0 ) {
            System.out.println(ans);
            return;
        }

        char ch1 = ques.charAt(0);

        /*
        eg: for 103, first we take 1 and then 10 and start the recursion,
        for 1, a will be added and then it will come across 0 and 03 and, since 0 came it will reuturn and print nothing
        for 10, j will be added and then it will call 3 again and add c to the ans => jc

        eg: for 303, first we take 3 and 30, call will only be there for 3,
        3 will be added to ans and call is again made
        it will come across 0 and will return without printing the ans.
        */
        if (ch1 == '0') return; //If the question starts with 0, then its invalid print nothing

        int n1 = ch1 - '0';

        char startChar1 = alphabets[n1 - 1];

        //Single digit
        String roq1 = ques.substring(1);
        printEncodings(roq1, ans + startChar1);

        //Only if more than one character exists in the question, do the second call
        //Double digits <= 26
        if ( ques.length() > 1 ) {
                char ch2 = ques.charAt(1);
                int n2 = n1 * 10 + ch2 - '0';
            if ( n2 <= 26 ) {
                char startChar2 = alphabets[n2 - 1];
                String roq2 = ques.substring(2);
                printEncodings(roq2, ans + startChar2);
            }
        }
        
    }
}

//Another method
class PrintEncodings_b {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        printEncodings(str, "");
    }

    public static void printEncodings(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        /*
        eg: for 103, first we take 1 and then 10 and start the recursion,
        for 1, a will be added and then it will come across 0 and 03 and, since 0 came it will reuturn and print nothing
        for 10, j will be added and then it will call 3 again and add c to the ans => jc

        eg: for 303, first we take 3 and 30, call will only be there for 3,
        3 will be added to ans and call is again made
        it will come across 0 and will return without printing the ans.
        */
        if (ques.charAt(0) == '0') { //If question start with 0, don't print anything and return
            return;
        }

        if (ques.length() == 1) { //If only one character exists, make just the first call

            String ch0 = ques.substring(0, 1);
            String roq0 = ques.substring(1);
            //First converting to character and then to string ( by adding a blank string in the end )
            String code0 = (char)('a' + (Integer.parseInt(ch0) - 1)) + "";
            printEncodings(roq0, ans + code0);

        } else { //If more than one character exists, make both the first call and second call

            String ch0 = ques.substring(0, 1);
            String roq0 = ques.substring(1);
            //The first code => single digit
            String code0 = (char)('a' + (Integer.parseInt(ch0) - 1)) + "";
            printEncodings(roq0, ans + code0);

            String ch01 = ques.substring(0, 2);
            String roq01 = ques.substring(2);
            //The second code => double digits
            String code01 = (char)('a' + (Integer.parseInt(ch01) - 1)) + "";

            if (Integer.parseInt(ch01) <= 26) {
                printEncodings(roq01, ans + code01);
            }
        }
    }
}
