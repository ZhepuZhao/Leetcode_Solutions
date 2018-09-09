package leetcode;
import java.util.*;

public class ZigzagIterator {

    private List<Integer> list1;
    private List<Integer> list2;
    private int i;
    private int j;
    private boolean toggle;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.list1 = v1;
        this.list2 = v2;
        this.i = 0;
        this.j = 0;
        this.toggle = true;
    }

    public int next() {
        int res = 0;
        if (hasNext()) {
            if (i < list1.size() && toggle) {
                toggle = false;
                res = list1.get(i);
                i++;
            } else if (j < list2.size() && !toggle) {
                toggle = true;
                res = list2.get(j);
                j++;
            }
        }
        return res;
    }

    public boolean hasNext() {
        if (i < list1.size() || j < list2.size()) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
