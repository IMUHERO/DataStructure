package IMUHERO;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
public class BST <E extends Comparable<E>>{

    private class Node{
        public E e;
        public Node left;
        public Node right;
        public Node(E e){
            this.e=e;
            this.left=null;
            this.right=null;
        }
    }

    private Node root;
    private int size;
    public BST(){
        root=null;
        size=0;
    }
    //判断二叉树是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //获得二叉树元素的个数
    public int getSize(){
        return size;
    }
    //在二叉树中添加元素（自动按照大小排序）
    public void add(E e){
        root=add(root,e);
    }
    private Node add(Node node,E e){
        if(node==null){
            size++;
            return new Node(e);
        }
        else if (e.compareTo(node.e)<0)node.left=add(node.left,e);//此处注意：要把当前节点的左边引用指向新增的节点
        else node.right=add(node.right,e);
        return node;
    }

    //判断二叉树中是否含有e
    public boolean contian(E e){
        return contain(root,e);
    }

    public boolean contain(Node node,E e){
        if (node==null)return false;
        else if (e.compareTo(node.e)<0)return contain(node.left,e);
        else if (e.compareTo(node.e)==0)return true;
        else return contain(node.right,e);
    }
    //前序遍历
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if (node==null)return ;
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
    }
    //非递归算法
    public void preOrderNR(){

    if(root == null)
        return;

    Stack<Node> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()){
        Node cur = stack.pop();
        System.out.println(cur.e);

        if(cur.right != null)
            stack.push(cur.right);
        if(cur.left != null)
            stack.push(cur.left);
    }
}
    //中序遍历
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if (node==null)return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
    //后序遍历
    public void  postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if (node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
    //层序遍历
    public void levelOrder(){
        Queue <Node>lel=new LinkedList<>();
        if (root==null)return;
        lel.add(root);
        while (!lel.isEmpty()){
            Node cur=lel.remove();
            System.out.println(cur.e);
            if (cur.left!=null)lel.add(cur.left);
            if (cur.right!=null)lel.add(cur.right);
        }
    }

    // 寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        Node minNode = minimum(root);
        return minNode.e;
    }
    private Node minimum(Node node){
        if( node.left == null )
            return node;

        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }
    private Node maximum(Node node){
        if( node.right == null )
            return node;

        return maximum(node.right);
    }

    //删除二叉树中的最小值
    public E delMin(){
        Node ret=minimum(root);
        root=delMin(root);
        return ret.e;
    }
    private Node delMin(Node node){
        if (root==null)throw new IllegalArgumentException("the tree is empty!");
        if (node.left==null){
            Node reRight=node.right;
            node.right=null;
            return reRight;
        }
        else {
            node.left=delMin(node.left);
        }
        return node;
    }

    //删除二叉树中的最大值
    public E delMax(){
        Node ret=maximum(root);
        root=delMax(root);
        return ret.e;
    }
    private Node delMax(Node node){
        if (isEmpty())throw new IllegalArgumentException("the tree is empty!");
        if (node.right==null){
            Node reLeft=node.left;
            node.left=null;
            return reLeft;
        }
        else{
            node.right=delMax(node.right);
            return node;
        }


    }

    //删除二叉树中的元素e
    public void delElement(E e){
        root=delElement(root,e);
    }
    private Node delElement(Node node,E e){
        if (root==null)throw new IllegalArgumentException("the tree is empty!");
        if (e.compareTo(node.e)<0){
            node.left=delElement(node.left,e);
            return node;
        }
        else if (e.compareTo(node.e)>0){
            node.right=delElement(node.right,e);
            return node;
        }
        else {//e.compareTo(node.e==0)
            //如果待删除节点的左子树为空（左右子树都为空会在这种情况被处理掉）
            if(node.left==null){
                Node reRight=node.right; //用于返回的当前节点的右子树存入reRight中(是空的也没事)；
                node.right=null;//释放node节点的空间
                size--;
                return reRight;
            }
            //如果待删除节点的右子树为空，情况与左子树为空相似
            if (node.right==null){
                Node reLeft=node.left;
                node.left=null;
                size--;
                return reLeft;
            }
            //当前节点的左右子树都不为空的情况
            Node successor=minimum(node.right);//能够用于继承当前节点位置的继承节点
            //Node successor=maxmum(node.left)：可以有两种情况，以右子节点为根的树的最小值，或者以左子节点为根的树的最大值
            successor.left=node.left;
            successor.right=delMin(node.right);//此处的size已经自动-1了；
            node.left=null;
            node.right=null;
            return successor;
        }
    }

}
