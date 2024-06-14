/**
 * Extends the MaxHeap class to provide a priority queue
 * and implements the MyPriorityQueue interface
 * @author Daniel Rosales-Rodriguez
 */
public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface {
    @Override
    public void enqueue(Object task) {
        try{
            super.insert((Task) task);

        } catch (HeapException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Task dequeue() {
        try{
           return super.extractMax();
        } catch (HeapException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isEmpty() {return size == 0;}

    @Override
    public void update(int timeToIncrementPriority, int maxPriority) {
        for(int i = 0; i < super.size; i++){
            tasks[i].incrementWaitingTime();
            if(tasks[i].getWaitingTime() >= timeToIncrementPriority){
                tasks[i].resetWaitingTime();
                if(tasks[i].getPriority() < maxPriority){
                    tasks[i].setPriority(tasks[i].getPriority()+1);
                    try {
                        increaseKey(i, tasks[i]);
                    } catch (HeapException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }
}
