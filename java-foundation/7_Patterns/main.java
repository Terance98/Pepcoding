import java.util.*;
/*
* 
* * 
* * * 
* * * * 
* * * * * 
* * * * * * 
*/
class Pattern1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j <= i; j++ ) {
                System.out.print("*\t");
            }
            System.out.print("\n");
        }
    }
}

/*
*       *       *       *       *
*       *       *       *
*       *       *
*       *
*
*/
class Pattern2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for ( int i = n; i > 0; i -- ) {
            for ( int j = i; j > 0; j --) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
}

/*
				*	
			*	*	
		*	*	*	
	*	*	*	*	
*	*	*	*	*	
*/
class Pattern3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n - i - 1; j++) {
                System.out.print("\t");
            }

            for ( int k = 0; k <= i; k++ ) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
}

/*
*	*	*	*	*	
	*	*	*	*	
		*	*	*	
			*	*	
				*
*/
class Pattern4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < i; j++) {
                System.out.print("\t");
            }

            for ( int k = 0; k < n - i; k++ ) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
}

/*
		*	
	*	*	*	
*	*	*	*	*	
	*	*	*	
		*	
*/
class Pattern5 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int nspaces = n / 2;
        int nstars = 1;
        for ( int i = 0; i < n; i++ ) {

            for ( int j = 0; j < nspaces; j ++ ) {
                System.out.print("\t");
            } 

            for ( int k = 0; k < nstars; k ++ ) {
                System.out.print("*\t");
            }

            if (i < n / 2) {
                nspaces --;
                nstars += 2;
            } else {
                nspaces ++;
                nstars -= 2;
            }
            System.out.println();
        }
    }
}

/*
*	*	*		*	*	*	
*	*				*	*	
*						*	
*	*				*	*	
*	*	*		*	*	*	
*/
class Pattern6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int nstars = (n/2) + 1;
        int nspaces = 1;
        for ( int i = 0; i < n; i ++ ) {

            for ( int j = 0; j < nstars; j ++ ) {
                System.out.print("*\t");
            }

            for ( int k = 0; k < nspaces; k ++ ) {
                System.out.print("\t");
            }

            for ( int l = 0; l < nstars; l ++ ) {
                System.out.print("*\t");
            }

            if (i < n/2) {
                nspaces += 2;
                nstars --;
            } else {
                nspaces -= 2;
                nstars ++;
            }

            System.out.println();
        }
    }
}

/*
*	
	*	
		*	
			*	
				*	
*/
class Pattern7 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for ( int i = 1; i <= n; i ++ ) {
            for ( int j = 1; j <= n; j ++) {
                if ( i == j ) 
                    System.out.print("*\t");
                else 
                    System.out.print("\t");
            }
            System.out.println();
        }
    }
}


/*
				*	
			*		
		*			
	*				
*
*/
class Pattern8 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for ( int i = 1; i <= n ; i ++ ) {
             for ( int j = 1; j <= n; j++ ) {
                 if ( i + j == n + 1 ) {
                     System.out.print("*\t");
                 } else {
                     System.out.print("\t");
                 }
             }
             System.out.println();
        }
    }
}

/*
*				*	
	*		*		
		*			
	*		*		
*				*	
*/
class Pattern9 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for ( int i = 1; i <= n; i ++ ) {
            for ( int j = 1; j <= n; j ++ ) {
                if (i + j == n + 1 || i == j ) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
         }
    }
}

/*
		*	
	*		*	
*				*	
	*		*	
		*	
*/
class Pattern10a {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int match1 = n / 2;
        int match2 = n / 2;

        for ( int i = 1; i <= n; i ++ ) {
            // System.out.println(match1 + ", " + match2);
            for ( int j = 0; j <= n; j ++ ) {
                if ( j == match1 || j == match2 ) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }

            if ( i <= n/2 ) {
                match1 --;
                match2 ++;
            } else {
                match1 ++;
                match2 --;
            }

            System.out.println();
        }
    }
}

