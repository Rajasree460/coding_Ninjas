import java.util.PriorityQueue;

class Solution {

 public static int mazeRunner(int n, int m, int maze[][], int start[], int destination[]) {        int[][] dir = new int[4][2];    dir[0] = new int[] {1,0};    dir[1] = new int[] {0, 1};    dir[2] = new int[] {-1, 0};    dir[3] = new int[] {0,-1 };

      boolean[][] visited = new boolean[maze.length][maze[0].length];

   PriorityQueue < Point > q = new PriorityQueue < Point > ();    q.add(new Point(start[0], start[1], 0));      while (!q.isEmpty()) {      Point p = q.poll();            if (p.x == destination[0] && p.y == destination[1]) {        return p.step;      }         visited[p.x][p.y] = true;      for (int k = 0; k < dir.length; k++) {        int i = p.x;        int j = p.y;        int count = 0;               while (i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] == 0) {          i += dir[k][0];          j += dir[k][1];          count++;        }        i -= dir[k][0];        j -= dir[k][1];        count--;

       if (visited[i][j] == false) {          q.add(new Point(i, j, p.step + count));        }      }    }       return -1;  }

 private static class Point implements Comparable < Point > {    public int x;    public int y;    public int step;    public Point(int x, int y, int step) {      this.x = x;      this.y = y;      this.step = step;    }    public int compareTo(Point p) {      return this.step - p.step;    }  }

}
