import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static boolean isAnyMapping(ArrayList<String> words, int row, int col, int bal,
                                       HashMap<Character, Integer> letToDig, char[] digToLet,
                                       int totalRows, int totalCols) {
        if (col == totalCols) {
            if (bal == 0) {
                return true;
            } else {
                return false;
            }
        }

        if (row == totalRows) {
            return (bal % 10 == 0 && isAnyMapping(words, 0, col + 1, bal / 10, letToDig, digToLet, totalRows, totalCols));
        }

        String w = words.get(row);

        if (col >= w.length()) {
            return isAnyMapping(words, row + 1, col, bal, letToDig, digToLet, totalRows, totalCols);
        }

        char letter = w.charAt(w.length() - 1 - col);
        int sign;

        if (row < totalRows - 1) {
            sign = 1;
        } else {
            sign = -1;
        }

        if (letToDig.containsKey(letter) &&
            (letToDig.get(letter) != 0 || (letToDig.get(letter) == 0 && w.length() == 1) || col != w.length() - 1)) {
            return isAnyMapping(words, row + 1, col, bal + sign * letToDig.get(letter), letToDig, digToLet, totalRows, totalCols);
        } else {
            for (int i = 0; i < 10; i++) {
                if (digToLet[i] == '-' && (i != 0 || (i == 0 && w.length() == 1) || col != w.length() - 1)) {
                    digToLet[i] = letter;
                    letToDig.put(letter, i);
                    boolean x = isAnyMapping(words, row + 1, col, bal + sign * letToDig.get(letter), letToDig, digToLet, totalRows, totalCols);
                    if (x == true) {
                        return true;
                    }
                    digToLet[i] = '-';
                    if (letToDig.containsKey(letter)) {
                        letToDig.remove(letter);
                    }
                }
            }
        }
        return false;
    }

    public static boolean isSolvable(int m, ArrayList<String> words, String result) {
        words.add(result);

        int totalRows;
        int totalCols;
        totalRows = words.size();
        totalCols = 0;

        for (int i = 0; i < words.size(); i++) {
            if (totalCols < words.get(i).length()) {
                totalCols = words.get(i).length();
            }
        }

        HashMap<Character, Integer> letToDig = new HashMap<>();
        char[] digToLet = new char[10];
        for (int i = 0; i < 10; i++) {
            digToLet[i] = '-';
        }

        return isAnyMapping(words, 0, 0, 0, letToDig, digToLet, totalRows, totalCols);
    }
}
