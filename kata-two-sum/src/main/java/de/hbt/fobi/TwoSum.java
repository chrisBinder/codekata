package de.hbt.fobi;


import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] solution(int[] nums, int target) {
        Map<Integer, Integer> complementToIndex = new HashMap<>();
        int[] result = new int[]{};
        for (int i = 0; i <  nums.length; i++) {
            int complement = target - nums[i];
            if (complementToIndex.containsKey(complement)) {
                result = new int[]{complementToIndex.get(complement), i};
            } else {
                complementToIndex.put(nums[i], i);
            }
        }
        return result;
    }
}
