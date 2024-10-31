package cf.carefulhuo.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 寻找数组中第三大的数，如果不存在第三大的数，返回最大的数。
 */
public class ThirdMax {

    public static void main(String[] args) {
//        int [] nums = {3, 2, 1};
        int[] nums = {3,2,2,2,1};
        int res = thirdMax(nums);
        System.out.println(res);
    }


    /**
     * 使用 java 的stream api，解决问题
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        nums = Arrays.stream(nums).distinct().sorted().toArray();
        int max = nums[nums.length - 1];
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < max) {
                count++;
                if (count == 2) {
                    return nums[i];
                }
            }
        }
        return max;
    }

    public static int thirdMax2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        return 0;
    }
}
