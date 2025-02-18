import java.util.*;

public class Solution {

    public static List<String> findPossibleWords(List<String> arr, List<List<Character>> mat) {

        int n = mat.size();

        int m = mat.get(0).size();

        List<String> ans = new ArrayList<>();

        Set<String> set = new HashSet<>();

        for (String word : arr) {

            if (!set.contains(word) && doesExist(word, convertBoard(mat), n, m)) {

                set.add(word);

                ans.add(word);

            }

        }

        Collections.sort(ans);

        return ans;

    }

    private static boolean isValid(int x, int y, int n, int m, String s, int indx, char[][] board) {

        return (x >= 0 && y >= 0 && x < n && y < m && board[x][y] == s.charAt(indx));

    }

    private static boolean solve(int x, int y, int indx, int n, int m, String s, char[][] board) {

        if (!isValid(x, y, n, m, s, indx, board)) return false;

        if (indx == s.length() - 1) return true;

        char temp = board[x][y];

        board[x][y] = '#';

        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};

        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < 8; i++) {

            if (solve(x + dx[i], y + dy[i], indx + 1, n, m, s, board)) {

                board[x][y] = temp;

                return true;

            }

        }

        board[x][y] = temp;

        return false;

    }

    private static boolean doesExist(String word, char[][] board, int n, int m) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (solve(i, j, 0, n, m, word, board))

                    return true;

            }

        }

        return false;

    }

    private static char[][] convertBoard(List<List<Character>> board) {

        int n = board.size();

        int m = board.get(0).size();

        char[][] converted = new char[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                converted[i][j] = board.get(i).get(j);

            }

        }

        return converted;

    }

}
