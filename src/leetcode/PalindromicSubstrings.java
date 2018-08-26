package leetcode;

public class PalindromicSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaa";
		countSubstrings(s);
	}
    public static int countSubstrings(String s) {
        int count = s.length();
        if (s.equals("")) return 1;
        for (int i = 2; i < s.length(); i++){
            for (int j = 0; j < s.length()-i; j++){
                if (isPalindrome(s.substring(j,j+i))){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public static boolean isPalindrome(String s){
        for (int i = 0; i < s.length() / 2; i++){
            if (s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

}
