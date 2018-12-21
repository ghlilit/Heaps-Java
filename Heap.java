import java.util.ArrayList;

public class Heap {

    ArrayList<Integer> heap = new ArrayList();

    public Heap(){}

    public Heap(int[] array){
        for(int i = 0; i < array.length; i++){
            heap.add(array[i]);
            heapify();
        }
    }
    public boolean isEmpty(){
        return (heap.size() == 0);
    }

    public int size(){
        return  heap.size();
    }

    protected int parent(int j){
        return (j-1)/2;
    }

    protected int left(int j){
        return 2*j + 1;
    }

    protected int right(int j){
        return 2*j + 2;
    }

    protected boolean hasLeft(int j){
        return left(j) < size();
    }

    protected boolean hasRight(int j){
        return right(j) < size();
    }

    protected void swap(int i, int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    protected void upHeap(int j){
        while (j>0){
            int p = parent(j);
            if (heap.get(j) < heap.get(p)){
                break;
            }
            swap(j, p);
            j = p;
        }
    }

    protected void downHeap(int j){
        while(hasLeft(j)){
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (heap.get(leftIndex) < heap.get(rightIndex)) {
                    smallChildIndex = rightIndex;
                }
            }
                if(heap.get(smallChildIndex) < heap.get(j)){
                    break;
                }
                swap(smallChildIndex, j);
                j = smallChildIndex;
        }
    }

    protected void heapify() {
        int startIndex = parent(size() - 1);
        for (int j=startIndex; j >= 0; j--)
            downHeap(j);
    }

    public Integer min(){
        if(heap.isEmpty())
            return null;
        else
            return heap.get(0);
    }

    public void insert(Integer k){
        heap.add(k);
        upHeap(heap.size() -1);
    }

    public Integer removeMin(){
        if (heap.isEmpty())
            return null;
        Integer answer = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downHeap(0);
        return answer;
    }
}
