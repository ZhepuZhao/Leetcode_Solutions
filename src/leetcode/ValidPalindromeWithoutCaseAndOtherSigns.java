package leetcode;

public class ValidPalindromeWithoutCaseAndOtherSigns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "0P";
		// System.out.println(isPalindrome(a));
		char b = '.';
		char d = ' ';
		char c = 'd';
		char e = 'D';
		char f = '1';
//		System.out.println(b >= 'a' && b <= 'z');
//		System.out.println(d >= 'a' && d <= 'z');
//		System.out.println(c >= 'a' && c <= 'z');
		System.out.println(e >= 'a' && e <= 'z' || e >= 'A' && e <= 'Z');
//		System.out.println(f >= 'a' && f <= 'z');
		System.out.println('A'-'0');
		System.out.println(Character.getNumericValue('B'));
	}
    public static boolean isPalindrome(String s) {
        if(s.equals("")) return true;
        int j = s.length()-1;
        String temp = s.toLowerCase(); // set all to lower case letter
        int i = 0;
        while(i <= j) {
            if (!Character.isLetter(temp.charAt(i)) && !Character.isDigit(temp.charAt(i))){   
            	i++;
            	continue;
            } 
        	if (!Character.isLetter(temp.charAt(j)) && !Character.isDigit(temp.charAt(j))){
                j--;
                continue;
            }
               
            if (temp.charAt(i) != temp.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
      
        return true;
    }

}
