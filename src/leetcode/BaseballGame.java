package leetcode;
import java.util.*;
public class BaseballGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"5","-2","4","C","D","9","+","+"};
		calPoints(s);
	}

	public static int calPoints(String[] ops) {
		// we assume the '+' appear after index 1
		int sum = 0;
		// use list
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < ops.length; i++) {
			if (ops[i].equals("C")) {
				sum -= list.get(list.size() - 1);
				list.remove(list.size() - 1);
			} else if (ops[i].equals("+")) {
				sum += list.get(list.size() - 1) + list.get(list.size() - 2);
				list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
			} else if (ops[i].equals("D")) {
				sum += 2 * list.get(list.size() - 1);
				list.add(2 * list.get(list.size() - 1));
			} else {
				sum += Integer.parseInt(ops[i]);
				list.add(Integer.parseInt(ops[i]));
			}
		}
		return sum;
	}
}
