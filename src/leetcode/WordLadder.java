package leetcode;

import java.util.*;

public class WordLadder {

	private static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String b = "hit";
		String e = "cog";
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(ladderLength(b, e, wordList));	
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// return dfs(beginWord, endWord, wordList, new HashSet<String>(), 0);
		Set<String> set = new HashSet<String>(wordList);
		if (set.contains(beginWord)) {
			set.remove(beginWord);
		}
		Queue<String> queue = new LinkedList<String>();
		int level = 1;
		int curNum = 1;
		int nextNum = 0;
		queue.offer(beginWord);
		while (!queue.isEmpty()) {
			String word = queue.poll();
			curNum--; // how many strings the current string could be transformed by only changing one letter.
			for (int i = 0; i < word.length(); i++) {
				char[] wordUnit = word.toCharArray();
				for (char j = 'a'; j <= 'z'; j++) {
					wordUnit[i] = j;
					String temp = new String(wordUnit);
					if (set.contains(temp)) {
						if (temp.equals(endWord)) {
							return level + 1;
						}
						nextNum++;
						queue.offer(temp);
						set.remove(temp);
					}
				}
			}
			if (curNum == 0) {
				curNum = nextNum;
				nextNum = 0;
				level++;
			}
		}
		return 0;

	}

	private static int dfs(String beginWord, String endWord, List<String> wordList, Set<String> set,
			int current_length) {
		for (int i = 0; i < wordList.size(); i++) {
			if (!set.contains(wordList.get(i))) {
				if (oneLetterDifferent(wordList.get(i), endWord)) {
					current_length += 2;
					set.add(wordList.get(i));
					return Math.min(current_length, result);
				}
				if (oneLetterDifferent(beginWord, wordList.get(i))) {
					current_length++;
					set.add(wordList.get(i));
					result = Math.min(dfs(wordList.get(i), endWord, wordList, set, current_length), result);
				}
			} else {
				continue;
			}

		}

		return result;
	}

	private static boolean oneLetterDifferent(String beginWord, String word) {
		int count = 0;
		for (int i = 0; i < beginWord.length(); i++) {
			if (beginWord.charAt(i) != word.charAt(i)) {
				count++;
			}
		}
		return count == 1 ? true : false;
	}

}
