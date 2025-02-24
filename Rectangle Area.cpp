#include <set>

 

bool cmp(vector<int> &a,  vector<int> &b)

{

    if (a[2] != b[2])

        return a[2] < b[2];

    return a[0] < b[0];

}

 

struct Node

{

    // start coordinate of a range

    int start;

    // end coordinate of a range   

    int end; 

    // count how many times this range has been covered by rectangles    

    int cnt;

    // area that is covered within this range     

    int covered;

    // left sub-segement tree

    Node *left; 

    // right sub-segment tree 

    Node *right; 

    Node(int s, int e, int cn, int cv, Node *r1, Node *r2)

    {

        start = s;

        end = e;

        cnt = cn;

        covered = cv;

        left = r1;

        right = r2;

    }

};

 

// fuction to build segment tree

Node *Build(vector<int> &A, int s, int e)

{

    if (s >= e)

    {

        return NULL;

    }

 

    if (e - s == 1)

    {

        return new Node(A[s], A[s + 1], 0, 0, NULL, NULL);

    }

 

    int mid = (s + e) / 2;

    Node *left = Build(A, s, mid);

    Node *right = Build(A, mid, e);

    return new Node(left -> start, right -> end, 0, 0, left, right);

}

 

// function to update tree

void Update(Node *r, int s, int e, const int val)

{

    if (!r)

    {

        return;

    }

 

    if (s >= r -> end || e <= r -> start)

    {

        return;

    }

 

    if (s <= r -> start && e >= r -> end)

    {

        r -> cnt += val;

    }

    else

    {

        // update left tree

        Update(r -> left, s, e, val); 

        // update right tree 

        Update(r -> right, s, e, val); 

    }

    if (r -> cnt)

    {

        r -> covered = r -> end - r -> start;

    }

    else

    {

        if (r -> left && r -> right)

        {

            r -> covered = r -> left -> covered + r -> right -> covered;

        }

        else

        {

            r -> covered = 0;

        }

    }

}

 

int rectangleArea(int N, vector<vector<int>> &rec)

{

    int c = 1e9 + 7;

 

    if (N == 0)

    {

        return 0;

    }

 

    set<int> xcoord;

 

    for (vector<int> &v : rec)

    {

        xcoord.insert(v[0]), xcoord.insert(v[2]);

    }

 

    vector<int> Xcoord;

 

    for (set<int>::iterator it = xcoord.begin(); it != xcoord.end(); it++)

    {

        Xcoord.push_back(*it);

    }

    

    long long int res = 0;

 

    Node *root = Build(Xcoord, 0, Xcoord.size() - 1);

 

    vector<vector<int>> data;

    vector<int> temp(4, 0);

 

    for (vector<int> &v : rec)

    {

        temp[0] = v[0];

        temp[1] = v[2];

        temp[2] = v[1];

        temp[3] = 1;

        data.push_back(temp);

        temp[2] = v[3];

        temp[3] = -1;

        data.push_back(temp);

    }

 

    sort(data.begin(), data.end(), cmp);

 

    Update(root, data[0][0], data[0][1], data[0][3]);

    for (int i = 1; i < data.size(); i++)

    {

        long long h = data[i][2] - data[i - 1][2];

        long long w = root->covered;

 

        if (h > 0)

        {

            res += (w * h) % c, res %= c;

        }

 

        Update(root, data[i][0], data[i][1], data[i][3]);

    }

 

    return res % c;

}
