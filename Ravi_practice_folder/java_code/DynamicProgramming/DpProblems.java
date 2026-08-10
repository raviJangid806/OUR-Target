import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DpProblems {

    // leetcode Question: 70. Climbing Stairs
    public int climbStairs(int n) {
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n, -1));
        dp.set(0, 0);
        dp.set(1, 1);
        System.out.println(dp);
        return getClimbStairs(n, dp);
    }

    public int getClimbStairs(int n, List<Integer> dp) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (dp.get(n - 1) != -1) {
            return dp.get(n - 1);
        }
        dp.set(n - 1, getClimbStairs(n - 1, dp) + getClimbStairs(n - 2, dp));

        System.out.println(dp);
        return dp.get(n - 1);
    }

    // leetcode Question: 198. House Robber
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        List<Integer> dp = new ArrayList<>(Collections.nCopies(nums.length, 0));
        dp.set(0, nums[0]);
        dp.set(1, Math.max(nums[0], nums[1]));

        for (int i = 2; i < nums.length - 1; i++) {
            dp.set(i, Math.max(dp.get(i - 1), dp.get(i - 2) + nums[i]));
        }
        if (nums.length > 2) {
            dp.set(nums.length - 1,
                    Math.max(dp.get(nums.length - 2), dp.get(nums.length - 3) + nums[nums.length - 1] - nums[0]));
        }
        // System.out.println(dp);
        return dp.get(nums.length - 1);
    }
}
