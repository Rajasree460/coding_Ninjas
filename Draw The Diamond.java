public class Solution {

    public static void printTheDiamond(int r, int c, int s) {

        for(int row=0; row<r; row++) {

            for(int i=0; i<s; i++) {

                for(int col=0; col<c; col++) {

                    for(int j=0; j<s-i-1; j++) {

                         System.out.print("e");

                    }

                    System.out.print("/");

                    for(int j=0; j<2*i; j++) {

                         System.out.print("o");

                    }

                    System.out.print("\\");

                    for(int j=0; j<s-i-1; j++) {

                         System.out.print("e");

                    }

                }

                System.out.println();

            }

            for(int i=0; i<s; i++) {

                for(int col=0; col<c; col++) {

                    for(int j=0; j<i; j++) {

                        System.out.print("e");

                    }

                    System.out.print("\\");

                    for(int j=0; j<2*(s-i-1); j++) {

                        System.out.print("o");

                        }

                        System.out.print("/");

                    for(int j=0; j<i; j++) {

                        System.out.print("e");

                        }

                    }

                    System.out.println();

            }

        }

   }

}
