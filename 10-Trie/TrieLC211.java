package IMUHERO;

import java.util.TreeMap;
public class TrieLC211 {
    private class Node{
        private TreeMap<Character,Node>next;
        boolean isWord;
        public Node(boolean isWord){
            this.isWord=isWord;
            next=new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }
    Node root;

    /** Initialize your data structure here. */
    public TrieLC211() {
        root=new Node();
    }
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur=root;
        for (int i=0;i<word.length();i++){
            Character c=word.charAt(i);
            if (cur.next.get(c)==null){
                cur.next.put(c,new Node());
            }
            cur=cur.next.get(c);
        }
        cur.isWord=true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(root,word,0);
    }

    private boolean find(Node root,String word,int index){
        if (index==word.length()){
            return root.isWord;
        }
        char c=word.charAt(index);
        if (c!='.'){
            if (root.next.get(c)==null)return false;
            return find(root.next.get(c),word,index+1);
        }
        else{
            for(char nextChar:root.next.keySet()){
                if (find(root.next.get(nextChar),word,index+1))
                    return true;

            }
            return false;
        }

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */