class k_queue{
    private:
    int n;
    int qn;
    int* arr;
    int* front;
    int* rare;
    int* next;
    int freeSpot;

    public:
    k_queue(int n, int qn){
        this->n = n;
        this->qn = qn;
        arr = new int[n];
        next = new int[n];
        front = new int[qn];
        rare = new int[qn];
        freeSpot = 0;

        for(int i=0;i<qn;i++){
            front[i] = -1;
            rare[i] = -1;
        }

        for(int i=0;i<n;i++){
            next[i] = i+1;
        }
        next[n-1] = -1;
    }

    int enqueue(int data, int qn){
        // check overflow
        if(freeSpot == -1){
            // cout<<"Queue if full"<<endl;
            return -1;
        }

        // get index to insert the data
        int index = freeSpot;

        // update freeSpot
        freeSpot = next[index];

        // check if first element to be inserted or not
        if(front[qn-1] == -1){
            front[qn-1] = index;
        }else{
            // linking current index to next index of perticular queue
            next[rare[qn-1]] = index;
        }

        // update next array
        next[index] = -1;

        // updating rare
        rare[qn-1] = index;

        // pushing the data at index
        arr[index] = data;

        return 0;
    }

    int dequeue(int qn){
        // check underflow
        if(front[qn-1] == -1){
            // cout<<"Queue "<<qn<<" is empty"<<endl;
            return -1;
        }

        // getting index to pop the data
        int index = front[qn-1];

        // updating front
        front[qn -1] = next[index];

        // updating freeSpot
        next[index] = freeSpot;
        freeSpot = index;

        // returning the popped element
        return arr[index];

    }

};

vector<int> k_queues(int l, int n, int q, vector<vector<int>> &queries){
    k_queue k(l, n);
    vector<int> ans;

    for(int i=0;i<q;i++){
        if(queries[i][0] == 1){
            int val = k.enqueue(queries[i][2], queries[i][1]);
            ans.push_back(val);
        }else{
            int val = k.dequeue(queries[i][1]);
            ans.push_back(val);
        }
    }

    return ans;
}
