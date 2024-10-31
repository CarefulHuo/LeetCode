package cf.carefulhuo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        findDisappearedNumbers(nums).forEach(integer -> System.out.println(integer));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        int index;

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            index = i + 1;
            if (nums[i] == index){
                continue;
            }

        }
        return res;
    }
}
