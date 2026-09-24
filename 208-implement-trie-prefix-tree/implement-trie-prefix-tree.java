class Trie {
    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children = new TrieNode[26];

        TrieNode() {
            isEndOfWord = false;
        }
    }

    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
        // this.isEndOfWord = false;
        // for(int i=0;i<26;i++){
        //     children[i]=null;
        // }
    }
    
    public void insert(String word) {
        TrieNode crawl = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (crawl.children[ch - 'a'] == null) {
                crawl.children[ch - 'a'] = new TrieNode();
            }
            crawl = crawl.children[ch - 'a'];
        }
        crawl.isEndOfWord = true;
    }
    public boolean search(String word) {
        TrieNode crawl = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (crawl.children[ch - 'a'] == null) {
                return false;
            }
            crawl = crawl.children[ch - 'a'];
        }
        return crawl.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode crawl = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (crawl.children[ch - 'a'] == null) {
                return false;
            }
            crawl = crawl.children[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */