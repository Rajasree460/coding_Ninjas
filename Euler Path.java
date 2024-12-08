import java.util.* ;
import java.io.*; 
public class Solution {
	private static HashSet<List<Integer>> visited;
	private static void dfs(List<Integer> graph[],int curr,ArrayList<Integer> output)
	{
		// visited[curr]=true;
		for(int x:graph[curr])
		{
			// if(!visited[x])
			List<Integer> list=Arrays.asList(curr,x);
			if(visited.contains(list))
				continue;
			List<Integer> list2=Arrays.asList(x,curr);
			visited.add(list);
			visited.add(list2);
			dfs(graph,x,output);
		}
		output.add(curr);
	}
	public static ArrayList<Integer> printEulerPath(int n, ArrayList<ArrayList<Integer>> edgeList) {
		List<Integer> graph[]=new ArrayList[n];
		for(int i=0;i<n;i++)
		{
			graph[i]=new ArrayList<>();
		}
		for(ArrayList<Integer> x:edgeList)
		{
			graph[x.get(0)].add(x.get(1));
			graph[x.get(1)].add(x.get(0));
		}
		int count=0;
		int start=0;
		int index=0;
		for(List<Integer> x:graph)
		{
			if(x.size()%2!=0)
			{
				count++;
				start=index;
			}
			index++;
		}
		ArrayList<Integer> output=new ArrayList<>();
		// boolean visited[]=new boolean[edgeList.size()];
		visited=new HashSet<>();
		if(count!=0 && count!=2)
		{
			output.add(-1);
			return output;
		}
		dfs(graph,start,output);
		// System.out.println(output);
		return output;
	}
}
