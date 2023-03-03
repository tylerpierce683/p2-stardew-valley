import java.util.Random;

/**
 * TaskGenerator class for creating Task Generator objects used to create and manage tasks
 * @author Tyler Pierce
 * @version Spring 2023
 */
public class TaskGenerator implements TaskGeneratorInterface {

	private int currentEnergyStorage;
	private double taskGenerationProbability;
	private long seed;
	
	/**
	 * Overloaded constructor for a task generator object used for creating tasks.
	 * @param taskGenerationProbability the probability of a task being created (the higher, the more probable)
	 * @param seed seed value for seeding random in task generation
	 */
	public TaskGenerator(double taskGenerationProbability, long seed) {
		this.currentEnergyStorage = DEFAULT_ENERGY;
		this.taskGenerationProbability = taskGenerationProbability;
		this.seed = seed;
	}
	
	/**
	 * Constructor for creating task generators used for creating tasks
	 * @param taskGenerationProbability the probability of a task being created (the higher, the more probable)
	 */
	public TaskGenerator(double taskGenerationProbability) {
		currentEnergyStorage = DEFAULT_ENERGY;
		this.taskGenerationProbability = taskGenerationProbability;
		this.seed = 0;
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
		Random rand = new Random(this.seed);
		Double randDouble = rand.nextDouble(1);
		if (randDouble <= this.taskGenerationProbability) {
			return true;
		} else {
			return false; 
		}
	}

	@Override
	public int getUnlucky(Task task, double unluckyProbability) {
		if (unluckyProbability <= task.getTaskType().getPassingOutProbability()) {
			if (unluckyProbability <= task.getTaskType().getDyingProbability()) {
				currentEnergyStorage = (int)(currentEnergyStorage * 0.25);
				task.setPriority(0);
				return DEATH;
			} else {
				currentEnergyStorage = currentEnergyStorage / 2;
				return PASSED_OUT;
			}
		} else {
			return SURVIVED;
		}
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
