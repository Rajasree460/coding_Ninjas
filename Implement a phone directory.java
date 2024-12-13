import java.util.ArrayList;

import java.util.Collections;

public class Solution {

    public static ArrayList<ArrayList<String>> phoneDirectory(ArrayList<String> contactList, String queryStr) {

        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        ArrayList<Boolean> checker = new ArrayList<>(Collections.nCopies(contactList.size(), true));

        Collections.sort(contactList);

        for (int i = 0; i < queryStr.length(); i++) {

            char key = queryStr.charAt(i);

            ArrayList<String> temp = new ArrayList<>();

            String previous = "";

            for (int j = 0; j < contactList.size(); j++) {

                String word = contactList.get(j);

                if (word.length() > i && word.charAt(i) == key && checker.get(j)) {

                    if (!previous.equals(word))

                        temp.add(word);

                    previous = word;

                } else

                    checker.set(j, false);

            }

            if (temp.size() > 0) {

                ans.add(temp);

            }

        }

        return ans;

    }

}
