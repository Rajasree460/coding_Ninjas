#include <bits/stdc++.h>

 

class Cluster {

public:

    set<vector<int>> inner;

    set<vector<int>> border;

    int perimeter = 0;

};

 

void dfs(vector<vector<int>> &model, int i, int j, Cluster &r) {

    if (model[i][j]) {

        model[i][j] = -1;

        vector<int> v = {i, j};

        r.inner.insert(v);

        vector<int> dx = {1, -1, 0, 0};

        vector<int> dy = {0, 0, 1, -1};

        

        for (int l = 0; l < 4; l++) {

            int newRow = i + dx[l];

            if (newRow < 0 || newRow >= model.size()) {

                continue;

            }

            int newCol = j + dy[l];

            if (newCol < 0 || newCol >= model[0].size()) {

                continue;

            }

            if (model[newRow][newCol] < 0) {

                continue;

            }

            dfs(model, newRow, newCol, r);

        }

    } else {

        vector<int> v = {i, j};

        r.border.insert(v);

        ++r.perimeter;

    }

}

 

vector<Cluster> findClusters(vector<vector<int>> &model, int &maxBorder) {

    vector<Cluster> clusters;

    maxBorder = 0;

    

    for (int i = 0; i < model.size(); i++) {

        for (int j = 0; j < model[0].size(); j++) {

            if (model[i][j] == 1) {

                Cluster r;

                dfs(model, i, j, r);

                clusters.push_back(r);

                maxBorder = max(maxBorder, static_cast<int>(r.border.size()));

            }

        }

    }

    

    return clusters;

}

 

int containVirus(vector<vector<int>> &model) {

    int walls = 0;

    int maxBorder = 0;

    

    while (true) {

        vector<Cluster> clusters = findClusters(model, maxBorder);

        

        if (clusters.empty()) {

            return walls;

        }

        

        for (int r = 0; r < clusters.size(); r++) {

            if (clusters[r].border.size() != maxBorder) {

                for (auto itr = clusters[r].inner.begin(); itr != clusters[r].inner.end(); itr++) {

                    model[(*itr)[0]][(*itr)[1]] = 1;

                }

                for (auto itr = clusters[r].border.begin(); itr != clusters[r].border.end(); itr++) {

                    model[(*itr)[0]][(*itr)[1]] = 1;

                }

            } else {

                walls += clusters[r].perimeter;

            }

        }

    }

}
