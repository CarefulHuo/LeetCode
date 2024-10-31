package cf.carefulhuo.leetcode.array;

/**
 * LeetCode 数组分类中的--移除元素
 */
public class RemoveElement {

    public static void main(String[] args) {
//        int[] nums = {0,1,2,2,3,0,4,2};
        int[] nums = {3, 3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1, k = 0;

        if (nums.length < 1) {
            return 0;
        }

        // 通过双重指针将重复元素放到数组最后
        while ((i != j)) {
            if (nums[i] == val && nums[j] != val) {
                nums[i] = nums[j];
                nums[j] = val;
                i++;
                continue;
            }
            if (nums[i] != val && nums[j] == val) {
                i++;
                continue;
            }
            if (nums[i] != val && nums[j] != val) {
                i++;
            }
            if (nums[i] == val && nums[j] == val) {
                j--;
            }
        }
        // 通过循环判断末尾元素重复个数，拉垮
        for (int l = nums.length - 1; l >= 0; l--) {
            if (nums[l] == val) {
                k++;
            } else {
                break;
            }
        }
        return nums.length - k;
    }
}
