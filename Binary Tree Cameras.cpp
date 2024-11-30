#include <bits/stdc++.h> 

using namespace std;

 

enum class State {NONE, COVERED, CAMERA};

 

State dfs(TreeNode<int>* root, int& cameras) {

    if (root == nullptr) {

        return State::COVERED;

    }

    

    State left = dfs(root->left, cameras);

    State right = dfs(root->right, cameras);

    

    if (left == State::NONE || right == State::NONE) {

        cameras++;

        return State::CAMERA;

    }

    

    if (left == State::CAMERA || right == State::CAMERA) {

        return State::COVERED;

    }

    

    return State::NONE;

}

 

int getMinCamera(TreeNode<int>* root) {

    int cameras = 0;

    if (dfs(root, cameras) == State::NONE) {

        cameras++;

    }

    return cameras;

}
