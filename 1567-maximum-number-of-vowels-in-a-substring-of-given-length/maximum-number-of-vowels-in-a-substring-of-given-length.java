class Solution {
    public int maxVowels(String s, int k) {
        int vowel=0;
        for(int i=0;i<k;i++){
        if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
            vowel++;
            }
        }
        int max=vowel;
        for(int i=k;i<s.length();i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
            vowel++;
            }
            if(s.charAt(i-k)=='a' || s.charAt(i-k)=='e' || s.charAt(i-k)=='i' || s.charAt(i-k)=='o' || s.charAt(i-k)=='u'){
            vowel--;
            }
            max=Math.max(max,vowel); 
        }
        return max;
    }
}