class Solution {
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        backtrack(0,digits,"",ans);
        return ans;
    }
    private void backtrack(int index,String digits,String curr,List<String> ans){
        if(index==digits.length()){
            ans.add(curr);
            return;
        }
        String letters = map[digits.charAt(index)-'0'];
        for(char ch : letters.toCharArray()){
            String next = curr + ch;
            backtrack(index + 1,digits,next,ans);
        }
    }
}