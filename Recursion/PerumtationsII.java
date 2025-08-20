import java.util.*;

public class PerumtationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, nums, new ArrayList<>(), used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, ArrayList<Integer> tempList, boolean[] used) {

        if (tempList.size() == nums.length && !result.contains(tempList)) {
            result.add(new ArrayList<>(tempList));
            // System.out.println("");
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i] == true) {
                continue;
            }

            tempList.add(nums[i]);
            used[i] = true;

            backtrack(result, nums, tempList, used);

            // System.out.println(tempList);

            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }

    }

    public static void main(String[] args) {
        PerumtationsII solver = new PerumtationsII();
        int[] nums = { 1, 1, 2 };
        List<List<Integer>> perms = solver.permuteUnique(nums);
        for (List<Integer> perm : perms) {
            System.out.println(perm);
        }
    }
}
