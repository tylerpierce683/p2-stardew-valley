/**
 * @author Tyler Pierce
 *
 */
public class MaxHeapTest {
	int totalRun = 0;
	int passes = 0; 
	int failures = 0;
	
	public static void main(String[] args) {
		MaxHeapTest tester = new MaxHeapTest();
		tester.runTests();
		
	}
	
	private void runTests() {
		printTest("isEmpty() on new empty max heap", isEmptyOnNewEmptyHeap());
		printTest("isEmpty() on new one element max heap", isEmpty_false_OnOneElementHeap());
		printTest("insert() on new empty max heap, checking location", placementTestWithInsertMethod());
		printTest("extractMax() on two element inserted heap", sortTestExtractMaxTwoElements());
		printTest("extractMax() on three element inserted heap", sortTestExtractMaxThreeElements());
		printTest("increaseKey on two element heap", increaseKeyTwoElementTest());
		printSummary();
	}
	
	/** Print test results
	 * @param desc description of the test
	 * @param result indicates if the test passed or failed
	 */
	private void printTest(String desc, boolean result) {
		totalRun++;
		if (result) { 
			passes++; 
		}
		else { 
			failures++; 
		}
		System.out.printf("%-46s\t%s\n", desc, (result ? "   PASS" : "***FAIL***"));
	}
	
	private void printSummary() {
		String summary = String.format("\nTotal Tests Run: %d,  Passed: %d (%.1f%%),  Failed: %d\n",
				totalRun, passes, passes*100.0/totalRun, failures);
		String lineBreak = "";
		for (int i = 0; i < summary.length(); i++) {
			lineBreak += "-";
		}
		System.out.println(lineBreak);
		System.out.println(summary);
	}
	
	private boolean isEmptyOnNewEmptyHeap() {
		MaxHeap emptyHeap = new MaxHeap();
		if (emptyHeap.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isEmpty_false_OnOneElementHeap() {
		Task dummyTask = new Task(1, TaskInterface.TaskType.FISHING, "fish dummy task");
		Task[] heapArray = new Task[1];
		heapArray[0] = dummyTask;
		MaxHeap oneElementHeap = new MaxHeap(heapArray);
		if (oneElementHeap.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	private boolean placementTestWithInsertMethod() {
		MaxHeap insertTestHeap = new MaxHeap();
		Task dummyTask1 = new Task(1, TaskInterface.TaskType.FISHING, "fish dummy task");
		Task dummyTask2 = new Task(2, TaskInterface.TaskType.MINING, "mining dummy task");
		insertTestHeap.insert(dummyTask1);
		insertTestHeap.insert(dummyTask2);
		Task[] checkArray = insertTestHeap.getHeapArray();
		if (checkArray[0].equals(dummyTask1) && checkArray[1].equals(dummyTask2)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean sortTestExtractMaxTwoElements() {
		MaxHeap sortTestHeap = new MaxHeap();
		Task dummyTask1 = new Task(1, TaskInterface.TaskType.FISHING, "fish dummy task");
		Task dummyTask2 = new Task(2, TaskInterface.TaskType.MINING, "mining dummy task");
		sortTestHeap.insert(dummyTask1);
		sortTestHeap.insert(dummyTask2);
		try {
			Task returnTask1 = sortTestHeap.extractMax();
			Task returnTask2 = sortTestHeap.extractMax();
			if (returnTask1.equals(dummyTask1) && returnTask2.equals(dummyTask2)) {
				return true;
			} else {
				return false;
			}
		} catch (HeapException e) {
			System.err.println("Heap Exception thrown");
			e.printStackTrace();
		}
		return false;
	}

	private boolean sortTestExtractMaxThreeElements() {
		MaxHeap sortTestHeap = new MaxHeap();
		Task dummyTask1 = new Task(1, TaskInterface.TaskType.FISHING, "fish dummy task");
		Task dummyTask2 = new Task(2, TaskInterface.TaskType.MINING, "mining dummy task");
		Task dummyTask3 = new Task(3, TaskInterface.TaskType.MINING, "mining dummy task");
		sortTestHeap.insert(dummyTask1);
		sortTestHeap.insert(dummyTask3);
		sortTestHeap.insert(dummyTask2);
		try {
			Task returnTask1 = sortTestHeap.extractMax();
			Task returnTask2 = sortTestHeap.extractMax();
			Task returnTask3 = sortTestHeap.extractMax();
			if (returnTask1.equals(dummyTask1) && returnTask2.equals(dummyTask2) && returnTask3.equals(dummyTask3)) {
				return true;
			} else {
				return false;
			}
		} catch (HeapException e) {
			System.err.println("Heap Exception thrown");
			e.printStackTrace();
		}
		return false;
	}

	private boolean increaseKeyTwoElementTest() {
		MaxHeap sortTestHeap = new MaxHeap();
		Task dummyTask1 = new Task(1, TaskInterface.TaskType.FISHING, "fish dummy task");
		Task dummyTask2 = new Task(2, TaskInterface.TaskType.MINING, "mining dummy task");
		sortTestHeap.insert(dummyTask1);
		sortTestHeap.insert(dummyTask2);
		try {
			sortTestHeap.increaseKey(0, dummyTask2);
			Task returnTask1 = sortTestHeap.extractMax();
			Task returnTask2 = sortTestHeap.extractMax();
			if (returnTask1.equals(dummyTask2) && returnTask2.equals(dummyTask1)) {
				return true;
			} else {
				return false;
			}
		} catch (HeapException e) {
			e.printStackTrace();
		}
		return false;
	}
}


