import java.util.*; 

public class Solution {

 

   public static int parallelCourses(int n, int[][] prerequisites) {

               // Write your code here        

               ArrayList<ArrayList<Integer>> edges = new ArrayList<>();        

               for(int i=0;i<=n;i++) edges.add(new ArrayList<Integer>());        

               for(int i=0;i<prerequisites.length;i++){            

                   edges.get(prerequisites[i][0]).add(prerequisites[i][1]);        

                   }        

                   Stack<Integer> stack = new Stack<Integer>();        

                   int[] visited = new int[n+1];        

                   int[] height = new int[n+1];        

                   int max = Integer.MIN_VALUE;        

                   for(int i=1;i<=n;i++){            

                       if(visited[i]==0) {                

                           height[i] = 1;                

                           if(!dfs(edges,visited,height,i)) return -1;            }        }        for(int i=1;i<=n;i++) max = Math.max(max,height[i]);        return max;    }    public static boolean dfs(ArrayList<ArrayList<Integer>> edges,int[] visited,int[] height,int src){        visited[src] = 2;        ArrayList<Integer> temp = edges.get(src);        for(int i:temp){            if(visited[i]==2) return false;            height[i] = Math.max(height[i],1+height[src]);            if(!dfs(edges,visited,height,i)) return false;        }        visited[src] = 1;        return true;    } }

 
