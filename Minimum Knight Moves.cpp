#include<bits/stdc++.h>

 

int minimumKnightMoves(int x, int y) {

    x=abs(x);

    y=abs(y);

 

    if(x>y){

        swap(x,y);

    }

 

    if(x==0 && y==1){

        return 3;

    }

    if(x==1 && y==1){

        return 2;

    }

    

    if(y>=2*x){

        return (y + 1)/2 + (y/2 - x)%2;

    }

 

    return (x+y)/3 + (x+y)%3;

}
