package Ravi_practice_folder.java_code.ImportantTopics;

import java.util.ArrayList;
import java.util.List;

public class LargeSet {

    List<Integer> subset = new ArrayList<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {

        List<Integer> currentSubset = new ArrayList<>();
        call(nums, 0, currentSubset, 0);
        return subset;
    }

    Boolean call(int[] nums, int index, List<Integer> currentSubset, int size) {
        if (nums.length == index) {
            if (isPossible(currentSubset)) {
                this.subset = currentSubset;
                return true;
            }
            currentSubset.clear();
            return false;
        }
        currentSubset.add(nums[index]);
        call(nums, index + 1, currentSubset, size + 1);
        call(nums, index + 1, currentSubset, size);
        return false;
    }

    boolean isPossible(List<Integer> currentSubset) {
        for (int i = 0; i < currentSubset.size(); i++) {
            for (int j = i + 1; j < currentSubset.size(); j++) {
                if (currentSubset.get(i) % currentSubset.get(j) != 0
                        && currentSubset.get(j) % currentSubset.get(i) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
