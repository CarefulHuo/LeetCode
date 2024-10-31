package cf.carefulhuo.leetcode.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 */
public class MajorityElement {

    public static void main(String[] args) {
        int [] nums = {2,2,1,1,1,2,2};
        System.out.println(new MajorityElement().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            } else {
                countMap.put(nums[i], 1);
            }
            if (countMap.get(nums[i]) > majorityCount) {
                return nums[i];
            }
        }
        return 0;
    }
}
