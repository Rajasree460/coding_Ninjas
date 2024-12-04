import java.util.* ;

import java.io.*; 

public class Solution {

    static int finder(int i, int j){

        int k = i*10+j;

        if(k>=0 && k<3 || k>=10 && k<13 || k>=20 && k<23) return 0;

        else if(k>=3 && k<6 || k>=13 && k<16 || k>=23 && k<26) return 3;

        else if(k>=6 && k<10 || k>=16 && k<20 || k>=26 && k<30) return 6;

        

        else if(k>=30 && k<33 || k>=40 && k<43 || k>=50 && k<53) return 30;

        else if(k>=33 && k<36 || k>=43 && k<46 || k>=53 && k<56) return 33;

        else if(k>=36 && k<40 || k>=46 && k<50 || k>=56 && k<60) return 36;

 

        else if(k>=60 && k<63 || k>=70 && k<73 || k>=80 && k<83) return 60;

        else if(k>=63 && k<66 || k>=73 && k<76 || k>=83 && k<86) return 63;

        else return 66;

    }

    static boolean isSafe(int[][] sudoku, int r, int c, int k){

        for(int i=0;i<9;i++){

            if(sudoku[r][i] == k || sudoku[i][c] == k) return false;

        }

        int idx = finder(r,c); 

        int i=idx/10, j=idx%10, n = 3;

        int store = j;

        while(n != 0){

            int m = 3;

            j = store;

            while(m!=0){

                if(sudoku[i][j] == k) return false;

                j++;

                m--;

            }

            n--;

            i++;

        }

        return true;

    }

    static boolean solve(int[][] sudoku){

 

        for(int i=0;i<9;i++){

            for(int j=0;j<9;j++){

                if(sudoku[i][j] == 0){

                    for(int k=1;k<=9;k++){

                        if(isSafe(sudoku, i, j, k)){

                            sudoku[i][j] = k;

                            if(solve(sudoku)){

                                return true;

                            }else{

                                sudoku[i][j] = 0;

                            }

                        }

                    }

                    return false;   

                }

            }

        }

        return true;

    }

    public static void solveSudoku(int[][] sudoku) {

        // Write your code here.

        solve(sudoku);

 

    }

}
