package IMUHERO;
import java.util.TreeMap;
class TrieLC208 {
    private class Node{
        boolean isWord;
        TreeMap<Character,Node>next;
        public Node(boolean isWord){
            this.isWord=isWord;
            next=new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }
    private int size;
    private Node root;

    /** Initialize your data structure here. */
    public TrieLC208() {
        root=new Node();
        size=0;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur=root;
        for (int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if (cur.next.get(c)==null){
                cur.next.put(c,new Node());
            }
            cur=cur.next.get(c);
        }
        if (!cur.isWord){
            cur.isWord=true;
            size++;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur=root;
        for (int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if (cur.next.get(c)!=null){
                cur=cur.next.get(c);
            }
            else return false;
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur=root;
        for (int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if (cur.next.get(c)==null){
                 return false;
            }
            cur=cur.next.get(c);
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