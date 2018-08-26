package basicDataStructure;

import java.util.*;
public class InefficientDynamicArrayQueue {

	/*
	 * Method: use a dynamic array and an index pointing to the head of the queue
	 *         without actually remove the element in the ArrayList.
	 * Drawback: as the pointer of the head moves, the storage before the pointer will be wasted.        
	 */
	private List<Integer> data;
	private int p_start;
	public InefficientDynamicArrayQueue() {
		// TODO Auto-generated constructor stub
		this.data = new ArrayList<Integer>();
		this.p_start = 0;
	}
	
	public boolean enQueue(int x) {
		this.data.add(x);
		return true;
	}
	
	public boolean deQueue() {
		if (this.isEmpty()) {
			return false;
		}
		this.p_start++;
		return true;
		
	}
	
	public int front() {
		return this.data.get(this.p_start);
	}
	
	public boolean isEmpty() {
		return this.p_start >= this.data.size();
	}

}
