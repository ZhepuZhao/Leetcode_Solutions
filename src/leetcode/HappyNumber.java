package leetcode;

import java.util.*;
public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 19;
		isHappy(a);
	}

    public static boolean isHappy(int n) {
        Set<Integer> hashSet = new HashSet<Integer>();
        int sum = n;
        while (!hashSet.contains(sum)){
            String num = "" + sum;
            char[] ch = num.toCharArray();  
            sum = 0;
            for (int i = 0; i < ch.length; i++){
                sum += Math.pow(ch[i]-'0',2);
            }
            if (sum == 1){
                return true;
            }else {
                hashSet.add(sum);
            }
        }
        return false;
    }
}
