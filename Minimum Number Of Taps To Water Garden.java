int minimumTapsToFillGarden(vector<int>& ranges, int n) {
    vector<pair<int, int>> mod(n);
    
    // Construct the intervals
    for (int i = 0; i < n; ++i) {
        int low = max(0, i - ranges[i]);
        int high = min(n, i + ranges[i]);
        mod[i] = {low, high};
    }
    
    // Sort intervals based on their start points
    sort(mod.begin(), mod.end());
    
    int ans = 0;
    int i = 0;
    int maxReach = 0;
    
    while (maxReach < n) {
        int newMaxReach = maxReach;
        
        // Iterate over intervals that cover the current reach
        while (i < n && mod[i].first <= maxReach) {
            newMaxReach = max(newMaxReach, mod[i].second);
            ++i;
        }
        
        // If no interval was found to cover current reach, return -1
        if (newMaxReach == maxReach)
            return -1;
        
        maxReach = newMaxReach;
        ++ans;
    }
    
    return ans;
}
