package cf.carefulhuo.leetcode.find.binarysearch;

import java.util.Arrays;

/**
 * leetcode34.在排序数组中查找元素的第一个和最后一个位置
 *
 * @see <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=problem-list-v2&envId=binary-search"/>
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] testRes1 = searchRange(nums, 8);
        System.out.println(Arrays.toString(testRes1));
        int[] testRes2 = searchRange(nums, 6);
        System.out.println(Arrays.toString(testRes2));
        nums = new int [0];
        int[] testRes3 = searchRange(nums, 0);
        System.out.println(Arrays.toString(testRes3));
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];

        res[0] = binarySearchFisrt(nums, target);
        res[1] = binarySearchLast(nums, target);

        return res;
    }

    private static int binarySearchLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    private static int binarySearchFisrt(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


}
