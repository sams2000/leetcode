package bits;

public class TrailingZeros {
    public long trailingZeros(long n) {
        if (n <= 1)
            return 0;
        long res = 0;
        for (int i = 5; n / i >= 1;) {
            res += n / i;
            n /= 5;
        }
        return res;
    }
}