//Another solution 
class Pattern10b {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int nspaces = n / 2;
        int nstars = 1;
        for ( int i = 1; i <= n; i ++ ) {
            for ( int j = 1; j <= nspaces; j ++ ) {
                System.out.print("\t");
            }

            for ( int j = 1; j <= nstars; j ++ ) {
                if ( j > 1 && j < nstars ) {
                    System.out.print("\t");
                } else {
                    System.out.print("*\t");
                }
            }

            System.out.println();
            if ( i <= n / 2 ) {
                nspaces --;
                nstars += 2;
            } else {
                nspaces ++;
                nstars -= 2;
            }
        }
    }

}

/*
1	
2	3	
4	5	6	
7	8	9	10	
11	12	13	14	15
*/
class Pattern11 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int k = 1;

        for ( int i = 1; i <= n; i ++ ) {
            for ( int j = 1; j <= i; j ++) {
                System.out.print(k++ + "\t");
            }
        System.out.println();
        }
    }
}

/*
0	
1	1	
2	3	5	
8	13	21	34	
55	89	144	233	377
*/
class Pattern12 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int prev = 0;
        int next = 1;

        for ( int i = 1; i <=n; i++ ) {
            for ( int j = 1; j <= i; j ++ ) {
                System.out.print(prev + "\t");
                int sum = prev + next ;
                prev = next;
                next = sum;
            }
            System.out.println();
        }
    }
}

/*
1	
1	1	
1	2	1	
1	3	3	1	
1	4	6	4	1	
1   5   10  10  5   1

The above patter follows the nCk combination rule. => nCk = n!/(n-k)! * k!
Take 6th row, n = 5, 
5C0 = 1 = 5C5
5C1 = 5 = 5C4
5C2 = 10 = 5C3

Another equation to calculate the next combination value is :
iC(j+1) = (iCj * (i - j)) / (j + 1)
*/
class Pattern13 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for ( int i = 0; i < n; i++ ) {
            int iCj = 1;
            for ( int j = 0; j <= i; j ++ ) {
                System.out.print(iCj + "\t");
                int iCjPlus1 = iCj * ( i - j ) / ( j + 1 );
                iCj = iCjPlus1;
            }
            System.out.println();
        }
    }
}

/*
4 * 1 = 4
4 * 2 = 8
4 * 3 = 12
4 * 4 = 16
4 * 5 = 20
4 * 6 = 24
4 * 7 = 28
4 * 8 = 32
4 * 9 = 36
4 * 10 = 40
*/
class Pattern14 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for ( int i = 1; i <= 10; i ++ ) {
            System.out.println( n + " * " + i + " = " + n * i );
        }
    }
}

/*
		1	
	2	3	2	
3	4	5	4	3	
	2	3	2	
		1	
*/
class Pattern15 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int stars = 1;
        int spaces = n / 2;
        
        int startVal = 1;
        for ( int i = 1; i <= n; i ++ ) {
            int val = startVal;

            for ( int j = 1; j <= spaces; j ++ ) {
                System.out.print("\t");
            }

            for ( int j = 1; j <= stars; j ++ ) {
                System.out.print(val + "\t");

                if ( j <= stars / 2 ) {
                    val ++;
                } else {
                    val --;
                }
            }

            System.out.println();

            if ( i <= n / 2 ) {
                stars += 2;
                spaces --;
                startVal ++;
            } else {
                stars -= 2;
                spaces ++;
                startVal --;
            }
        }
    }
}

/*
1												1	
1	2										2	1	
1	2	3								3	2	1	
1	2	3	4						4	3	2	1	
1	2	3	4	5				5	4	3	2	1	
1	2	3	4	5	6		6	5	4	3	2	1	
1	2	3	4	5	6	7	6	5	4	3	2	1	
*/
class Pattern16 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int nspaces = 2 * n - 3;
        int nstars = 1;
        for ( int i = 1; i <= n; i ++ ) {
            
            int val = 1;

            for ( int j = 0; j < nstars; j ++ ) {
                System.out.print(val++ + "\t");
            }

            for ( int j = 0; j < nspaces; j ++ ) {
                System.out.print("\t");
            }
            
            if ( i == n) {
                nstars --;
                val --;
            }

            for ( int j = 0; j < nstars; j ++ ) {
                System.out.print(--val + "\t");
           }

            System.out.println();

            nstars ++ ;
            nspaces -= 2;
        }
    }
}

