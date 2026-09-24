class Solution {
    class TrieNode{
        boolean isEndOfWord;
        TrieNode[] children = new TrieNode[26];
        TrieNode(){
            isEndOfWord=false;
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    TrieNode root;

    public void insert(String word){
        TrieNode crawl = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(crawl.children[ch-'a']==null) crawl.children[ch-'a']=new TrieNode();
            crawl = crawl.children[ch-'a'];
        }
        crawl.isEndOfWord=true;
    }
    public String search(String word){
        TrieNode crawl = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(crawl.children[ch-'a']==null) return word;
            crawl = crawl.children[ch-'a'];
            if(crawl.isEndOfWord == true){
                return word.substring(0,i+1);
            }
        }
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new TrieNode();
        for(String word: dictionary) insert(word);
        String[] words=sentence.split(" ");
        for(int i=0;i<words.length;i++){
            String replacement=search(words[i]);
            words[i] = replacement;
        }
        StringBuilder result=new StringBuilder("");
        for(String word:words){
            result.append(word);
            result.append(" ");
        }
        result=result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}