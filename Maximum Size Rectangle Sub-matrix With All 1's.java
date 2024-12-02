import java.util.Stack;
public class Solution {
    public static int maxAreaHistogram(int heights[]){
        int n=heights.length,maxArea=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>=heights[i])){
              int h=heights[st.pop()];
              int w=i;
              if(!st.isEmpty()) w=i-st.peek()-1;
              maxArea=Math.max(maxArea,h*w);
            }
            st.push(i);
        }
        return maxArea;
    }
	public static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {
		// Write your code here.
        int heights[]=new int[m],maxArea=0;
        for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
            if(mat[i][j]==1) heights[j]++;
            else heights[j]=0;
          }
          int currArea= maxAreaHistogram(heights);
          maxArea=Math.max(currArea,maxArea);
        }
        return maxArea;
	}
}
