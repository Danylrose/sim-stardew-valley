import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit testing for MaxHeap
 * @author Daniel Rosales-Rodriguez
 */
class MaxHeapTest {

    Task [] task;
    @Test
    void HeapEmptyTrueTest(){
        MaxHeap heap = new MaxHeap();
        heap.isEmpty();
        assertTrue(true);
    }

    @Test
    void insertTaskTest() throws HeapException{
        MaxHeap heap = new MaxHeap();
        Task task1 = new Task(1, TaskInterface.TaskType.FORAGING, 4, "");
        Task task2 = new Task(3, TaskInterface.TaskType.FEEDING, 2, "");
        heap.insert(task2);
        heap.insert(task1);
        assertEquals(0, heap.getIndex(task2));
    }

    @Test
    void extractMaxTest1() throws HeapException {
        MaxHeap heap = new MaxHeap();
        Task task1 = new Task(1, TaskInterface.TaskType.FORAGING, 4, "");
        Task task2 = new Task(3, TaskInterface.TaskType.FEEDING, 2, "");
        heap.insert(task2);
        heap.insert(task1);
        heap.extractMax();
        heap.extractMax();
    }

    @Test
    void extractMaxTest2() throws HeapException {
        MaxHeap heap = new MaxHeap();
        Task task1 = new Task(1, TaskInterface.TaskType.FORAGING, 4, "");
        Task task2 = new Task(3, TaskInterface.TaskType.FEEDING, 2, "");
        Task task3 = new Task(4, TaskInterface.TaskType.FARM_MAINTENANCE, 1, "");
        heap.insert(task2);
        heap.insert(task1);
        heap.insert(task3);
        heap.extractMax();
        heap.extractMax();
        heap.extractMax();
    }

    @Test
    void increaseKeyTest1() throws HeapException{
        MaxHeap heap = new MaxHeap();
        Task task1 = new Task(3,TaskInterface.TaskType.FORAGING, 4, "");
        Task task2 = new Task(2, TaskInterface.TaskType.FARM_MAINTENANCE, 1, "");
        heap.insert(task2);
        heap.insert(task1);
        task1.setPriority(4);
        heap.increaseKey(1, task1);
        assertEquals(0, heap.getIndex(task1));
    }

    @Test
    void increaseKeyTest2() throws HeapException{
        MaxHeap heap = new MaxHeap();
        Task task1 = new Task(3,TaskInterface.TaskType.FORAGING, 4, "");
        Task task2 = new Task(2, TaskInterface.TaskType.FARM_MAINTENANCE, 1, "");
        Task task3 = new Task(4, TaskInterface.TaskType.FISHING, 3, "");
        heap.insert(task3);
        heap.insert(task2);
        heap.insert(task1);
        task1.setPriority(5);
        heap.increaseKey(1, task1);
        assertEquals(0, heap.getIndex(task1));
    }

    @Test
    void checkIfMaxHeapTest1() throws HeapException {
        MaxHeap heap = new MaxHeap();
        Task task1 = new Task(3,TaskInterface.TaskType.FORAGING, 4, "");
        Task task2 = new Task(2, TaskInterface.TaskType.FARM_MAINTENANCE, 1, "");
        Task task3 = new Task(4, TaskInterface.TaskType.FISHING, 3, "");
        heap.insert(task1);
        heap.insert(task2);
        heap.insert(task3);
        heap.extractMax();
        heap.extractMax();
        heap.extractMax();
        boolean isMaxHeap = this.isMaxHeapified(heap);
        assertTrue(isMaxHeap);
    }

    @Test
    void checkIfSortedTest1() throws HeapException {
        MaxHeap heap = new MaxHeap();
        Task task1, task2, task3;
        task1 = new Task(1);
        task2 = new Task(2);
        task3 = new Task(3);
        heap.insert(task1);
        heap.insert(task2);
        heap.insert(task3);
        heap.extractMax();
        heap.extractMax();
        heap.extractMax();
        boolean heapSorted = this.heapIsSorted(heap);
        assertTrue(heapSorted);
    }


    @Test
    void insertAscendingTest() throws HeapException {
        MaxHeap heap = new MaxHeap();
        Task task1 = new Task(1);
        Task task2 = new Task(2);
        Task task3 = new Task(3);
        Task task4 = new Task(4);
        heap.insert(task1);
        heap.insert(task2);
        heap.insert(task3);
        heap.insert(task4);
        boolean isMaxHeap = this.isMaxHeapified(heap);
        assertTrue(isMaxHeap);
        heap.extractMax();
        heap.extractMax();
        heap.extractMax();
        heap.extractMax();
        boolean heapSorted = this.heapIsSorted(heap);
        assertTrue(heapSorted);
    }

    @Test
    void insertDescendingTest() throws HeapException {
        MaxHeap heap = new MaxHeap();
        Task task1 = new Task(4);
        Task task2 = new Task(3);
        Task task3 = new Task(2);
        Task task4 = new Task(1);
        heap.insert(task1);
        heap.insert(task2);
        heap.insert(task3);
        heap.insert(task4);
        boolean isMaxHeap = this.isMaxHeapified(heap);
        assertTrue(isMaxHeap);
        heap.extractMax();
        heap.extractMax();
        heap.extractMax();
        heap.extractMax();
        boolean heapSorted = this.heapIsSorted(heap);
        assertTrue(heapSorted);
    }

    @Test
    void insertRandomTest() throws HeapException {
        MaxHeap heap = new MaxHeap();
        Task task1 = new Task(4);
        Task task2 = new Task(2);
        Task task3 = new Task(1);
        Task task4 = new Task(5);
        Task task5 = new Task(7);
        Task task6 = new Task(9);
        Task task7 = new Task(8);
        heap.insert(task4);
        heap.insert(task3);
        heap.insert(task2);
        heap.insert(task1);
        heap.insert(task5);
        heap.insert(task7);
        heap.insert(task6);
        boolean isMaxHeap = this.isMaxHeapified(heap);
        assertTrue(isMaxHeap);
        heap.extractMax();
        heap.extractMax();
        heap.extractMax();
        heap.extractMax();
        heap.extractMax();
        heap.extractMax();
        heap.extractMax();
        boolean heapSorted = this.heapIsSorted(heap);
        assertTrue(heapSorted);
    }

    /**
     * Helper function returns boolean
     * value and determines whether
     * Max-Heap property is satisfied
     * @param heap - heap object
     * @return - boolean value
     */
    public boolean isMaxHeapified(MaxHeap heap){
        for(int i = 0; i < heap.size; i++){
            if(task != null) {
                if (task[heap.parent(i)].compareTo(task[i]) < 0) { // previous value in task array was i
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Helper function returns boolean
     * value and determines whether
     * Max-Heap is sorted (according
     * to the property)
     * @param heap - MaxHeap object
     * @return - boolean value
     */
    public boolean heapIsSorted(MaxHeap heap){
        for(int i = 0; i < heap.size - 1; i++){
            if(task[i].compareTo(task[i+1]) < 0){
                return false;
            }
        }
        return true;
    }
}
