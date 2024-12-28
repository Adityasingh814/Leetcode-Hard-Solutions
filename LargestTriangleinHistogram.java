class LargestTriangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int prevSmall[] = findPrevSmall(heights);
       int nextSmall[] = findNextSmall(heights);
       int max = Integer.MIN_VALUE;
       for(int i = 0;i<heights.length;i++){
        int h = heights[i];
        int w = nextSmall[i] - prevSmall[i]-1;
        max = Math.max(max,(h*w));
       }
       return max;
    }
    public int[] findPrevSmall(int[] heights){
        Stack<Integer>st = new Stack<>();
        int result[] = new int[heights.length];
        for(int i = 0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                result[i] = -1;
            }else{
                 result[i] = st.peek();
            }
            st.push(i);
        }
        return result;
    }
        public int[] findNextSmall(int[] heights){
        Stack<Integer>st = new Stack<>();
        int result[] = new int[heights.length];
        for(int i = heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                result[i] = heights.length;
            }else{
                 result[i] = st.peek();
            }
            st.push(i);
        }
        return result;
    }
}