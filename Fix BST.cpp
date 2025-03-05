/*
    Following is Binary Tree Node structure:
    class TreeNode
    {
    public:
        int data;
        TreeNode *left, *right;
        TreeNode() : data(0), left(NULL), right(NULL) {}
        TreeNode(int x) : data(x), left(NULL), right(NULL) {}
        TreeNode(int x, TreeNode *left, TreeNode *right) : data(x), left(left), right(right) {}
    };
*/
TreeNode* first, *second, *pre;

void correctTree(TreeNode* root){
    if(!root)       return;

    correctTree(root->left);

    if(pre && pre->data > root->data){
        if(!first)      first = pre;
        second = root;
    }
    pre = root;

    correctTree(root->right);
}

TreeNode * FixBST(TreeNode * root){
    // Write your code here.
    first = NULL, second = NULL,  pre = NULL;
    correctTree(root);

    swap(first->data, second->data);
    return root;
}
