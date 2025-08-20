
class nthRoot {

    // Helper func to calculate product of m power 

    public static int func(int mid, int n, int m) {
        long prod = 1;
        for (int i = 0; i < n; i++) {

            if (prod > m / mid) {
                return 1;
            }

            prod *= mid;

        }

        if (prod == m) {
            return 0;
        }

        if (prod < m) {
            return -1;
        }

        return 1;

    }

    public static int NthRoot(int n, int m) {

        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int funcM = func(mid, n, m);
            if (funcM == 0) {
                return mid;
            }
            if (funcM == 1) {
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int n = 3, m = 27;
        int ans = NthRoot(n, m);
        System.out.println("The answer is: " + ans);
    }
}

