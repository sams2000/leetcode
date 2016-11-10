package binarySearch;

class VersionControl {
    static boolean isBadVersion(int k) {
        return false;
    };
}

/**
 * you can use VersionControl.isBadVersion(k) to judge whether the kth code version is bad or not.
 * @author bin zhou 
 *         Created on Feb 17, 2016
 *
 */
public class findFirstBadVision {
    public int findFirstBadVersion(int n) {
        if (n == 1)
            return VersionControl.isBadVersion(1) ? 1 : 0;
        int l = 0;
        int r = n;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (VersionControl.isBadVersion(mid)) {
                r = mid;

            } else {
                l = mid + 1;
            }
        }
        if (VersionControl.isBadVersion(l)) {
            return l;
        } else {
            return r;
        }
    }
}
