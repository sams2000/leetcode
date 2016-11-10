package binarySearch;

public class WoodCut {
    public static void main(String[] args) {
        int[] array = { 2147483644, 2147483645, 2147483646, 2147483647 };
        System.out.println(woodCut(array, 4));
    }
    
    public static int woodCut(int[] L, int k) {
        if (L.length == 0)
            return 0;
        // find the max L
        int max = L[0];
        for (int i = 1; i < L.length; i++) {
            max = max < L[i] ? L[i] : max;
        }
        int start = 1;
        int last = max;
        max = 0;
        while (start <= last) {
            int mid = start + (last - start) / 2;
            int sum = 0;
            for (int i = 0; i < L.length; i++) {
                sum += L[i] / mid;
            }
            if (sum >= k) {
                max = mid;
                start = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return max;

    }
}
