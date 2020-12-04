import java.io.*;
import java.util.*;

/*
Subsequence is equivalent to the subset of an array.
A string has 2^n subsequence or subsets. 

A string has n(n+1) / 2 substrings.

if n = 0, it will have one subsequnce which will be the empty string.

input
abc

output
[, c, b, bc, a, ac, ab, abc]
*/
class SubSequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();

        ArrayList<String> res = gss(str);
        System.out.println(res);

    }

    /*
    Expectation : bc -> [--, -c, b-, bc]
    Faith : abc -> [a--, a-c, ab-, abc, ---, --c, -b-, -bc]
    */
    public static ArrayList<String> gss(String str) {

        if (str.length() == 0) {
            //Base result
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0); //a
        String ros = str.substring(1); //bc

        //recursion result
        ArrayList<String> rres = gss(ros); //[--, -c, b-, bc]

        //My result
        ArrayList<String> mres = new ArrayList<>();

        for (String rstr : rres) {
            mres.add("" + rstr);
        }
        
        for (String rstr : rres) {
            mres.add(ch + rstr);
        }

        return mres;
    }
}

/*
input
678

output
[ptv, ptw, ptx, puv, puw, pux, qtv, qtw, qtx, quv, quw, qux, rtv, rtw, rtx, ruv, ruw, rux, stv, stw, stx, suv, suw, sux]
*/
class GetKPC {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();

        ArrayList<String> words = getKPC(str);
        System.out.println(words);
    }

    static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };
    public static ArrayList<String> getKPC(String str) {

        if ( str.length() == 0 ) {
            //Basic result
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        // 678
        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rres = getKPC(ros); // 6 words of 78
        ArrayList<String> mres = new ArrayList<>();  //24 words for 678

        // When indexing with character, its ASCII value will be used here.
        // The ASCII value of '0' is 48. Therefore subracting '0' from ch will give the actual index
        // eg : '6' ASCII -> 54. 54 - 48 = 6 which is the required index value.
        String codeForCh = codes[ch - '0']; //for ch = 6, it will give pqrs
        for ( int i = 0; i < codeForCh.length(); i ++ ) {
            char chcode = codeForCh.charAt(i);

            for ( String rstr : rres ) {
                mres.add(chcode + rstr);
            }
        }
        return mres;
    }
}

/*
input
3

output
[111, 12, 21, 3]
*/
class GetStairPaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);
    }

    public static ArrayList<String> getStairPaths(int n) {
        
        /*
        At a time maximum number of steps a person can take is 3.
        The minimum no.of steps a person can take is 1. There fore, at each stage of recursion,
        we will recurse over n-1, n-2 & n-3

        There are two base conditions, 0 is the positive base condition and negatives are the wroong path base condition.
        If a path ends at 0,then we can say that the path is a feasible path. Here we will return an array with an empty string.
        It is equivalent to staying at the same step 0

        If a path ends at -1, -2 etc.. we have to say that it is not a feasible path. Here we will return an empty array with no values 
        at all. It signifies that once we are below the ending point 0, there is no way that we can climb back. Returning an empty
        array will mark that part as invalid because, its further sequences will not be formed.
        */

        if ( n == 0 ) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        } else if ( n < 0 ) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }

        ArrayList<String> paths1 = getStairPaths(n - 1);
        ArrayList<String> paths2 = getStairPaths(n - 2);
        ArrayList<String> paths3 = getStairPaths(n - 3);

        ArrayList<String> paths = new ArrayList<>();

        for ( String path: paths1 ) {
            paths.add(1 + path);
        }

        for ( String path: paths2 ) {
            paths.add(2 + path);
        }

        for ( String path: paths3 ) {
            paths.add(3 + path);
        }

        return paths;
    }

}

/*
input
3
3

output
[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
*/
class MazePath {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList<String> paths = getMazePaths(1, 1, n, m);
        System.out.println(paths);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        //each tiem move both in the horizontal direction and vertical direction one step at a time.
        //the base condition is when we reach dr or dc

        if ( sr == dr && sc == dc ) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> horizontalPaths = new ArrayList<>();
        ArrayList<String> verticalPaths = new ArrayList<>();

        if ( sc < dc ) {
            horizontalPaths = getMazePaths(sr, sc + 1, dr, dc);
        }

        if ( sr < dr ) {
            verticalPaths = getMazePaths(sr + 1, sc, dr, dc);
        }

        ArrayList<String> paths = new ArrayList<>();

        for ( String path : horizontalPaths ) {
            paths.add('h' + path);
        }

        for ( String path : verticalPaths ) {
            paths.add('v' + path);
        }

        return paths;
    }
}

/*
input
2
2

output
[h1v1, v1h1, d1]
*/
class JumpMazePath {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList<String> paths = getMazePaths(1, 1, n, m);
        System.out.println(paths);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if ( sr == dr && sc == dc ) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        //each iteration, do horizontal jump, vertical jump and diagonal jump
        ArrayList<String> paths = new ArrayList<>();

        if ( sc < dc ) {
            for ( int i = 1; i <= dc - sc; i ++ ) {
                ArrayList<String> horizontalPaths = getMazePaths(sr, sc + i, dr, dc);
                for ( String path: horizontalPaths ) {
                    paths.add("h" + i + path);
                }
            }
        }

        if ( sr < dr ) {
            for ( int i = 1; i <= dr - sr; i ++ ) {
                ArrayList<String> verticalPaths = getMazePaths(sr + i, sc, dr, dc);
                for ( String path: verticalPaths ) {
                    paths.add("v" + i + path);
                }
            }
        }

        if ( sr < dr && sc < dc ) {
            for ( int i = 1; i <= dc - sc  && i <= dr - sr; i ++ ) {
                ArrayList<String> diagonalPaths = getMazePaths(sr + i, sc + i, dr, dc);
                for ( String path: diagonalPaths ) {
                    paths.add("d" + i +  path);
                }
            }
        }

        return paths;
    }
}