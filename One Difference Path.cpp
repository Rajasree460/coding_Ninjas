#include <bits/stdc++.h>

vector<pair<int, int>> moveHorizontally(int n, int m, vector<vector<int>> &a, int x, int y, vector<vector<set<int>>> &rows, vector<vector<set<int>>> &cols) {
    int bounded = m + 1;
    if (rows[x][0].upper_bound(y) != rows[x][0].end()) {
        bounded = *rows[x][0].upper_bound(y);
    }
    vector<pair<int, int>> ans;
    for (int value = a[x][y] - 1; value <= a[x][y] + 1; value++) {
        if (value < 0 || value > 9) {
            continue;
        }
        auto it = rows[x][value].upper_bound(y);
        while (it != rows[x][value].end() && *it < bounded) {
            ans.push_back({x, *it});
            it++;
        }
    }
    bounded = -1;
    if (rows[x][0].lower_bound(y) != rows[x][0].begin()) {
        bounded = *(--rows[x][0].lower_bound(y));
    }
    for (int value = a[x][y] - 1; value <= a[x][y] + 1; value++) {
        if (value < 0 || value > 9) {
            continue;
        }
        auto it = rows[x][value].lower_bound(y);
        while (it != rows[x][value].begin()) {
            it--;
            if (*it <= bounded) {
                break;
            }
            ans.push_back({x, *it});
        }
    }
    for (int i = 0; i < ans.size(); i++) {
        int nx = ans[i].first, ny = ans[i].second;
        rows[nx][a[nx][ny]].erase(ny);
        cols[ny][a[nx][ny]].erase(nx);
    }
    return ans;
}

vector<pair<int, int>> moveVertically(int n, int m, vector<vector<int>> &a, int x, int y, vector<vector<set<int>>> &rows, vector<vector<set<int>>> &cols) {
    int bounded = n + 1;
    if (cols[y][0].upper_bound(x) != cols[y][0].end()) {
        bounded = *cols[y][0].upper_bound(x);
    }
    vector<pair<int, int>> ans;
    for (int value = a[x][y] - 1; value <= a[x][y] + 1; value++) {
        if (value < 0 || value > 9) {
            continue;
        }
        auto it = cols[y][value].upper_bound(x);
        while (it != cols[y][value].end() && *it < bounded) {
            ans.push_back({*it, y});
            it++;
        }
    }
    bounded = -1;
    if (cols[y][0].lower_bound(x) != cols[y][0].begin()) {
        bounded = *(--cols[y][0].lower_bound(x));
    }
    for (int value = a[x][y] - 1; value <= a[x][y] + 1; value++) {
        if (value < 0 || value > 9) {
            continue;
        }
        auto it = cols[y][value].lower_bound(x);
        while (it != cols[y][value].begin()) {
            it--;
            if (*it <= bounded) {
                break;
            }
            ans.push_back({*it, y});
        }
    }
    for (int i = 0; i < ans.size(); i++) {
        int nx = ans[i].first, ny = ans[i].second;
        rows[nx][a[nx][ny]].erase(ny);
        cols[ny][a[nx][ny]].erase(nx);
    }
    return ans;
}

int oneDifferencePath(int n, int m, vector<vector<int>> &a, int sx, int sy, int tx, int ty) {
    vector<vector<set<int>>> rows(n, vector<set<int>>(10));
    vector<vector<set<int>>> cols(m, vector<set<int>>(10));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            rows[i][a[i][j]].insert(j);
            cols[j][a[i][j]].insert(i);
        }
    }
    int maxx = 1E9;
    vector<vector<int>> minDis(n, vector<int>(m, maxx));
    queue<pair<int, int>> q;
    q.push({sx, sy});
    minDis[sx][sy] = 0;
    rows[sx][a[sx][sy]].erase(sy);
    cols[sy][a[sx][sy]].erase(sx);
    while (!q.empty()) {
        auto curCell = q.front();
        q.pop();
        int xCord = curCell.first, yCord = curCell.second;
        if (xCord == tx && yCord == ty) {
            break;
        }
        vector<pair<int, int>> horiozontalCells = moveHorizontally(n, m, a, xCord, yCord, rows, cols);
        vector<pair<int, int>> verticalCells = moveVertically(n, m, a, xCord, yCord, rows, cols);
        for (auto &cell : horiozontalCells) {
            int nx = cell.first;
            int ny = cell.second;
            q.push({nx, ny});
            minDis[nx][ny] = minDis[xCord][yCord] + 1;
        }
        for (auto &cell : verticalCells) {
            int nx = cell.first;
            int ny = cell.second;
            q.push({nx, ny});
            minDis[nx][ny] = minDis[xCord][yCord] + 1;
        }
    }
    return (minDis[tx][ty] == maxx) ? -1 : minDis[tx][ty];
}
