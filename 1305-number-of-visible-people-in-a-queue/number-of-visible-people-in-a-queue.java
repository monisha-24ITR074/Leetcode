class Solution {
    public int[] canSeePersonsCount(int[] arr) { // int[] height
        int n = arr.length;
        int[] ans = new int[n];
        Stack <Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            int count=0;
            while(!st.isEmpty() && st.peek() < arr[i]){
                st.pop();
                count++;
            }
            if(!st.isEmpty()){
                count++;
            }
            ans[i]=count;
            st.push(arr[i]);
        }
        return ans;
    }
}