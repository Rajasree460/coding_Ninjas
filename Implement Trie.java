public class Trie {


    //Initialize your data structure here
    static Node root;
    Trie() {
        //Write your code here
        root = new Node();
    }


    //Inserts a word into the trie

    public static void insert(String word) {
        //Write your code here
        Node curr = root;
        int N = word.length();

        for(int i=0; i<N; i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }


    //Returns if the word is in the trie

    public static boolean search(String word) {
        //Write your code here
        Node curr = root;
        int N = word.length();

        for(int i=0; i<N; i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }

        if(curr.isEnd) return true;

        return false;
    }

    
    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String word) {
        //Write your code here
        Node curr = root;
        int N = word.length();

        for(int i=0; i<N; i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }

        return true;
    }
}

class Node {
    Node children[] = new Node[26];
    boolean isEnd;

    Node() {
        isEnd = false;
        for(int i=0; i<26; i++) {
            children[i] = null;
        }
    }
}
