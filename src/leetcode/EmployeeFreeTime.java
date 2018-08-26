package leetcode;

import java.util.*;

public class EmployeeFreeTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<Interval> a = new ArrayList<Interval>();
//		a.add(new Interval(1,2));
//		a.add(new Interval(5,6));
//		List<Interval> b = new ArrayList<Interval>();
//		b.add(new Interval(1,3));
//		List<Interval> c = new ArrayList<Interval>();
//		c.add(new Interval(4,10));
//		List<List<Interval>> schedule = new ArrayList<List<Interval>>();
//		schedule.add(a);
//		schedule.add(b);
//		schedule.add(c);
//		employeeFreeTime(schedule);
        
	}			
	
	public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> free_prev = new ArrayList<Interval>();
		for (int i = 0; i < schedule.size(); i++) {
			List<Interval> free_cur = new ArrayList<Interval>();
			int start = Integer.MIN_VALUE;
			for (int j = 0; j < schedule.get(i).size(); j++) {
				free_cur.add(new Interval(start, schedule.get(i).get(j).start));
				start = schedule.get(i).get(j).end;
				if (j == schedule.get(i).size() - 1) {
					free_cur.add(new Interval(schedule.get(i).get(j).end, Integer.MAX_VALUE));
				}
			}
			if (free_prev.size() == 0) {
				free_prev = free_cur;
				continue;
			}
			List<Interval> temp = new ArrayList<Interval>();
			for (int j = 0; j < free_cur.size(); j++) {
				for (int k = 0; k < free_prev.size(); k++) {
					Interval cur = free_cur.get(j);
					Interval prev = free_prev.get(k);
					if (cur.start <= prev.end) {
						if (cur.start >= prev.start && cur.end <= prev.end) {
							temp.add(new Interval(cur.start, prev.end));
							continue;
						}
						if (cur.start <= prev.start && cur.end <= prev.end) {
							temp.add(new Interval(prev.start, cur.end));
							continue;
						}
						if (cur.start >= prev.start && cur.end <= prev.end) {
							temp.add(new Interval(cur.start, cur.end));
							continue;
						}
						if (cur.start <= prev.start && cur.end >= prev.end) {
							temp.add(new Interval(prev.start, prev.end)); 
							continue;
						}
					} else {
						continue;
					}

				}
			}
			free_prev = temp;
		}
		return free_prev;
	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
