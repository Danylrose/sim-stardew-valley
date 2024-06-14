/**
 * Defines Task objects for MaxHeap
 * @author Daniel Rosales-Rodriguez
 */
public class Task implements TaskInterface, Comparable<Task> {

   public int priority;
   public int hourCreated;
   public String taskDescription;
   public int waitingTime;
   TaskInterface.TaskType taskType;

    /**
     * Overloaded constructor creates new task with a priority level,
     * task type, waiting time, and task description
     * @param priority - priority level
     * @param taskType - type of task (fishing, foraging, mining, etc.)
     * @param waitingTime - waiting time
     * @param taskDescription - description of task
     */
   Task(int priority, TaskInterface.TaskType taskType, int waitingTime, String taskDescription){
       this.priority = priority;
       this.taskType = taskType;
       this.waitingTime = waitingTime;
       this.taskDescription = taskDescription;
   }

    /**
     * Overloaded constructor creates new task based
     * on the hour created to compare tasks with
     * @param hourCreated - hour created
     * @param taskType - type of task (fishing, foraging, mining, etc.)
     * @param taskDescription - description of task
     */
   Task(int hourCreated, TaskInterface.TaskType taskType, String taskDescription){
       this.hourCreated = hourCreated;
       this.taskType = taskType;
       this.taskDescription = taskDescription;
   }

    /**
     * Overloaded constructor creates new task
     * and initializes its priority level
     * (Constructor meant for testing)
     * @param priority - priority level
     */
   Task(int priority){
       this.priority = priority;
   }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public TaskType getTaskType() {
        return this.taskType;
    }

    @Override
    public String getTaskDescription() {
        return taskDescription;
    }

    @Override
    public void incrementWaitingTime() {this.waitingTime++;}

    /**
     * Returns hourCreated. Implemented for testing.
     * @return - The hour created
     */
    public int getHourCreated(){ return this.hourCreated; }

    @Override
    public void resetWaitingTime() {
       this.waitingTime = 0;
    }

    @Override
    public int getWaitingTime() {
        return this.waitingTime;
    }

    @Override
    public int compareTo(Task o) {

       if(this.getPriority() > o.getPriority()){
        return 1;
       }
       else if(this.getPriority() < o.getPriority()){
           return -1;
       }
       else if (this.getPriority() == o.getPriority()){
           if(this.hourCreated < o.hourCreated){
               return 1;
           }
           else if(this.hourCreated > o.hourCreated){
               return -1;
           }
       }
       return 0;
    }

    /**
     * Outputs task type, task description, and hour created.
     * @return - String
     */
    public String toString(){
        return this.getTaskType() + " " + this.getTaskDescription() + " at Hour: "  + (this.hourCreated + this.waitingTime) + ":00";
    }
}
