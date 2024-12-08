#include <iostream>

#include <vector>

#include <unordered_map>

using namespace std;

 

class UnionFind {

    vector<int> parent;

    vector<int> rank;

public:

    UnionFind(int n) {

        parent.resize(n);

        rank.resize(n, 1);

        for (int i = 0; i < n; ++i) {

            parent[i] = i;

        }

    }

    

    int find(int u) {

        if (parent[u] != u) {

            parent[u] = find(parent[u]); 

        }

        return parent[u];

    }

    

    void unite(int u, int v) {

        int root_u = find(u);

        int root_v = find(v);

        

        if (root_u != root_v) {

            if (rank[root_u] > rank[root_v]) {

                parent[root_v] = root_u;

            } else if (rank[root_u] < rank[root_v]) {

                parent[root_u] = root_v;

            } else {

                parent[root_v] = root_u;

                rank[root_u]++;

            }

        }

    }

};

 

bool identicalSentences(vector<string> word1, vector<string> word2, vector<vector<string>> pairs, int n, int m, int p) {

    if (n != m) {

        return false; 

    }

    

    UnionFind uf(2 * p); 

    unordered_map<string, int> word_index;

    int index = 0;

    

    for (const auto& pair : pairs) {

        for (const string& word : pair) {

            if (word_index.find(word) == word_index.end()) {

                word_index[word] = index++;

            }

        }

        uf.unite(word_index[pair[0]], word_index[pair[1]]);

    }

    

    for (int i = 0; i < n; ++i) {

        string w1 = word1[i];

        string w2 = word2[i];

        

        if (w1 != w2) {

            if (word_index.find(w1) == word_index.end() || word_index.find(w2) == word_index.end()) {

                return false; 

            }

            

            int root_w1 = uf.find(word_index[w1]);

            int root_w2 = uf.find(word_index[w2]);

            

            if (root_w1 != root_w2) {

                return false; 

            }

        }

    }

    

    return true;

}

 
