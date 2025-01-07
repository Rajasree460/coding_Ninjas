#include<queue>

#include<bits/stdc++.h>>

void findMedian(int *arr, int n)

{

    // Write your code here

    

    if(n==0) return;

    priority_queue<int>maxHeap;

    priority_queue<int,vector<int>,greater<int>>minHeap;

    maxHeap.push(arr[0]);

    cout<<arr[0]<<" ";

    for(int i=1;i<n;i++){

        if(arr[i]<maxHeap.top()){

            maxHeap.push(arr[i]);

        }

        else{

            minHeap.push(arr[i]);

        }

        if(abs(maxHeap.size()-minHeap.size())>1){

            if(minHeap.size()>maxHeap.size()){

                maxHeap.push(minHeap.top());

                minHeap.pop();

            }

            else{

                minHeap.push(maxHeap.top());

                maxHeap.pop();

            }

        }

        if(minHeap.size()==maxHeap.size()){

            cout<<(maxHeap.top()+minHeap.top())/2<<" ";

            continue;

        }

        if(minHeap.size()>maxHeap.size()){

            cout<<minHeap.top()<<" ";

            continue;

        }

        if(minHeap.size()<maxHeap.size()){

            cout<<maxHeap.top()<<" ";

            continue;

        }

 

    }

    return;

}
