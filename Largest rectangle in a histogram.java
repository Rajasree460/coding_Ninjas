import java.util.ArrayList;

import java.util.Stack;

public class Solution {

  public static int largestRectangle(ArrayList < Integer > arr) {

    int nsr[]=new int[arr.size()];

    int nsl[]=new int[arr.size()];

    int max=Integer.MIN_VALUE;

    Stack<Integer> s=new Stack<>();

    for(int i=arr.size()-1;i>=0;i--){

          while(!s.isEmpty() && arr.get(s.peek())>=arr.get(i)){

            s.pop();

          }

          if(s.isEmpty()){

            nsr[i]=arr.size();

          }

          else{

            nsr[i]=s.peek();

          }

          s.push(i);

    }

    Stack<Integer> st=new Stack<>();

     for(int i=0;i<arr.size();i++){

          while(!st.isEmpty() && arr.get(st.peek())>=arr.get(i)){

            st.pop();

          }

          if(st.isEmpty()){

            nsl[i]=-1;

          }

          else{

            nsl[i]=st.peek();

          }

          st.push(i);

    }

    for(int i=0;i<arr.size();i++){

      int h=arr.get(i);

      int width=nsr[i]-nsl[i]-1;

      int area=h*width;

      max=Math.max(area, max);

    }

    return max;

  }

}
