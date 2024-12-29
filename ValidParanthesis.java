import java.util.Stack;
//Que-No. 32 leetcode hard question Longest Valid Paranthesis
class Solution {
    public int longestValidParentheses(String s) {
   Stack<Integer>st = new Stack();
   int max = 0;
   st.push(-1);
   for(int i = 0;i<s.length();i++){
      if(s.charAt(i) == '(')
      st.push(i);
      else{  
     st.pop();
        if(st.isEmpty()){
        st.push(i);
        }
    
        max  = Math.max(max,i-st.peek());
      }
     }
     return max;
   }
}
