#include <set>

int infinite = 1e8;

vector<int> bellmanFord(int N, int M, vector<vector<int>> roads)

{


 

    vector<int> dist(N + 1);


 

  

    for(int i = 0; i < N; i++)

    {

        dist[i] = infinite;

        roads.push_back({N, i, 0});

    }


 

  

    for(int i = 0; i < N; i++)

    {

        for(vector<int> edge : roads)

        {

            if((dist[edge[0]] != infinite) and (dist[edge[0]] + edge[2] < dist[edge[1]]))

            {

                dist[edge[1]] = dist[edge[0]] + edge[2];

            }

        }

    }


 

 

    for(int i = 0; i < M; i++)

    {

        vector<int> edge = roads[i];

        if((dist[edge[0]] != infinite) and (dist[edge[0]] + edge[2] < dist[edge[1]]))

        {

            dist.clear();

            return dist;

        }

    }


 

  

    return dist;

}


 

vector<int> dijkshtra(int source, int N, vector<vector<pair<int, int>>>& graph)

{

   

    vector<int> dist(N, infinite);

    vector<bool> visited(N, false);


 

   

    multiset<pair<int, int>> minHeap;

    dist[source] = 0;

    minHeap.insert({0, source});


 

    while(!minHeap.empty())

    {

       

        pair<int,int> P = *minHeap.begin();

        minHeap.erase(minHeap.begin());


 

        int node = P.second;

        if(visited[node])

            continue;


 

        visited[node] = true;


 

      

        for(pair<int,int> adj : graph[node])

        {

            int d = adj.first, wei = adj.second;

            if(dist[node] + wei < dist[d])

            {

                dist[d] = dist[node] + wei;

                minHeap.insert({dist[d], d});

            }

        }

    }


 

  

    return dist;

}



 

vector<vector<int>> eachPath(int N, int M, vector<vector<int>>& roads)

{


 

    vector<int> nodeWeights = bellmanFord(N, M, roads);


 

  

    if(nodeWeights.empty())

    {

        vector<vector<int>> ans(N, vector<int>(N, -1));

        return ans;

    }


 

  

    vector<vector<pair<int, int>>> graph(N);

    for(vector<int> edge : roads)

    {

        int source = edge[0], dest = edge[1];


 

      

        int weight = edge[2] + nodeWeights[source] - nodeWeights[dest];

        graph[source].push_back({dest, weight});

    }


 

    vector<vector<int>> ans;

    for(int i = 0; i < N; i++)

    {

        vector<int> dist = dijkshtra(i, N, graph);


 

       

        for(int j = 0; j < N; j++)

        {

            if(dist[j] == infinite)

                dist[j] = -1;

            else

                dist[j] = dist[j] + nodeWeights[j] - nodeWeights[i];

        }

        

        

        ans.push_back(dist);

    }


 

    return ans;

}
