package leetcode;

import java.util.*;

import javafx.util.Pair;

public class BasicKnowledge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. exchange between number and character
		System.out.println((char)('A' + 1)); // B
		System.out.println((char)('A' + 25)); // Z
		System.out.println((char)('A' + 26)); // [ didn't go back to A
		System.out.println((char) 65); // A
		System.out.println((char) 66); // B
		
		// 2. Use StringBulider to append character to string
		StringBuilder sb = new StringBuilder();
		char a = 'A';
		sb.append(a);
		System.out.println(sb.toString()); // A
		
		// 3. Random number
		Random rd = new Random();
			// the parameter in the () is the bound which the final value cannot reach to this value
			// e.g.: nextInt(2) = 1 or 0, it will not be 2
		System.out.println(rd.nextInt(2)); 
		
		// 4. String compare
		int[] test = new int[10];
		System.out.println(test.toString()); // cannot change the value to string, just the physical ID
		String test2 = "1111";
		String test3 = "1001";
		System.out.println(test2.compareTo(test3)); // return the number of matching chars
		
		// 5. Queue initialization
			// Queue is an interface, there are many implemented classes using Queue like Dequeue and linkedList
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 6. Stack initialization
			// Stack is not like queue, it's a class in java
		Stack<Integer> stack = new Stack<Integer>();
		
		// 7. javafx.util.Pair
		Pair<Integer, Integer> pair = new Pair<Integer, Integer>(3,4);
		
		// 8. Iterator Initialization
		Set<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(0);
		hashSet.add(1);
		Iterator<Integer> iter = hashSet.iterator();
		System.out.println(iter.next());
		System.out.println(iter.next());
		
		// 9. Change an integer to a string
		int num = 1;
		String str = "" + num;
		
		// 10. Map initialization and for loop
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1,1);
		map.put(2,2);
		map.put(2,3); // this statement will replace the previous input
		for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		// 11 customized Comparator (see the class created below)
		Integer[] nums = {1,2,3,4,5};
		Arrays.sort(nums,new DifferenceComparator());
		for (Integer i : nums) {
			System.out.println(i);
		}

		// 12. get the substring of a string
		String h = "dsfsdfg";
		System.out.println(h.substring(0,1));
		System.out.println(Double.POSITIVE_INFINITY);
		
		// 13. Sort the array from specific index
		int[] n = {-1, 0, 1, 2, -1, -4};
		Arrays.sort(n, 1, 6);
		for (int i : n) {
			System.out.println(i);
		}
		
		// 14. character computation
		char e = 'a';
		char c = 'e';
		System.out.println(e - c);
		
		// 15. Bit Operation
		int bit_a = 60; // 0011 1100
		int bit_b = 13; // 0000 1101
		System.out.println(bit_a <<= 2); // 1111 0000
		System.out.println(bit_a >>= 2); // 0011 1100
		System.out.println(bit_a >>= 2); // 0000 1111
		System.out.println(bit_a <<= 2); // 0011 1100
		System.out.println(bit_a >>>= 2); // 0000 1111
		System.out.println(bit_b >>>= 2);
		
		
		
		
	}
}

// override the comparator
class LengthComparator implements Comparator<Pair<Integer,Integer>>{
	@Override
	public int compare(Pair<Integer, Integer> p1, Pair<Integer,Integer> p2) {
		// TODO Auto-generated method stub
		int value1 = p1.getValue();
		int value2 = p2.getValue();
		return value1-value2;
	}
}
class DifferenceComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer a, Integer b) {
		// TODO Auto-generated method stub
		int value1 = Math.abs(3-a);
		int value2 = Math.abs(3-b);
		return value1 - value2;
	}
}
