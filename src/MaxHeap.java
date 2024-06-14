import java.util.Arrays;

/**
 * MaxHeap defines a max-heap
 * using an array of task objects
 * @author Daniel Rosales-Rodriguez
 */
public class MaxHeap {

    protected Task[] tasks;
    public int size;

    /**
     * Constructor creates empty heap
     */
    MaxHeap(){ // This is the only constructor that gets used
        size = 0;
        this.tasks = new Task[50];
    }

    /**
     * Overloaded constructor creates heap array
     * @param tasks - Task object
     */
    MaxHeap(Task [] tasks){

        size = tasks.length;
        buildMaxHeap();
    }

    /**
     * Parent node for heap array
     * @param child - Index for parent node
     * @return - Index of parent node
     */
    public int parent(int child) { return (child - 1)/2; }

    /**
     * Left child node for heap array
     * @param parent - Index for child node
     * @return - Index of child node
     */

    public int left(int parent) { return 2*parent+1; }

    /**
     * Right child node for heap array
     * @param parent - Index for child node
     * @return - Index of child node
     */
    public int right(int parent){
        return 2*parent+2;
    }

    /**
     * Heapify checks for value of nodes
     * and maintains Max-Heap property
     * @param idx - Index
     */
    public void heapify(int idx){
        int left = left(idx);
        int right = right(idx);
        int largest;
        // checks if left node is greater than current task
        if(left < size && tasks[left].compareTo(tasks[idx]) > 0){
            largest = left;
        }
        else{
            largest = idx;
        }
        // checks if right node is greater than larger task
        if(right < size && tasks[right].compareTo(tasks[largest]) > 0){
            largest = right;
        }
        // checks if largest value corresponds to index
        if(largest != idx){
            swap(idx, largest);
            heapify(idx);
        }
    }

    /**
     * Task at index zero is returned
     * @return - First task in heap array
     * @throws HeapException - Throws exception
     * when size of heap is zero
     */
    public Task max() throws HeapException {
        if (size < 1) throw new HeapException("Heap underflow");
        else{
            return tasks[0];
        }
    }

    /**
     * Extracts task at root of the heap array
     * @return - Task with the highest priority in heap array
     * @throws HeapException - Throws exception from max()
     */
    public Task extractMax() throws HeapException{
        Task max = max();
        tasks[0] = tasks[size - 1];
        size -= 1;
        heapify(0);
        return max;
    }

    /**
     * Inserts new task to array
     * @param task - Task
     * @throws HeapException - Throws exception from increaseKey
     */
    public void insert(Task task) throws HeapException{
        if(size == tasks.length) tasks = Arrays.copyOf(tasks, tasks.length*2);
        size += 1;
        tasks[size-1] = task;
        increaseKey(size-1, task);
    }

    /**
     * Compares index values and swaps position of objects
     * and increases its priority level in the array
     * @param idx - Index
     * @param task - Task
     * @throws HeapException - Throws exception if index is greater than size of array
     */
    public void increaseKey(int idx, Task task) throws HeapException{
        if(idx >= size){
            throw new HeapException("Index greater than current size.");
        }
        // checks if parent index is less than current task
        while(idx > 0 && tasks[parent(idx)].compareTo(tasks[idx]) < 0){
            swap(idx, parent(idx));
            idx = parent(idx);
        }
    }

    /**
     * Iterates through array and builds max-heap property
     */
    public void buildMaxHeap(){
        // iterates through heap array and heapifies
        for(int idx = (size/2)-1; idx >= 0; idx--){
           heapify(idx);
        }
    }

    /**
     * Swap exchanges task array objects
     * @param idx - Index
     * @param pIdx - Parent index
     */
    public void swap(int idx, int pIdx){
            Task temp = tasks[idx];
            tasks[idx] = tasks[pIdx];
            tasks[pIdx] = temp;
    }

    /**
     * Boolean checks for heap size.
     * @return - empty heap
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Iterates through array list and returns position of index
     * @param task - Task
     * @return - Index
     */
    public int getIndex(Task task){
        int j = -1;
        // iterates through length of array
        for(int i = 0; i < size; i++){
            // checks and compares tasks based on hour created
            if(tasks[i].getHourCreated() == task.getHourCreated()){
                j = i;
                break;
            }
        }
        return j;
    }
}
