
public class bookAllocation {
    public int findPages(int[] books, int students) {
        if (students > books.length)
            return -1;
        int low = 0;
        int high = 0;
        int res = -1;

        for (int num : books) {
            high += num;
            low = Math.max(low, num);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(books, mid, students)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public boolean isPossible(int[] books, int mid, int students) {

        int allocated = 1;
        int pages = 0;

        for (int i = 0; i < books.length; i++) {

            if (pages + books[i] > mid) {
                allocated++;
                if (allocated > students) {
                    return false;
                }
                pages = books[i];
            }

            else {
                pages += books[i];

            }
        }
        return true;

    }

    public static void main(String[] args) {
        bookAllocation sol = new bookAllocation();
        int[] books = { 20, 10, 30 };
        int students = 2;
        System.out.println(sol.findPages(books, students));
    }
}
