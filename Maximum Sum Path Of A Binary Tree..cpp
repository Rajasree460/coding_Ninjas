int maxPSum(BinaryTreeNode<int>* node, int& maxi){

    if (node== NULL) return 0;

    int left= max(0, maxPSum(node->left, maxi));

    int right= max(0, maxPSum(node->right, maxi));

    maxi= max(maxi, node->data + left+ right);

    return max(left, right)+ node->data;

}

 

int maxPathSum(BinaryTreeNode<int> *root)

{

    int maxi= INT_MIN;

    maxPSum(root, maxi);

    return maxi;

}
