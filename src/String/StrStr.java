package String;

/**
 * Returns a index to the first occurrence of target in source, or -1 if target
 * is not part of source.
 * 
 * @param source
 *            string to be scanned.
 * @param target
 *            string containing the sequence of characters to match.
 */

class StrStr {
    //good solution
    public static int strStr(String source, String target) {

        if (target == null || source == null)
            return -1;
        if (source.length() == 0 && source.equals(target))
            return 0;
        int j;
        for (int i = 0; i < source.length(); i++) {
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }

        return -1;
    }

    //better solution
    public static int strStr1(String source, String target) {
        // Check Null
        if (source == null || target == null) {
            return -1;
        }
        // Two Pointer check for target
        int i, j;
        for (i = 0; i < source.length() - target.length() + 1; i++) {
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        // 'target' not found:
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("strStr result: " + strStr("abcdefgh", "cde"));
        System.out.println("strStr1 result: " + strStr1("abcdefgh", "cde"));
    }
}
