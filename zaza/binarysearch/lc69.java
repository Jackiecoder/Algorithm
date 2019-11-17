package binarysearch2;

public class lc69 {
    public int mySqrt(int x) {
        long l = 0;
        long r = x;
        while (l + 1 < r) {
            long mid = l + (r - l)/2;
            if (mid*mid == x) {
                return (int)mid;
            } else if (mid*mid < x) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (r*r <= x) {
            return (int)r;
        }

        return (int)l;
    }
}
