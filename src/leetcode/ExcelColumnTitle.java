package leetcode;

public class ExcelColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(25));
	}
	
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            n--;
            sb.append((char)('A' + n % 26)); // from A to append the following things.
            n = n /26;
        }
        return sb.reverse().toString();
    }

}
