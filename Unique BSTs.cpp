vector<TreeNode*> generateTrees(int begin, int finish){

    vector<TreeNode*> all_trees;

    if(begin > finish){

      all_trees.push_back(nullptr);

      return all_trees;

    }

 

    for(int i = begin; i <= finish; i++){

        vector<TreeNode*> left_trees = generateTrees(begin, i - 1);

        vector<TreeNode*> right_trees = generateTrees(i + 1, finish);

        for(TreeNode* l : left_trees){

            for(TreeNode* r : right_trees){

                TreeNode* curr_tree = new TreeNode(i);

                curr_tree-> left = l;

                curr_tree-> right = r;

                all_trees.push_back(curr_tree); 

            }

        }

    }

    return all_trees;

}

 

vector<TreeNode *> uniqueBST(int n)

{

    if(n == 0){

        return vector<TreeNode*>(); 

    }

    return generateTrees(1, n);

}
