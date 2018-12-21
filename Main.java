import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void KMax(int[] arr, int k) {
        Heap newHeap = new Heap(arr);

        for(int i =0; i<k; i++) {
            System.out.println(newHeap.removeMin());
        }
    }

    public static void main(String[] args) {
        int[] intArray = new int[]{1, 6, -12, 12, 25, 17, -30, 0, 10};
        KMax(intArray,3);

        System.out.println("End of ex1");
        Entry a = new Entry(1, "A");
        Entry c = new Entry(-12, "C");
        Entry b = new Entry(4, "C");
        Entry j = new Entry(5, "J");
        Entry a2 = new Entry(14, "A");
        Entry d = new Entry(-3, "D");
        Entry t = new Entry(5, "T");
        Entry k = new Entry(10, "K");
        Entry c2 = new Entry(6, "C");
        Entry p = new Entry(8, "P");
        Entry q = new Entry(20, "Q");

        LinkedBinaryTree trial = new LinkedBinaryTree();

        trial.insert(a);
        trial.insert(c);
        trial.insert(j);
        trial.insert(b);
        trial.insert(a2);
        trial.insert(d);
        trial.insert(t);
        trial.insert(k);
        trial.insert(c2);
        trial.insert(p);
        trial.insert(q);

        LinkedBinaryTree.iterateRow iter = trial.iterator();

        System.out.println("This thing prints it row by row: Inherited from last hw");
        for (int i = 0; i < 10; i++) {
            System.out.println(iter.next().getK());
        }

        System.out.println("End of ex2");

        trial.remove(-12);
        trial.remove(14);

    }
}
