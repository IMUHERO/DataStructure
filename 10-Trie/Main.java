package IMUHERO;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Trie trie=new Trie();
        trie.add("pan");
        trie.add("pandan");
        System.out.println(trie.startsWithII("pa"));
        System.out.println(trie.search("panda."));
    }
}
