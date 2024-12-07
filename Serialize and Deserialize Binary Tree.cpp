string serializeTree(TreeNode<int> *root) {

  string s = "";

  queue<TreeNode<int> *> q;

  q.push(root);

  while (q.empty() == false) {

    TreeNode<int> *temp = q.front();

    q.pop();

 

    if (temp->data == -1) {

      s += "#,";

      continue;

    } else {

      s += to_string(temp->data);

      s += ',';

    }

 

    if (temp->left)

      q.push(temp->left);

    else {

      q.push(new TreeNode<int>(-1));

    }

 

    if (temp->right)

      q.push(temp->right);

    else

      q.push(new TreeNode<int>(-1));

  }

  // 1,2,3,#,4,5,#,#,#,#,#,

  return s;

}

 

TreeNode<int> *deserializeTree(string &s) {

  int i = 0;

  string str = "";

  while (i < s.length() && s[i] != ',') {

    str += s[i];

    i++;

  }

  i++;

  TreeNode<int> *root = new TreeNode<int>(stoi(str));

  queue<TreeNode<int> *> q;

  q.push(root);

  while (i < s.length()) {

    TreeNode<int> *temp = q.front();

    q.pop();

    if (s[i] != '#') {

      str = "";

      while (i < s.length() && s[i] != ',') {

        str += s[i];

        i++;

      }

      temp->left = new TreeNode<int>(stoi(str));

      q.push(temp->left);

    } else {

      i++;

    }

    i++; // to skip ,

 

    if (s[i] != '#') {

      str = "";

      while (i < s.length() && s[i] != ',') {

        str += s[i];

        i++;

      }

      temp->right = new TreeNode<int>(stoi(str));

      q.push(temp->right);

    } else {

      i++;

    }

    i++; // to skip ,

  }

  return root;

}
