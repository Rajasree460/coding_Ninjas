#include <bits/stdc++.h>

using namespace std;

 

class TrieNode {

public:

    vector<string> words;

    unordered_map<char, TrieNode*> children;

 

    TrieNode() {}

};

 

class Trie {

public:

    TrieNode* root;

 

    Trie() {

        root = new TrieNode();

    }

 

    void insert(string& word) {

        TrieNode* node = root;

        for (char c : word) {

            if (node->children.find(c) == node->children.end()) {

                node->children[c] = new TrieNode();

            }

            node = node->children[c];

            node->words.push_back(word);

        }

    }

 

    vector<string> findWordsWithPrefix(string& prefix) {

        TrieNode* node = root;

        for (char c : prefix) {

            if (node->children.find(c) == node->children.end()) {

                return {};

            }

            node = node->children[c];

        }

        return node->words;

    }

};

 

void backtrack(int step, vector<string>& square, Trie& trie, vector<vector<string>>& results, int N) {

    if (step == N) {

        results.push_back(square);

        return;

    }

 

    string prefix;

    for (int i = 0; i < step; ++i) {

        prefix += square[i][step];

    }

 

    vector<string> candidates = trie.findWordsWithPrefix(prefix);

    for (string& candidate : candidates) {

        square.push_back(candidate);

        backtrack(step + 1, square, trie, results, N);

        square.pop_back();

    }

}

 

vector<vector<string>> wordSquares(vector<string>& words) {

    vector<vector<string>> results;

    if (words.empty()) return results;

 

    int N = words[0].size();

    Trie trie;

    for (string& word : words) {

        trie.insert(word);

    }

 

    vector<string> square;

    for (string& word : words) {

        square.push_back(word);

        backtrack(1, square, trie, results, N);

        square.pop_back();

    }

 

    return results;

}
