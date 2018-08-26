package leetcode;

import java.util.*;
public class LetterCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "23";
		letterCombinations(s);
	}
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2',"abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        char[] numbers = digits.toCharArray();
        List<String> previous = new ArrayList<String>();
        for (int i = 0; i < numbers.length; i++){
            if (previous.isEmpty()) {
                char[] letters = map.get(numbers[i]).toCharArray();
                List<String> current = new ArrayList<String>();
                for (char j : letters) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(j);
                    current.add(sb.toString());
                    
                }  
                previous = current;
            } else {
                for (int j = 0; j < previous.size(); j++) {
                    char[] letters = map.get(numbers[i]).toCharArray();
                    List<String> current = new ArrayList<String>();
                    for (char k : letters) {
                        
                        StringBuilder sb = new StringBuilder();
                        sb.append(previous.get(j));
                        sb.append(k);
                        current.add(sb.toString());
                        
                    }   
                    previous = current;
                }
               
            }
        }
        return previous;
    }

}
