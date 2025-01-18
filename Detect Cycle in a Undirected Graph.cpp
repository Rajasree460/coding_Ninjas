/*class Graph

{

    

public:

    int V;    

    list<int> *adj;    

    */

#include<unordered_map>

bool isCycleDFS(int node,int parent,unordered_map<int,bool>&visited,list<int>*adj){

    visited[node]=true;

 

    for(auto neighbour:adj[node]){

        if(!visited[neighbour]){

            bool ans=isCycleDFS(neighbour, node,visited, adj);

            if(ans==true){

                return true;

            }

        }

        else if(neighbour!=parent){

            return true;

        }

 

    }

    return false;

}

bool isCyclic(Graph g)

{

    unordered_map<int,bool>visited;

    for(int i=0;i<g.V;i++){

          if (!visited[i]) {

            bool ans = isCycleDFS(i, -1, visited, g.adj);

          

                if(ans==true){

            return true;

                }

        }

    }

    return false;

}

 
