class coordinates{
    public:
    int maxSum;
    int maxUp;
    int maxDown;
    int maxLeft;
    int maxRight;
    // coordinates(int sum,int up,int down,int left,int right)
    // {
    //     maxSum=sum;
    //     maxUp=up;
    //     maxDown=down;
    //     maxLeft=left;
    //     maxRight=right;
    // }
};
void check(vector<int>&arr,coordinates & res)
{
    //kadanes algo
    int currSum=0;
    int maxSum=0;
    // coordinates ans;
    int up=0,down=0,maxUp=-1;
    for(int i=0;i<arr.size();i++)
    {
        currSum+=arr[i];
        if(currSum<0)
        {
            currSum=0;
            up=i+1;
        }
        // maxSum=max(maxSum,currSum);
        if(maxSum<currSum)
        {
            maxSum=currSum;
            maxUp=up;
            down=i;
        }
    }
    res.maxUp=maxUp;
    res.maxDown=down;
    res.maxSum=maxSum;
}
int maxSumRectangle(vector<vector<int>> arr)
{
    // Write your code here
    int n=(int)arr.size();
    int m=(int)arr[0].size();
    coordinates ans;
    ans.maxSum=0;
    for(int left=0;left<m;left++)// for column
    {
        vector<int>temp(n,0);
        for(int right=left;right<m;right++)
        {   
            for(int i=0;i<n;i++)
            {
                temp[i]+=arr[i][right];
            }
            coordinates t;
            t.maxLeft=left;
            t.maxRight=right;
            check(temp, t);
            if(ans.maxSum<t.maxSum)
            {
                ans=t;
            }
        }
    }
    return ans.maxSum;
}
