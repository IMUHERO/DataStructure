package IMUHERO;

public class LinkedListStack<E>implements Stack<E>{
        private LinkedList<E>stack;
        public LinkedListStack(){
            stack=new LinkedList<>();
        }
        @Override
        public int getSize(){
            return stack.getSize();
        }
        @Override
        public boolean isEmpty(){
            return stack.isEmpty();
        }
        @Override
        public void push(E e){
            stack.addFirst(e);
        }
        @Override
        public E pop(){
            return stack.removeFirst();
        }
        @Override
        public E peek(){
            return stack.getFirst();
        }

    @Override
    public String toString() {

            StringBuilder res = new StringBuilder();
            res.append("Stack: ");
            res.append("top：");
            res.append(stack);
            return res.toString();

    }
}
