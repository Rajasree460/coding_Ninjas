#include <bits/stdc++.h>
using namespace std;

int trappingWater(vector<vector<int>> &matrix) {
    int m = matrix.size();

    // The matrix must have at least 3 columns and 3 rows for water trapping
    if (m <= 2) return 0;
    int n = matrix[0].size();
    if (n <= 2) return 0;

    // Priority queue to contain boundary heights
    priority_queue<pair<int, pair<int, int>>> pq;

    for (int i = 0; i < m; i++) {
        pq.push({-matrix[i][0], {i, 0}});
        pq.push({-matrix[i][n - 1], {i, n - 1}});
    }
    for (int j = 1; j < n - 1; j++) {
        pq.push({-matrix[0][j], {0, j}});
        pq.push({-matrix[m - 1][j], {m - 1, j}});
    }

    // Visited matrix to keep track
    vector<vector<bool>> visited(m, vector<bool>(n, false));

    // Directions for moving right, down, left, and up
    vector<vector<int>> directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // Store the total volume of trapped water
    int waterVolume = 0;

    while (!pq.empty()) {
        auto top = pq.top();
        pq.pop();
        int height = -top.first;
        int row = top.second.first;
        int col = top.second.second;
        
        // Explore neighboring cells
        for (auto dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            // Check if new cell is within matrix and not visited
            if (newRow > 0 && newRow < m - 1 && newCol > 0 && newCol < n - 1 && !visited[newRow][newCol]) {
                visited[newRow][newCol] = true;
                int newHeight = matrix[newRow][newCol];
                
                // Update water volume
                waterVolume += max(0, height - newHeight);
                
                // Update height
                pq.push({-max(height, newHeight), {newRow, newCol}});
            }
        }
    }
    // Return the total volume of trapped water
    return waterVolume;
}
