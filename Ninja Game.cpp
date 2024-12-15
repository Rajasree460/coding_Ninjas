int ninjaGame(vector<int> &a, int n) {

    // Write your code here.

    int ans=0;

    for(int i=0;i<n;i++){

        ans^=a[i];

    }

    if(ans!=0)return 1;

    return 0;

}
