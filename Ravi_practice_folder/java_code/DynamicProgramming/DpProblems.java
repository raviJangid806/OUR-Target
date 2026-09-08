import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

    public boolean frogJump(int[] stones) {
        int i = 0;
        int space = stones[1] - stones[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < stones.length; j++) {
            map.put(stones[j], j);
        }
        for (int j = 0; j < stones.length; j++) {
            System.out.print(stones[j] + ",");
        }
        System.out.println();
        System.out.println(map);
        // if (map.containsKey(7)) {
        // System.out.println("7 is present");
        // System.out.println("Index of 7 is: " + map.get(7));
        // }
        // return true;
        return jump(stones, i, space, map);

    }

    public boolean jump(int[] arr, int i, int space, HashMap<Integer, Integer> map) {
        if (map.containsKey(arr[i] + space) && map.get(arr[i] + space) > i) {
            space = arr[map.get(arr[i] + space)] - arr[i];
            i = map.get(arr[i] + space);
        } else {
            return false;
        }
        if (i == arr.length - 1) {
            return true;
        }
        if (i >= arr.length - 1) {
            return false;
        }

        return (jump(arr, i, space + 1, map) || jump(arr, i, space, map) || jump(arr, i, space - 1, map));
    }

    public int minCostClimbingStairs(int[] cost) {
        List<Integer> dp = new ArrayList<>();
        dp.add(cost[0]);
        if (cost.length <= 1) {
            return dp.get(0);
        }
        dp.add(Math.min(cost[0], cost[1]));
        for(int i=2; i<cost.length; i++) {
            dp.add(Math.min(dp.get(i-1), dp.get(i-2)) + cost[i]);
        }
        return Math.min(dp.get(dp.size() - 1), dp.get(dp.size() - 2));

    }
    
    public int findTargetSumWays(int[] nums, int target) {
        return getTargetSumWays(nums, target,0,0);
    }

    int getTargetSumWays(int[] arr,int target,int sum,int index){
        if(sum == target && index == arr.length){
            return 1;
        }
        if(index == arr.length){
            return 0;
        }
        return getTargetSumWays(arr, target, sum + arr[index],  index + 1) + getTargetSumWays(arr, target, sum - arr[index], index + 1);
    }


}
