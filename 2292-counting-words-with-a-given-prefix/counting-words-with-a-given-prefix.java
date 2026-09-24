class Solution {

    class TrieNode {
        int count;
        TrieNode[] children = new TrieNode[26];
        TrieNode() {
            count = 0;
        }
    }
    TrieNode root = new TrieNode();

    public int prefixCount(String[] words, String pref) {
        for (String word : words) {
            TrieNode crawl = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (crawl.children[ch - 'a'] == null) {
                    crawl.children[ch - 'a'] = new TrieNode();
                }
                crawl = crawl.children[ch - 'a'];
                crawl.count++;
            }
        }
    
        TrieNode crawl = root;
        for (int i = 0; i < pref.length(); i++) {
            char ch = pref.charAt(i);
            if (crawl.children[ch - 'a'] == null) {
                return 0;
            }
            crawl = crawl.children[ch - 'a'];
        }
        return crawl.count;
    }
}

