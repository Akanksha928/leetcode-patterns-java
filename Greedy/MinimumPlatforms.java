import java.util.*;

public class MinimumPlatforms {

    public static int findPlatform(int[] arr, int[] dep) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 0;
        int currentPlatforms = 0;
        int i = 0;
        int j = 0;

        // Two pointer approach comparing arrival & departure times

        while ((i < arr.length) && (j < dep.length)) {
            if (arr[i] < dep[j]) {
                currentPlatforms++;
                i++;
            } else if (dep[j] < arr[i]) {
                currentPlatforms--;
                j++;
            }

            // Keep track of max platforms needed

            platforms = Math.max(platforms, currentPlatforms);
        }

        return platforms;

        // TC: O 2(n log n + n)
        // SC: O(1)
    }

    public static void main(String[] args) {
        int[] arrival = { 900, 910, 920, 930, 940 };
        int[] departure = { 915, 925, 935, 945, 955 };

        int result = findPlatform(arrival, departure);
        System.out.println("Minimum number of platforms required: " + result);
    }
}
