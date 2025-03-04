
/*
	Representation of Wormhole

	class Wormhole {
	    int startX;
	    int startY; 
	    int endX; 
	    int endY;
	    int cost;

	    public Wormhole(int startX, int startY, int endX, int endY, int cost) {
	        this.startX = startX;
	        this.startY = startY;
	        this.endX = endX;
	        this.endY = endY;
	        this.cost = cost;
	    }
	}
	
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map.Entry;

/*
	Representation of Wormhole

	class Wormhole {
	    int startX;
	    int startY; 
	    int endX; 
	    int endY;
	    int cost;

	    public Wormhole(int startX, int startY, int endX, int endY, int cost) {
	        this.startX = startX;
	        this.startY = startY;
	        this.endX = endX;
	        this.endY = endY;
	        this.cost = cost;
	    }
	}
	
*/

public class Solution {
	public static class Pair {
		int node;
		int dist;
		Pair(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}

    public static int minTimeInWormholeNetwork(int n, int sx, int sy, int dx, int dy, Wormhole[] wormhole) {
        //Your code goes here

		HashMap<Wormhole, Integer> map = new HashMap<>();
		HashMap<Integer, Integer> wtMap = new HashMap<>();
		int c = 0;
		map.put(new Wormhole(sx,sy,sx,sy,0), c);
		wtMap.put(c, 0);
		c++;
		for (Wormhole w : wormhole) {
			map.put(w, c);
			wtMap.put(c, w.cost);
			c++;
		}
		Wormhole d = new Wormhole(dx,dy,dx,dy,0);
		map.put(d, c);
		wtMap.put(c, 0);

		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i < n+2; i++) adj.add(new ArrayList<>());

		int minDistToWh = 0;
		for (Wormhole w : wormhole) {
			minDistToWh = Math.min(Math.abs(w.startX-sx) + Math.abs(w.startY-sy), Math.abs(w.endX-sx) + Math.abs(w.endY-sy));
			adj.get(0).add(new Pair(map.get(w), minDistToWh));
		}
		minDistToWh = Math.min(Math.abs(d.startX-sx) + Math.abs(d.startY-sy), Math.abs(d.endX-sx) + Math.abs(d.endY-sy));
		adj.get(0).add(new Pair(map.get(d), minDistToWh));

		for (Wormhole w1 : wormhole) {
			for (Wormhole w2 : wormhole) {
				minDistToWh = Math.min(Math.abs(w2.startX-w1.endX) + Math.abs(w2.startY-w1.endY), Math.abs(w2.endX-w1.startX) + Math.abs(w2.endY-w1.startY));
				if(!w1.equals(w2)) adj.get(map.get(w1)).add(new Pair(map.get(w2), minDistToWh));
			}
			minDistToWh = Math.min(Math.abs(d.startX-w1.endX) + Math.abs(d.startY-w1.endY), Math.abs(d.endX-w1.startX) + Math.abs(d.endY-w1.startY));
			adj.get(map.get(w1)).add(new Pair(map.get(d), minDistToWh));
		}

		int[] minDist = new int[adj.size()];
		Arrays.fill(minDist, Integer.MAX_VALUE);

		Queue<Pair> pq = new LinkedList<>();
		pq.offer(new Pair(0, 0));

		while(!pq.isEmpty()) {
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				Pair pair = pq.poll();
				int node = pair.node;
				int dist = pair.dist;
				int wormholeDist = wtMap.get(node);
				
				for (Pair adjPair : adj.get(node)) {
					int adjNode = adjPair.node;
					int adjDist = adjPair.dist;

					if(minDist[adjNode] > dist + adjDist + wormholeDist) {
						minDist[adjNode] = dist + adjDist + wormholeDist;
						pq.offer(new Pair(adjNode, minDist[adjNode]));
					}
				}
			}
		}

		return minDist[minDist.length-1];
    }
}
