package leetcode;

public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		strStr("mississippi","issip");
	}
    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (haystack.equals("")) return -1;
        if (needle.length() > haystack.length()) return -1;
        int p = -1; // point to the return index
        int k = 0; // pointer of needle
        
        for (int i = 0; i <= haystack.length()-needle.length(); i++){
            boolean match = true;
            for (int j = i; j < haystack.length(); j++){
            	if (k == needle.length()) {
            		return p;
            	}
                if (haystack.charAt(j) == needle.charAt(k)){
                    if (p < 0) p = j;
                    k++;
                } else{
                    match = false;
                    p = -1;    
                    break;
                }
            }
            if (match) return p;
        }
        return -1;
    }

}
