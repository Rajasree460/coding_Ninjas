import java.util.* ;

 import java.io.*;

 

public class Solution {

 private static Set<String> validExpression = new HashSet<>();

 static void recurse(String s,int index,int leftCount,int rightCount,int leftRem,int rightRem,StringBuilder expression) {

  if (index==s.length()) {   if (leftRem==0 && rightRem==0) {

    validExpression.add(expression.toString());

   } 

 } else {   

char character = s.charAt(index);

   int length = expression.length();

   if ((character=='(' && leftRem>0) || (character==')' && rightRem>0)) {

    recurse(s, index+1, leftCount, rightCount, leftRem-(character=='('?1:0), rightRem-(character==')'?1:0), expression);

   } 

  expression.append(character);

   if (character!='(' && character!=')') {

    recurse(s, index+1, leftCount, rightCount, leftRem, rightRem, expression);

   } else if (character=='(') {    

recurse(s, index+1, leftCount+1, rightCount, leftRem, rightRem, expression);

   } else if (rightCount<leftCount) {    

recurse(s, index+1, leftCount, rightCount+1, leftRem, rightRem, expression);

   }   

expression.deleteCharAt(length); 

 } 

}

 public static ArrayList<String> removeInvalidParentheses(String str) {  

// Write your code here.

  validExpression.clear(); 

 int left = 0; 

 int right= 0; 

 for (int i=0;i<str.length();i++) { 

  if (str.charAt(i)=='(') {  

  left++; 

  } else if (str.charAt(i)==')') {  

  right = left==0?right+1:right;

    left = left>0?left-1:left;

   }

  }  

recurse(str,0,0,0,left,right,new StringBuilder());

  return new ArrayList<String>(validExpression);

 }

 }  
