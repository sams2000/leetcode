
package com.example.leet;

/**
 *   
 * @author bzhou3
 * @since 2016-01-20
 */
public class CompressString {
    public static void main(String[] args) {
        String inputStr = "aabcccccaaa";
        System.out.println("Before compression: " + inputStr);
        System.out.println("After compression : " + compressStr(inputStr));
    }

    private static String compressStr(String str) {
		// check whether need to compress or not
		int compressSize = countCompression(str);

		if (compressSize >= str.length()) {
			return str;
		}

		StringBuffer szStr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				szStr.append(last);// append character and count once character
									// changes
				szStr.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}

		szStr.append(last);// append last character and count
		szStr.append(count);

		return szStr.toString();
	}

	private static int countCompression(String str) {
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				size += String.valueOf(count).length() + 1;// count can be one
															// digit or multiple
															// digits
				last = str.charAt(i);
				count = 1;
			}

		}
		size += String.valueOf(count).length() + 1;// add the last count
		return size;
	}
}
