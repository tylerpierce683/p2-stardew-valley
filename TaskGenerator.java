/**
 * @author Tyler Pierce
 *
 */
public class TaskGenerator implements TaskGeneratorInterface {

	private int currentEnergyStorage;
	private double taskGenerationProbability;
	private long seed;
	
	public TaskGenerator(double taskGenerationProbability, long seed) {
		this.currentEnergyStorage = DEFAULT_ENERGY;
		this.taskGenerationProbability = taskGenerationProbability;
		this.seed = seed;
	}
	
	public TaskGenerator(double taskGenerationProbability) {
		currentEnergyStorage = DEFAULT_ENERGY;
		this.taskGenerationProbability = taskGenerationProbability;
	}
	
	@Override
	public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
		Task newTask = new Task(hourCreated, taskType, taskDescription);
		return newTask;
	}

	@Override
	public void decrementEnergyStorage(TaskInterface.TaskType taskType) {
		this.currentEnergyStorage -= taskType.getEnergyPerHour();
	}

	@Override
	public void resetCurrentEnergyStorage() {
		this.currentEnergyStorage = DEFAULT_ENERGY;

	}

	@Override
	public int getCurrentEnergyStorage() {
		return this.currentEnergyStorage;
	}

	@Override
	public void setCurrentEnergyStorage(int newEnergyNum) {
		this.currentEnergyStorage = newEnergyNum;
	}

	@Override
	public boolean generateTask() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getUnlucky(Task task, double unluckyProbability) {
		if ()
		
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString(Task task, Task.TaskType taskType) {
        if(taskType == Task.TaskType.MINING) {
            return "     Mining " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.FISHING) {
            return "     Fishing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == Task.TaskType.FARM_MAINTENANCE) {
            return "     Farm Maintenance " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.FORAGING) {
            return "     Foraging " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
        }
        if(taskType == Task.TaskType.FEEDING) {
            return "     Feeding " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        if(taskType == Task.TaskType.SOCIALIZING) {
            return "     Socializing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
        }
        else { return "nothing to see here..."; }
	}

}
