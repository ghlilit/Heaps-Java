import java.util.Iterator;
import java.util.LinkedList;

public class LinkedBinaryTree<V>{


    public TNode<V> createNode(Entry<V> element, TNode<V> parent, TNode<V> left, TNode<V> right){
        return new TNode<V>(element, parent, left, right);
    }
    protected TNode<V> root = null;
    protected int size = 0;

    public LinkedBinaryTree(){};

    public int size() {
        return size;
    }
    public TNode<V> root() {
        return root;
    }
    public void setRoot(TNode<V> root) {
        this.root = root;
    }
    public void addLeft(TNode<V> parent, Entry<V> element){
        parent.setLeft(createNode(element, parent, null, null));
    }
    public void addRIght(TNode<V> parent, Entry<V> e){
        parent.setRight(createNode(e, parent, null, null));
    }

    //If the node is in the tree returns it, else returns the parent where it is supposed to be
    public TNode<V> binarySearch(int k, TNode<V> node){
        int t = node.getElement().getK();
        if(k == t){
                return node;
        }
        else if(k<t){
            if (node.getLeft() == null)
                return node;
            else
                return binarySearch(k, node.getLeft());
        }
        else{
            if (node.getRight() == null) {
                return node;
            }
            else {
                return binarySearch(k, node.getRight());
            }
        }
    }

    //If the returned node from the function above is the node itself returns it, else sets it left or right according to parent value
    public Entry<V> insert(Entry<V> newEntry){
        if(root == null){
            this.root = createNode(newEntry, null, null, null);
            return null;
        }
        TNode result = binarySearch(newEntry.getK(),root);
        if(result.getElement().getK() == newEntry.getK()){
            return newEntry;
        }
        if(result.getElement().getK() < newEntry.getK()){
            TNode newNode = createNode(newEntry, result, null, null);
            result.setRight(newNode);
        }
        if(result.getElement().getK() > newEntry.getK()){
            TNode newNode = createNode(newEntry, result, null, null);
            result.setLeft(newNode);
        }
        return null;
    }

    public Entry<V> remove(int k){
        if(root == null){
            System.out.println("Nothing to remove");
            return null;
        }

        TNode result = binarySearch(k,root);
        //found the Element
        if(result.getElement().getK() == k){
            if(result.getRight()!= null && result.getLeft()!=null){
                System.out.println("Has two kids");
                return null;
            }
            //if only has a right child sets the child's parent value to its grandparent
            else if(result.getLeft()!=null){
                result.getLeft().setParent(result.getParent());
                if (result.getParent().getRight() == result){
                    result.getParent().setRight(result.getLeft());
                }
                else{
                    result.getParent().setLeft(result.getLeft());
                }
                System.out.println("Removed");
                return result.getElement();
            }
            //if only has a right child sets the child's parent value to its grandparent
            //Also checks if it is its parent's left or right child and sets its parent's child accordingly to its child
            else if(result.getRight()!=null) {
                result.getRight().setParent(result.getParent());
                if (result.getParent().getRight() == result){
                    result.getParent().setRight(result.getRight());
                }
                else{
                    result.getParent().setLeft(result.getRight());
                }
                System.out.println("Removed");
                return result.getElement();
            }
            else{
                System.out.println("Removed");
                result = null;
                return result.getElement();
            }
        }
        //if the result from the binarySearch is not the node itself
        else{
            System.out.println("The element does not exist in the tree");
            return null;
        }
    }

    public iterateRow iterator(){
        return new iterateRow();
    }

    public class iterateRow{
        LinkedList<TNode<V>> row = new LinkedList<TNode<V>>();
        int j = 0;
        boolean start = true;
        //if we are at the beginning add the root
        public Entry next(){
            if (start == true){
                row.add(root);
                start =false;
            }
            if(j < row.size()) {
                Entry next = row.get(j).getElement();
                j++;
                return next;
            }

            //if no elements left in this row, move to the next one
            else {
                LinkedList<TNode<V>> nextRow = new LinkedList<TNode<V>>();
                for (int i = 0; i < row.size(); i++){
                    if (row.get(i).getLeft()!= null){
                        nextRow.add(row.get(i).getLeft());
                    }
                    if (row.get(i).getRight()!= null){
                        nextRow.add(row.get(i).getRight());
                    }
                }
                //if new elements were added the the next row becomes the row, returns the first element
                if (nextRow.size()!=0){
                    row = nextRow;
                    Entry next = nextRow.get(0).getElement();
                    j=1;
                    return next;
                }
                //if no elements were added the tree is empty
                else {
                    return null;
                }
            }
        }

    }
}
