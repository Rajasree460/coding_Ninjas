public class Solution {
    public static int createAtoi(String str) {
        int sign = 1;
        int num = 0;
        int n = str.length();
        int i =0;
        
        while(i<n && str.charAt(i) == ' '){i++;}
        
        if(i<n && str.charAt(i) == '+')i++;
        else if(i<n && str.charAt(i) == '-'){
            sign = -1;
            i++;
        }
      

        while(i<n && str.charAt(i) >='0' && str.charAt(i)<='9'){
            if(num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10
            && str.charAt(i) == '7')){
                if(sign == 1)return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            num = num*10 + (str.charAt(i)-'0');
            i++;
        }
        return num*sign;
    }
}
