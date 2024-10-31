package cf.carefulhuo.leetcode.array;


/**
 * <p>
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按 升序 排列
 * </p>
 *
 * @author hwy
 * @version 1.0.0
 * @description 删除排序数组中的重复项
 * @date 2023/4/2123:12
 */
public class RemoveDuplicatesInSortedArray {

	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {
		// 去重后元素的个数
		int duplicatesSize = 0;
		for (int i = 0; i < nums.length; i++) {
			// 防止数组越界异常
			if (i == nums.length - 1) {
				break;
			}
			// 比较后一个与前一个元素的大小，并赋值
			if (nums[i + 1] > nums[i]) {
				++duplicatesSize;
				nums[duplicatesSize] = nums[i + 1];
			}
		}
		return duplicatesSize + 1;
	}
}
