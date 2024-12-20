import java.util.ArrayList;

 

public class Solution {

 

    public static ArrayList<String> fullJustify(ArrayList<String> words, int maxWidth) {

        ArrayList<String> result = new ArrayList<>();

        int n = words.size();

        int i = 0;

        

        while (i < n) {

            int lineLength = words.get(i).length();

            int j = i + 1;

            

            // Keep adding words as long as they fit in the current line.

            while (j < n && lineLength + words.get(j).length() + (j - i) <= maxWidth) {

                lineLength += words.get(j).length();

                j++;

            }

 

            // Create the line

            StringBuilder line = new StringBuilder();

            int numWords = j - i;

            int numSpaces = maxWidth - lineLength;  // total spaces to distribute

            

            // If it's the last line or there's only one word in the line

            if (j == n || numWords == 1) {

                for (int k = i; k < j; k++) {

                    line.append(words.get(k));

                    if (k < j - 1) {

                        line.append(" ");

                    }

                }

                

                // Fill the remaining spaces to the right

                int remainingSpaces = maxWidth - line.length();

                while (remainingSpaces > 0) {

                    line.append(" ");

                    remainingSpaces--;

                }

            } else {

                // Distribute spaces evenly between words

                int spacesBetweenWords = numSpaces / (numWords - 1);

                int extraSpaces = numSpaces % (numWords - 1);

 

                for (int k = i; k < j; k++) {

                    line.append(words.get(k));

                    if (k < j - 1) {  // no space after the last word

                        for (int s = 0; s <= spacesBetweenWords; s++) {

                            line.append(" ");

                        }

                        if (extraSpaces > 0) {

                            line.append(" ");

                            extraSpaces--;

                        }

                    }

                }

            }

 

            result.add(line.toString());

            i = j;  // move to the next group of words

        }

        

        return result;

    }

}

 

