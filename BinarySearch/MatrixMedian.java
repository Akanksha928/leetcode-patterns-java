public class MatrixMedian {

    public static int findElemsLesserThan(int[][] matrix, int mid) {

        // using concept of upper_bound

        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            count += upperBound(matrix[i], mid);
        }

        return count;

    }

    public static int upperBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length; 

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }

        return low;
    }

    public static int findMedian(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // To find the smallest number in the matrix, iterate thru matrix[row][0]

        for (int i = 0; i < rows; i++) {
            low = Math.min(low, matrix[i][0]);
        }

        // To find the largest number in the matrix, iterate thru matrix[rows][cols - 1]

        for (int i = 0; i < rows; i++) {
            high = Math.max(high, matrix[i][cols - 1]);
        }

        int desired = (rows * cols + 1) / 2;

        while (low < high) {

            int mid = low + (high - low) / 2;
            int count = findElemsLesserThan(matrix, mid);

            if (count < desired) {
                low = mid + 1;
            }

            else {
                high = mid;
            }

        }

        return low;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 8 },
                { 2, 3, 4 },
                { 1, 2, 5 }
        };

        int median = findMedian(matrix);
        System.out.println("Median is: " + median);
    }
}
