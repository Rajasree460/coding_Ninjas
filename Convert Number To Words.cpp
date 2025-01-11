#include <bits/stdc++.h> 

 

string numToWords(int n , string s){

  string unit[] = {"" ,       "one ",     "two ",       "three ",    "four ",

                   "five ",    "six ",     "seven ",     "eight ",    "nine ",

                   "ten ",     "eleven ",  "twelve ",    "thirteen ", "fourteen ",

                   "fifteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen "};

  string tens[] = {"" , "" ,     "twenty ",  "thirty ", "forty ",

                   "fifty ", "sixty ", "seventy ", "eighty ",  "ninety "};

 

  string str = "";

 

  if (n > 19) {

    str += tens[n / 10] + unit[n % 10];

    }

    else{

        str += unit[n] ;

    }

 

    if(n != 0){

        str += s ;

    }

 

    return str ;

}

 

string handleAll(int n)

{

    string ans = "" ;

 

    ans += numToWords(int(n / 10000000) , "crore ");

 

    ans += numToWords(int((n / 100000) % 100) , "lakh ");

 

    ans += numToWords(int((n / 1000) % 100 ) , "thousand ");

 

    ans += numToWords(int((n / 100) % 10) , "hundred ");

 

    if(n > 100 && (n % 100) > 0){

        ans +=  "and " ;

    }

 

    ans += numToWords(int(n%100) , "");

 

    return ans ;

}
