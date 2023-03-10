/**
 * Task class for creating and interacting with task objects within
 * a max heap for the Stardew Valley Project
 * @author Tyler Pierce
 * @version Spring 2023
 */
public class Task implements TaskInterface, Comparable {
	private int priority = 0;
	private int waitingTime = 0;
	private TaskInterface.TaskType taskType;
	private int hourCreated = 100;
	private String taskDescription;
	
	/**
	 * Constructor for creating a new task
	 * @param hourCreated the hour that the task is being created at
	 * @param taskType the type of task (i.e. minging. fishing, etc.)
	 * @param taskDescription description of the task
	 */
	public Task(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
		this.priority = 0;
		this.taskType = taskType;
		this.taskDescription = taskDescription;
		this.waitingTime = 0;
		this.hourCreated = hourCreated;
	}
	
	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public void setPriority(int priority) {
		this.priority = priority;

	}

	@Override
	public TaskInterface.TaskType getTaskType() {
		return taskType;
	}

	@Override
	public void incrementWaitingTime() {
		waitingTime++;

	}

	@Override
	public void resetWaitingTime() {
		waitingTime = 0;

	}

	@Override
	public int getWaitingTime() {
		return waitingTime;
	}

	@Override
	public int compareTo(Object o) {
		if (this.priority < ((Task) o).getPriority()) {
			return -1;
		} else if (this.priority > ((Task) o).getPriority()) {
			return 1;
		} else if (this.priority == ((Task) o).getPriority()) {
			if (this.hourCreated < ((Task) o).getHourCreated()) {
				return 1;
			} else if (this.hourCreated > ((Task) o).getHourCreated()) {
				return -1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
	
	/**
	 * Getter for getting the task description
	 * @return the task description
	 */
	public String getTaskDescription() {
		return taskDescription;
	}
	
	/**
	 * Gives the hour that the task was created
	 * @return the hour the task was created
	 */
	public int getHourCreated() {
		return hourCreated;
	}
	
	/**
	 * Create a String containing the Task's information.
	 *
	 * @param task - the Task
	 * @param taskType - the Task's type
	 */
	public String toString() {
	        if(taskType == Task.TaskType.MINING) {
	            return "     Mining " + getTaskDescription() + " (Priority:" + getPriority() +")";
	        }
	        if(taskType == Task.TaskType.FISHING) {
	            return "     Fishing " + getTaskDescription() + " (Priority:" + getPriority() +")" ;
	        }
	        if(taskType == Task.TaskType.FARM_MAINTENANCE) {
	            return "     Farm Maintenance " + getTaskDescription() + " (Priority:" + getPriority() +")";
	        }
	        if(taskType == Task.TaskType.FORAGING) {
	            return "     Foraging " + getTaskDescription() + " (Priority:" + getPriority() +")" ;
	        }
	        if(taskType == Task.TaskType.FEEDING) {
	            return "     Feeding " + getTaskDescription() + " (Priority:" + getPriority() +")";
	        }
	        if(taskType == Task.TaskType.SOCIALIZING) {
	            return "     Socializing " + getTaskDescription() + " (Priority:" + getPriority() +")";
	        }
	        else { return "nothing to see here..."; }
	}




}
