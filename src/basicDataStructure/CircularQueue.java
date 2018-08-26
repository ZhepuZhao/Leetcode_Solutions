/**
 * 
 */
package basicDataStructure;

/**
 * @author Zhepu Zhao
 *
 */
public class CircularQueue {

	/**
	 * Method: we don't have to do anything with the array, we just need to adjust
	 * 		   the pointer
	 */

	private int size;
	private int[] data;
	private int head;
	private int tail;

	public CircularQueue(int k) {
		// TODO Auto-generated constructor stub
		this.size = k;
		this.data = new int[k];
		this.head = -1;
		this.tail = -1;
	}

	public boolean isEmpty() {
		return head == -1;
	}

	public boolean isFull() {
		return head == (tail + 1) % this.size;
	}

	public boolean enQueue(int value) {
		if (isFull()) {
			return false;
		}
		if (isEmpty()) {
			head = 0;
		}
		data[tail] = value;
		tail = (tail + 1) % this.size;
		return true;
	}

	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}
		if (head == tail) {
			head = -1;
			tail = -1;
			return true;
		}
		head = (head + 1) % this.size;
		return true;
	}

	public int front() {
		if (isEmpty()) {
			return -1;
		} else {
			return data[head];
		}
	}

	public int rear() {
		if (isEmpty()) {
			return -1;
		} else {
			return data[tail];
		}
	}

}

class TestCircularQueue {
	public static void main(String[] args) {
		CircularQueue obj = new CircularQueue(3);
		boolean param_1 = obj.enQueue(3);
		boolean param_2 = obj.deQueue();
		int param_3 = obj.front();
		int param_4 = obj.rear();
		boolean param_5 = obj.isEmpty();
		boolean param_6 = obj.isFull();
	}
}
