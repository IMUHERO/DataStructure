package IMUHERO;
import java.util.TreeMap;
public class Trie {
    //内部类，声明一个私有的节点，包含：isWord、next(Character,Node)
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

    public Trie(){
        root=new Node();
        size=0;
    }


    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(String word){
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
    //向字典树中插入元素的递归写法
    public void insert(String word){
        insert(word,0,root);
    }
    private void insert(String word,int index,Node node){
        if (index==word.length()&&!node.isWord){
            node.isWord=true;
            size++;
        }
        if (index==word.length())return;
        char c=word.charAt(index);
        if (node.next.get(c)==null){
            node.next.put(c,new Node());
        }
        insert(word,index+1,node.next.get(c));
    }


    public boolean contain(String word){
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

    //查询字典树中是否包含某个单词的递归写法
    public boolean cotainsII(String word){
        return cotainsII(word,0,root);
    }
    private boolean cotainsII(String word ,int index ,Node node){
        if (index==word.length())return node.isWord;
        char c=word.charAt(index);
        if (node.next.get(c)==null)return false;
        return cotainsII(word,index+1,node.next.get(c));
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
    //查询字典树中是否包含以某个字符串为前缀的单词
    public boolean startsWithII(String prefix){
        return startsWithII(prefix,0,root);
    }
    private boolean startsWithII(String prefix,int index,Node node){
        if (index==prefix.length())return true;
        char c=prefix.charAt(index);
        if (node.next.get(c)==null)return false;
        return startsWithII(prefix,index+1,node.next.get(c));
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    ////查询字典树中是否包含以某个字符串为前缀的单词，其中'.'可以代替任意一种字符
    public boolean search(String word){
        return search(word,0,root);
    }
    private boolean search(String word,int index,Node node){
        if (index==word.length())return true;
        char c=word.charAt(index);
        if (c!='.'){
            if (node.next.get(c)==null)return false;
            return search(word,index+1,node.next.get(c));
        }
        else {
            for (char nextChar:node.next.keySet()){
                if (search(word,index+1,node.next.get(nextChar))){
                    return true;
                }
            }
            return false;
        }
    }


}
