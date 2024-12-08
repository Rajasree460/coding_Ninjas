import java.util.*;
public class Solution {
    public static List<Integer> findSchedule(int numCourses, List<List<Integer>> prerequisites) {
        // Write your code here.
        ArrayList<Integer>[] graph = new ArrayList[numCourses+1];
        for(int i = 0; i <= numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[numCourses+1];
        for(int i = 0; i < prerequisites.size(); i++){
            int u = prerequisites.get(i).get(0);
            int v = prerequisites.get(i).get(1);
            graph[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int rem = q.poll();
            ans.add(rem);
            for(Integer nbr: graph[rem]){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}
