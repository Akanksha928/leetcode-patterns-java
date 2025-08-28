
public class kthElement {

    public static int findKthElement(int[] a, int[] b, int k) {
        int count = 1;
        int i = 0;
        int j = 0;
        int result = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (count == k) {
                    result = a[i];
                }
                i++;
            } else {
                if (count == k) {
                    result = b[j];
                }
                j++;
            }
            count++;

        }

        if (result == 0) {
            while (i < a.length) {
                if (count == k) {
                    result = a[i];
                }
                count++;
                i++;
            }

            while (j < b.length) {
                if (count == k) {
                    result = b[j];
                }
                count++;
                j++;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = { 100, 112, 256, 349, 770 };
        int[] b = { 72, 86, 113, 119, 265, 445, 892 };
        int k = 6;

        int result = findKthElement(a, b, k);
        System.out.println("Kth element is: " + result);
    }
}
