#include <bits/stdc++.h> 

class Node{
    public:
        char data;
        Node* children[26];
        bool isWord;
    public:
        Node(){
            data = '\0';
            for(int i = 0; i < 26; i++){
                children[i] = NULL;
            }
            isWord = false;
        }
        Node(char x){
            data = x;
            for(int i = 0; i < 26; i++){
                children[i] = NULL;
            }
            isWord = false;
        }
};


class Trie: public Node{
    private:
        Node* root;
    public:
        Trie(){
            root = NULL;
        }
        void insert(string str){
            if(root == NULL){
                root = new Node;
            }
            Node* curr = root;
            int n = str.length();
            for(int i = 0; i < n; i++){
                int index = str[i] - 'a';
                if(curr->children[index] == NULL){
                    curr->children[index] = new Node(str[i]);
                }
                curr = curr->children[index];
            }
            curr->isWord = true;
        }
        void printAllWord(Node* head, string word, vector<string> &ans){
            if(head == NULL) ans.push_back(word);
            if(ans.size() == 3) return;
            word.push_back(head->data);
            if(head->isWord){
                ans.push_back(word);
                if(ans.size() == 3) return;
            }
            
            for(int i = 0; i < 26; i++){
                if(head->children[i] != NULL)
                    printAllWord(head->children[i], word, ans);
                if(ans.size() == 3) return;
            }
        } 

        vector<vector<string>> autoSugg(string queryStr){
            Node* prev = root;
            int n = queryStr.length();
            string word;
            vector<vector<string>> ans;
            for(int i = 0; i < n; i++){
                vector<string> sugg;
                int index = queryStr[i] - 'a';
                if(prev != NULL && prev->children[index] != NULL){
                    Node* head = prev->children[index];
                    printAllWord(head, word, sugg);
                }
                if(prev != NULL) prev = prev->children[index];
                ans.push_back(sugg);
                word.push_back(queryStr[i]);
            }
            return ans;
        }
};

vector<vector<string>> autoSuggestion (int n, vector<string> S, int l, string P)
{
    // Approach: Using Trie Data Structure
    // Time Complexity: O(N*M + N*M*M)
    // <N->total number of contacts, M->length of string>
    // Space Complexity: O(N*M)
    // Insert all the words
    Trie ds;
    for(auto word : S){
        ds.insert(word);
    }

    return ds.autoSugg(P);  
}
