import java.util.ArrayList;

import java.util.HashMap;

import java.util.PriorityQueue;

import java.util.*;

public class Solution {

    static class Pair {

        int node, cost;

        public Pair(int node, int cost) {

            this.node = node;

            this.cost = cost;

        }

    }

    static Map<Integer, List<Pair>> map = new HashMap<>();

    public static int prims(int n) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> (a.cost-b.cost));

        boolean[] visited = new boolean[n+1];

        pq.add(new Pair(0, 0));

        int sum = 0;

        while(!pq.isEmpty()) {

            Pair curr = pq.poll();

            if(visited[curr.node]) continue;

            visited[curr.node] = true;

            sum += curr.cost;

            for(Pair child: map.get(curr.node)) {

                if(!visited[child.node]) pq.add(child);

            }

        }

        return sum;

    }

    public static int supplyWater(int n, int k, int[] wells, int[][] pipes) {

        for(int i = 0; i <= n; i++) {

            map.put(i, new ArrayList<>());

            if(i != 0) {

                map.get(0).add(new Pair(i, wells[i-1]));

                map.get(i).add(new Pair(0, wells[i-1]));

            }

        }

        for(int i = 0; i < pipes.length; i++) {

            map.get(pipes[i][0]).add(new Pair(pipes[i][1], pipes[i][2]));

            map.get(pipes[i][1]).add(new Pair(pipes[i][0], pipes[i][2]));

        }

        return prims(n);

    }

}
