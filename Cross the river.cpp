/*
    Time Complexity: O(N^2)
    Space Complexity: O(N^2)

    Where N is the size of the array.
*/

#include<unordered_set>
#include<unordered_map>

bool crossRiver(vector<int> &stones){

    // Create a set of all stone positions.
    unordered_set<int> positionset;

    for(auto pos: stones){
        positionset.insert(pos);
    }

    // Steps[i] will contains all the possible steps to reach ith position.
    unordered_map<int, unordered_set<int>> steps;

    // Steps[0] will have only 0.
    steps[0].insert(0);

    for(auto pos: stones){

        // Iterate over all the possible ways to get to current postion.
        for(auto jump: steps[pos]){

            // Update all the positions from the current postion.
            if(positionset.find(jump + pos) != positionset.end() && jump != 0){
                steps[jump + pos].insert(jump);
            }

            if(positionset.find(jump + pos + 1) != positionset.end() && jump != -1){
                steps[jump + pos + 1].insert(jump + 1);
            }

            if(positionset.find(jump + pos - 1) != positionset.end() and jump != 1){
                steps[jump + pos - 1].insert(jump - 1);
            }
        }
    }

    // If the length of jumps to reach last position is 0.
    return steps[stones.back()].size() != 0;
}
