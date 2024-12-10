#include <bits/stdc++.h> 

int gameSpace(int h, int a) {

    int turn = 0;

    while(1){

      if(turn%2==0){

        h+=3;

        a+=2;

        turn+=1;

        

      }

      else{

        if(h>4 && a>8){

          h-=4;

          a-=8;

          turn+=1;

   

        }

        else if(h>10){

          h-=10;

          a+=5;

          turn+=1;

          

        }

        else{

          break;

        }

      }

      

    }

    return turn;

}
