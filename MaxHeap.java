import java.util.Arrays;

/**
 * MaxHeap Class that contains all of the methods required to create and 
 * maintain a max heap that uses an array as an underlying structure.
 * @author Tyler Pierce
 * @version Spring 2023
 */
public class MaxHeap {
	private final int DEFAULT_SIZE = 10;
	protected Task[] heapArray;
	private int size = 0;
	
	/**
	 * default constructor creating a new MaxHeap with default values.
	 */
	 public MaxHeap() {
		 heapArray = new Task[DEFAULT_SIZE];
		 size = 0;
	 }
	 
	 /**
	  * constructor taking in array to make into max heap
	  * @param taskArray array of Tasks to be added to a max heap
	  */
	 public MaxHeap(Task[] taskArray) {
		 heapArray = new Task[DEFAULT_SIZE];
		 for (int i = 0; i < taskArray.length; i++) {
			 heapArray[i] = taskArray[i];
			 size++;
		 }
		 buildMaxHeap();
	 }
	 
	 /**
	  * Checks to see if the max heap is Empty
	  * @returns true if empty and false if not empty
	  */
	 public boolean isEmpty() {
		 if (heapArray[0] == null || size == 0) {
			 return true;
		 } else {
			 return false;
		 }
	 }
	 
	 /**
	  * Inserts the given task into the max heap and places it in the correct
	  * place.
	  * @param task The task to be inserted
	  */
	 public void insert (Task task) {
		 checkForExpansion();
		 heapArray[size] = task;
		 size++;
		 bubbleUp(size - 1);
	 }
	 
	 /**
	  * Increases the key of the task and moves the tasks
	  * @param index the index of the task
	  * @param task the task
	  */
	 public void increaseKey(int index, Task task) throws HeapException{
		 if (task.compareTo(heapArray[index]) < 0) {
			 throw new HeapException("New key must be larger than current key");
		 }
		 heapArray[index] = task;
		 bubbleUp(index);
	 }
	 
	 /**
	  * Checks to see if the underlying array needs to be exapanded
	  */
	 private void checkForExpansion() {
		 if (size != 0 && (heapArray[size - 1]) != null) {
			 Arrays.copyOf(heapArray, size * 2);
		 }
	 }
	 
	 /**
	  * Bubbles up the values to their correct place
	  * @param index the index of the task to bubble up
	  */
	 private void bubbleUp(int index) {
		 while (index > 0 && (heapArray[getParent(index)].compareTo(heapArray[index]) < 0)) {
			 swap(index, getParent(index));
			 index = getParent(index);
		 }
	 }
	 
	 /**
	  * Extracts the max task 
	  * @return
	  * @throws HeapException
	  */
	 public Task extractMax() throws HeapException {
		 Task max = max();
		 heapArray[0] = heapArray[size - 1];
		 size--;
		 heapify(0);
		 return max;
	 }
	 
	 /**
	  * Returns the max task while keeping it in the max heap
	  * @return the max task
	  * @throws HeapException If the heap is empty
	  */
	 public Task max() throws HeapException {
		 if (size < 1) {
			 throw new HeapException("heap underflow");
		 }
		 return heapArray[0];
	 }
	 
	 /**
	  * Builds the max heap buy running heapify
	  */
	 private void buildMaxHeap() {
		 for (int i = ((size / 2) - 1); i >= 0; i--) {
			 heapify(i);
		 }
	 }
	 
	 /**
	  * Turns the heap into a max heap by comparing the values above the value at
	  * the index to make sure it finds its correct spot
	  * @param index the index of the task that is being checked
	  */
	 private void heapify(int index) {
		 int l = getLeft(index);
		 int r = getRight(index);
		 int largest = 0;
		 if ((l < size) && (heapArray[l].compareTo(heapArray[index]) > 0)) {
			 largest = l;
		 } else {
			 largest = index;
		 }
		 if ((r < size) && (heapArray[r].compareTo(heapArray[largest]) > 0)) {
			 largest = r;
		 }
		 if (largest != index) {
			 swap(index, largest);
			 heapify(largest);
		 }
	 }
	 
	 /**
	  * private helper method to swap two Tasks at the given indexes.
	  * @param index1 the index of the first value to be swapped
	  * @param index2 the index of the second value to be swapped
	  */
	 private void swap(int index1, int index2) {
		 Task task1 = heapArray[index1];
		 Task task2 = heapArray[index2];
		 heapArray[index1] = task2;
		 heapArray[index2] = task1;
	 }
	 
	 /**
	  * Private helper method that takes in a current Task and
	  * returns the parent of that task
	  * 
	  * @param taskIndex index of the child task
	  * @return task parent index
	  */
	 private int getParent(int taskIndex) {
		 return ((taskIndex - 1) / 2);
	 }
	 
	 /**
	  * Private helper method that takes in a current Task and
	  * returns the left child of that task
	  * 
	  * @param taskIndex index of the parent task
	  * @return task left child index
	  */
	 private int getLeft(int taskIndex) {
		 return ((2 * taskIndex) + 1);
	 }
	 
	 /**
	  * Private helper method that takes in a current Task and
	  * returns the right child of that task
	  * 
	  * @param taskIndex index of the parent task
	  * @return task right child index
	  */
	 private int getRight(int taskIndex) {
		 return ((2 * taskIndex) + 2);
	 }

	 /**
	  * Helper method for running tests to make sure that the 
	  * contents of the array are correct.
	  * @return the underlying array of tasks
	  */
	 public Task[] getHeapArray() {
		Task[] heapArrayCopy = new Task[heapArray.length];
		for (int i = 0; i < heapArray.length; i++) {
			heapArrayCopy[i] = heapArray[i];
		}
		return heapArrayCopy;
	 }
}
