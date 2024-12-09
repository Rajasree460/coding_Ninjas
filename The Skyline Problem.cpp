#include <bits/stdc++.h>

vector<vector<int>> getBuildingSkyline(vector<vector<int>>& buildings){

   vector<vector<int>>v;

       vector<pair<int,int>>p;

       for(auto x:buildings){

           p.push_back({x[0],-x[2]});

           p.push_back({x[1],x[2]});

       }

       sort(p.begin(),p.end());

       multiset<int,greater<int>>s;

       s.insert(0);

       int x=0;

       for(auto a:p){

           int c=a.first,d=a.second;

           if(d<0){

               s.insert(-d);

           }

           else{

               s.erase(s.find(d));

           }

           int e=*s.begin();

           if(x!=e){

               x=e;

               v.push_back({c,e});

           }

       }

       return v;

}
