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
}


