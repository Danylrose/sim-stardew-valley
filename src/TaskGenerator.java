import java.util.Random;

/**
 * Implements TaskGeneratorInterface and contains the new Task generations, the farmer’s energy storage,
 * and the probability of passing-out or dying while completing a task. TaskGenerator randomly generates
 * Tasks at the current hour with a priority of 0, with the generation decided by the given probability.
 * @author Daniel Rosales-Rodriguez
 */
public class TaskGenerator implements TaskGeneratorInterface{
    double probability;
    int energy;
    Random generator;

    /**
     * Overloaded constructor allows for
     * creation of a task generator with
     * probability
     * @param probability - probability
     */
    TaskGenerator(double probability){
        this.probability = probability;
        this.energy = DEFAULT_ENERGY;
        generator = new Random();
    }

    /**
     * Overloaded constructor allows for
     * creation of a task generator with
     * probability and an optional seed
     * generator
     * @param probability - probability
     * @param seed - seed
     */
    TaskGenerator(double probability, long seed){
        this.probability = probability;
        this.energy = DEFAULT_ENERGY;
        generator = new Random(seed);
    }

    @Override
    public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
        return new Task(hourCreated, taskType, taskDescription);
    }

    @Override
    public void decrementEnergyStorage(Task.TaskType taskType) {
        this.energy = this.getCurrentEnergyStorage() - taskType.getEnergyPerHour();
    }

    @Override
    public void resetCurrentEnergyStorage() {
        this.energy = DEFAULT_ENERGY;
    }

    @Override
    public int getCurrentEnergyStorage() {
        return this.energy;
    }

    @Override
    public void setCurrentEnergyStorage(int newEnergyNum) {
        this.energy = newEnergyNum;
    }

    @Override
    public boolean generateTask() {
        return generator.nextDouble() < probability;
    }

    @Override
    public int getUnlucky(Task task, double unluckyProbability) {
        double dyingProbability = task.getTaskType().getDyingProbability();
        double passOutProbability = task.getTaskType().getPassingOutProbability();
        boolean isMining = task.getTaskType().equals(TaskInterface.TaskType.MINING);
        if(unluckyProbability <= passOutProbability){
            if(unluckyProbability <= dyingProbability && isMining){
                energy -= (energy*3)/4;
                task.setPriority(0);
                return DEATH;
            }
            else{
                energy = (energy/2);
                return PASSED_OUT;
            }
        }
        return SURVIVED;
    }

    @Override
    public String toString(Task task, Task.TaskType taskType) {
        if(taskType == Task.TaskType.MINING) {
            return "     Mining " + task.getTaskDescription() + " at " + getCurrentEnergyStorage() + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.FISHING) {
            return "     Fishing " + task.getTaskDescription() + " at " + getCurrentEnergyStorage() + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == Task.TaskType.FARM_MAINTENANCE) {
            return "     Farm Maintenance " + task.getTaskDescription() + " at " + getCurrentEnergyStorage() + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.FORAGING) {
            return "     Foraging " + task.getTaskDescription() + " at " + getCurrentEnergyStorage() + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == Task.TaskType.FEEDING) {
            return "     Feeding " + task.getTaskDescription() + " at " + getCurrentEnergyStorage() + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.SOCIALIZING) {
            return "     Socializing " + task.getTaskDescription() + " at " + getCurrentEnergyStorage() + " energy points (Priority:" + task.getPriority() +")";
        }
        else { return "nothing to see here..."; }
    }
}
