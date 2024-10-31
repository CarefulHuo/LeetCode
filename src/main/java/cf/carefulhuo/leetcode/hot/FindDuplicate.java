package cf.carefulhuo.leetcode.hot;

public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(new FindDuplicate().findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        for (int i = 0 ,j = nums.length - 1; i < nums.length && j >= 0; i++, j--) {
//            if (nums[])
        }
        return -1;
    }
}
