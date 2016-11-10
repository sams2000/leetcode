package com.example.leet;

/**
 * 
 * @author bin zhou
 * @since 2016-01-29
 */
public class StringHasPermutationOfAnotherString {
	public static void main(String[] args) {
		String a = "absditg";
		String b = "itd";
		System.out.println(checkAnagram(a, b));
	}

	public static boolean checkAnagram(String s1, String s2) {
		if (s1 == null || s2 == null)
			return false;
		if (s2.length() == 0)
			return true;
		if (s1.length() < s2.length())
			return false;
		
		char[] chatSet1 = new char[256];
		char[] charSet2 = new char[256];
		//check first s2.length in s1 to check whether it's anagram with s2
		for (int i = 0; i < s2.length(); i++) {
			chatSet1[s1.charAt(i)]++;
			charSet2[s2.charAt(i)]++;
		}
		
		int counter = 0;
		//move forward one by one and update character count with each move
		for (int i = s2.length(); i < s1.length(); i++) {
			if (isAnagram(chatSet1, charSet2))
				return true;
			chatSet1[s1.charAt(counter++)]--;
			chatSet1[s1.charAt(i)]++;
		}
		if (isAnagram(chatSet1, charSet2))
			return true;
		return false;
	}

    // is anagram
    public static boolean isAnagram(char[] s1, char[] s2) {
        for (int i=0; i<s1.length; i++){
            if (s1[i] != s2[i])
                return false;
        }
        return true;
    }
}
