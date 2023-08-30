/* passed test cases
r,r,r,r
d,d,d,d
l,l,l,l
r
l
d
u
f
b
f,r,u,b,l
*/ 

// time complexity:o(n);
// space complexity:o(1);
// (for returning ans array is used!)

import java.util.Scanner;

//make pos to store (x,y,z)
class Pos {
    int x;//X coordinate
    int y;//Y coordinate
    int z;//Z coordinate

    Pos(int i, int j, int k) {
        x = i;
        y = j;
        z = k;
    }

}

class chandrayanCommands {
    static int[] findDirectionAndPosition(char input[], int n, int d, int[] direction,int m,int t,int o) {

        Pos start = new Pos(m, t, o);

        // iterating over input array
        for (int i = 0; i < n; i++) {
            char c = input[i];

            /*  if we have f,we simply update coordinate based on current direction,and there
             is no need to change direction*/
            if (c == 'f') {
                if (d == 0) {
                    start.y++;
                } else if (d == 1) {
                    start.x++;
                } else if (d == 2) {
                    start.y++;
                } else if (d == 3) {
                    start.x--;
                } else if (d == 4) {
                    start.z++;
                } else if (d == 5) {
                    start.z--;
                }

            }

            /* if we have b,we simply update coordinate based on current direction,and there
             is no need to change direction*/
            else if (c == 'b') {
                if (d == 0) {
                    start.y--;
                } else if (d == 1) {
                    start.x--;
                } else if (d == 2) {
                    start.y--;
                } else if (d == 3) {
                    start.x++;
                } else if (d == 4) {
                    start.z--;
                } else if (d == 5) {
                    start.z++;
                }
            }

            /* for left and right rotation first we will check wether d belongs to our distance array
           index,if it is we will simply change direction as given below.*/
          
           /*consider this explanation 
           we have numbered N-0,E-1,S-2,W-3:
           if we have current direction as N,if we want to rotate left then we simply decrease index(index is made sure to bound in range 0 to 4) hence we will have direction as 3;
           now if we have 5 or 4 number,we update it manualy
           */
            else if (c == 'l') {
                if (d < 4) {
                    if (d < 0) {
                        // Handle negative indices by wrapping around
                        d = (d +4)% 4;
                        d = direction[d];
                    } else {
                        d = (d - 1+4) % 4 ;
                        d = direction[d];
                    }
                } else {
                    if (d == 4) {
                        d = 0;// point towards north
                    } else if (d == 5) {
                        d = 2;// point towards south
                    }
                }
            }

            else if (c == 'r') {
                if (d < 4) {
                    if (d < 0) {
                        // Handle negative indices by wrapping around
                        d = (d + 4)%4;
                        d = direction[d];
                    } else {
                        d = (d + 1)%4;
                        d = direction[d];
                    }
                } else {
                    if (d == 4) {
                        d = 2;//point towards south
                    } else if (d == 5) {
                        d = 0;//point towards north
                    }
                }
            } else if (c == 'u') {
                d=4;               
            } else if (c == 'd') {
               d=5;              
            }

        }

        // for returning answer we will make array to store (x,y,z,final direction)
        int arr[] = new int[4];
        arr[0] = start.x;
        arr[1] = start.y;
        arr[2] = start.z;
        arr[3] = d;

        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many test cases you want to run?...");
        int numberOfTestCases=sc.nextInt();

        while(numberOfTestCases>0){
        // starting position coordinates i,j,k
        System.out.println("Enter 3 coordinates");
        
        System.out.println("X coordinate");
        int m=sc.nextInt();

        System.out.println("Y coordinate");
        int t=sc.nextInt();

        System.out.println("Z coordinate");
        int o=sc.nextInt();

        System.out.println("Number of array elements");
        int n = sc.nextInt();

        char input[] = new char[n];

        System.out.println("Enter elements(in lower case from {u,d,l,r,f,b})");
        // taking input in array
        for (int i = 0; i < n; i++) {
            input[i] = sc.next().charAt(0);
        }

        System.out.println("Give starting direction in lower case");
        char p = sc.next().charAt(0);// starting direction

        // we will consider direction as number
        // for N-0,E-1,S-2,W-3
        int direction[] = { 0, 1, 2, 3 };
        // we will consider U-4,D-5

        // converting starting direction into number d
        int d = 0;
        
            if (p == 'n')
                d = 0;
            else if (p == 'e')
                d = 1;
            else if (p == 'w')
                d = 2;
            else if (p == 's')
                d = 3;
       

        // for printing answer(we can also update the coordinate which we consider as start,but for clarity  i m using array)
        int ans[] = findDirectionAndPosition(input, n, d, direction,m,t,o);
        System.out.println("final x coordinate" + " " + ans[0]);
        System.out.println("final Y coordinate" + " " + ans[1]);
        System.out.println("final z coordinate" + " " + ans[2]);
       
        //finalDirection-number:N-0,E-1,S-2,W-3,U-4,D-5
        System.out.println("Direction" + " " + ans[3]);
        numberOfTestCases--;
    }
    }
}
