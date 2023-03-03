/**
 * Class used for creating and using a priority queue as the front end of the max heap
 * @author Tyler Pierce
 * @version Spring 2023
 */
public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface {
	private MaxHeap heap;
	
	/**
	 * Constructor creating a priority queue that intitalizes a max heap
	 */
	public MyPriorityQueue() {
		heap = new MaxHeap();
	}
	
	@Override
	public void enqueue(Object task) {
		heap.insert((Task)task);
	}

	@Override
	public Task dequeue() {
		try {
			if (!heap.isEmpty()) {
				Task returnTask = heap.extractMax();
				return returnTask;
			} else {
				throw new HeapException("");
			}
		} catch (HeapException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	@Override
	public void update(int timeToIncrementPriority, int maxPriority) {
		// TODO Auto-generated method stub

	}

}
