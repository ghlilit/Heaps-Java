import java.util.ArrayList;

public class TNode<V> {
    private Entry<V> element;
    private boolean roman = false;
    private TNode<V> parent;
    private TNode<V> left;
    private TNode<V> right;

    public TNode(Entry<V> element, TNode<V> parent, TNode<V> left, TNode<V> right){
        this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public Entry<V> getElement() {
        return element;
    }

    public TNode<V> getParent() {
        return parent;
    }

    public TNode<V> getLeft() {
        return left;
    }

    public TNode<V> getRight() {
        return right;
    }

    public void setEntry(Entry<V> element) {
        this.element = element;
    }

    public void setParent(TNode<V> parent) {
        this.parent = parent;
    }

    public void setLeft(TNode<V> left) {
        this.left = left;
    }

    public void setRight(TNode<V> right) {
        this.right = right;
    }
}
