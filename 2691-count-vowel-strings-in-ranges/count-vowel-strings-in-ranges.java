class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n];
        for(int i = 0; i < n; i++) {
            String w = words[i];
            if(isVowel(w.charAt(0)) && isVowel(w.charAt(w.length()-1))) {
                prefix[i] = (i == 0 ? 1 : prefix[i-1] + 1);
            } else {
                prefix[i] = (i == 0 ? 0 : prefix[i-1]);
            }
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if(l == 0) {
                ans[i] = prefix[r];
            } else {
                ans[i] = prefix[r] - prefix[l-1];
            }
        }
        return ans;
    }
    boolean isVowel(char c) {
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}