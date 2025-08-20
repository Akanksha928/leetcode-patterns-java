
public class SubsetSumTarget {

    public boolean isSubsetSum(int[] arr, int target) {


        return false;
    }

    public static void recursiveFunc(int pointer, int sum, int[] arr, int N, int[] sums) {

        if (pointer == N) {
            sums[pointer] = sum;
            return;
        }

        recursiveFunc(pointer + 1, sum + arr[pointer], arr, N, sums);

        recursiveFunc(pointer + 1, sum, arr, N, sums);

    }

    public static void main(String[] args) {
        SubsetSumTarget solver = new SubsetSumTarget();

        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int target = 9;

        int[] subsetSums = new int[arr.length];
        int N = arr.length - 1;
        recursiveFunc(0, 0, arr, N, subsetSums);

        boolean result = solver.isSubsetSum(subsetSums, target);
        System.out.println("Is subset sum possible? " + result);
    }
}
