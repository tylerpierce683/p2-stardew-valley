/**
 * @author Tyler Pierce
 *
 */
public class Task implements TaskInterface, Comparable {
	private int priority = 0;
	private int waitingTime = 0;
	private TaskInterface.TaskType taskType;
	private int hourCreated = 100;
	private String taskDescription;
	
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
	
	public String getTaskDescription() {
		return taskDescription;
	}
	
	public int getHourCreated() {
		return hourCreated;
	}
	
	/**
	 * Create a String containing the Task's information.
	 *
	 * @param task - the Task
	 * @param taskType - the Task's type
	 */
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