/*
		*	
		*	*	
*	*	*	*	*	
		*	*	
		*	
*/
class Pattern17 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int nstars = 1;
        int nspaces = n / 2;
        for ( int i = 1; i <= n; i ++ ) {
            if ( i == n / 2 + 1 ) {
                // print stars in place of spaces
                for ( int j = 0; j < nspaces; j ++ ) {
                    System.out.print("*\t");
                }
            } else {
                // print spaces instead
                for ( int j = 0; j < nspaces; j ++ ) {
                    System.out.print("\t");
                }
            }

            for ( int j = 0; j < nstars; j ++ ) {
                System.out.print("*\t");
            }

            if ( i <= n / 2 ) {
                nstars ++;
            } else {
                nstars --;
            }
            System.out.println();
        }
    }
}

/*
*	*	*	*	*	*	*	
	*				*	
		*		*	
			*	
		*	*	*	
	*	*	*	*	*	
*	*	*	*	*	*	*	
*/
// Method 1
class Pattern18a {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for ( int i = 1; i <= n; i ++ ) {
            for ( int j = 1; j <= n; j ++ ) {
                if ( i == 1 ) {
                    System.out.print("*\t");
                    continue;
                }
                
                if ( i <= n / 2) {
                    if ( (j == i) || (i + j == n + 1 )) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else {
                    if ( ( (i + j) >= n + 1 ) && j <= i) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println();
        }
    }
}

// Method 2
class Pattern18b {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int nspaces = 0;
        int nstars = n;

        for ( int i = 1; i <= n; i ++ ) {
            //First print the spaces
            for ( int j = 1; j <= nspaces; j ++ ) {
                System.out.print("\t");
            }

            //First form an hour glass structure and then filter and print all the stars that follow  the condition.
            for ( int j = 1; j <= nstars; j ++ ) {
                if ( i > 1 && i <= n / 2 && j > 1 && j < nstars) {
                    System.out.print("\t");
                } else {
                    System.out.print("*\t");
                }
            }

            if ( i <= n / 2 ) {
                nspaces ++;
                nstars -= 2;
            } else {
                nspaces --;
                nstars += 2;
            }
            System.out.println();
        }
    }
}

/*
for n = 5,
*   *   *       *
        *       *
*   *   *   *   *
*       *
*       *   *   *
*/
class Pattern19a {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int mid = n / 2 + 1;
        for ( int i = 1; i <= n; i ++ ) {
            for ( int j = 1; j <= n; j ++ ) {

                if ( 
                (j == mid || i == mid) || //prints the + format
                ( i < mid && i == 1 && j < mid) || // prints the top left area
                (i < mid && j == n) || // prints the top right area
                ( i > mid && i == n && j > mid) ||  // prints the bottom right area
                ( i > mid && j == 1) // prints the bottom left area
                ) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}

//Another solution 
class Pattern19b {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int mid = n / 2 + 1;

        /*
        We check 4 conditions here,
        i = 1, check [ j == n || j <= mid ]
        i < mid, check [ j == mid || j == n]
        i == mid, print all 
        i > mid , check [ j == 1 || j == mid]
        i = n, check [ j = 1 || j >= mid ]
        */

        for ( int i = 1; i <= n; i ++ ) {
            for (int j = 1; j <= n; j ++ ) {
                if ( i == 1 ) {
                    if ( j == n || j <= mid ) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else if ( i < mid ) {
                    if ( j == mid || j == n ) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else if ( i == mid ) {
                    System.out.print("*\t");
                } else if ( i < n ) {  // similar to i > mid && i != n
                    if ( j == mid || j == 1 ) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else {
                    if ( j == 1 || j >= mid ) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println();
        }
    }
}

/*
*				*	
*				*	
*		*		*	
*	*		*	*	
*				*	
*/
class Pattern20 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int centre = n / 2 ;
      
        for ( int i = 1; i <= n; i ++ ) {
            for ( int j = 1; j <= n; j ++ ) {

                if ( i <= centre || i == n ) {
                    if ( j == 1 || j == n) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else {
                    if ( j == i || ( i + j ) == n + 1 || j == 1 || j == n ) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println();
        }
    }
}