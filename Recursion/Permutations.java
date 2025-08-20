import java.util.*;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums);
        return resultList;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums) {

        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int num : nums) {
            if (tempList.contains(num)) {
                continue;
            }
            tempList.add(num);

            backtrack(result, tempList, nums);

            tempList.remove(tempList.size() - 1);
        }

    }

    public static void main(String[] args) {
        Permutations solver = new Permutations();

        int[] nums = { 1, 2, 3 };
        List<List<Integer>> permutations = solver.permute(nums);

        System.out.println("\n🔚 All permutations:");
        for (List<Integer> perm : permutations) {
            System.out.println(perm);
        }
    }
}
