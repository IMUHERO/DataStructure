package IMUHERO;
import java.util.ArrayList;
public class LinkedListSet<E> implements Set<E> {
   LinkedList<E>linkedList;
   LinkedListSet(){
       linkedList=new LinkedList<>();
   }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
    @Override
    public boolean contains(E e){
       return linkedList.contains(e);
    }

    @Override
    public void add(E e) {
        if (linkedList.contains(e))return;
        else linkedList.addFirst(e);
    }

    @Override
    public int getSize() {
        return  linkedList.getSize();
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            LinkedListSet<String> set1 = new LinkedListSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("a-tale-of-two-cities.txt", words2)){
            System.out.println("Total words: " + words2.size());

            LinkedListSet<String> set2 = new LinkedListSet<>();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}
