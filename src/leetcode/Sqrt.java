package leetcode;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mySqrt(0); //2147395600
		System.out.println(46342*46342);
		System.out.println(46340*46340);
		int[] a = {1,2,3,3};
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		int[] b = {1,1,1,1,1};
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		a = b;
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
  
	}
    public static int find(int x, int left, int right){
        int m = (left + right) / 2;
        if ((right - left) == 1) return left;
        if (x == m * m){
           return m;
        } else if (x > m * m){
            return find(x, m, right);
        } else {
            return find(x, left, m);
        }
    }
	
    public static int mySqrt(int x) {
//        int max_base = 1;
//        int pow = 1;
//        while(pow > 0){
//            pow = max_base * max_base;
//            max_base++;
//        }
//        max_base = max_base - 2;
//        for (int i = 0; i <= max_base; i++){
//            if (x < i * i){
//                pow = i-1;
//                break;
//            }
//        }
//        if (x >= max_base*max_base) return max_base;
//        return pow;
    	
    	// solution 2:
        int max_base = 46340;
        if (x >= max_base*max_base) return max_base;
        return find(x,1,max_base);   
    }

}
