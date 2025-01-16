import java.util.*;

public class Solution {

    public static void spiralPrint(int matrix[][]){

        if(matrix==null||matrix.length==0)

        return;

         int n = matrix.length;

        int m=matrix[0].length;

        ArrayList<Integer> li = new ArrayList<>();

        int leftc = 0; int rightc = m-1; int upr = 0; int bottomr = n-1;

        while(leftc<=rightc&&upr<=bottomr){

            for(int i =leftc;i<=rightc;i++){

                li.add(matrix[upr][i]);

            }

            upr++;

            for(int i = upr;i<=bottomr;i++){

                li.add(matrix[i][rightc]);

            }

            rightc--;

            if(upr<=bottomr){

                for(int i = rightc;i>=leftc;i--){

                    li.add(matrix[bottomr][i]);

                }

                bottomr--;

            }

            if(leftc<=rightc){

                for(int i = bottomr;i>=upr;i--){

                    li.add(matrix[i][leftc]);

                }

                leftc++;

            }

        }

        for(int i:li){

            System.out.print(i+" ");

        }

    }

}
