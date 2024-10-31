package cf.carefulhuo.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 给你一个整数数组 nums 。
 * 如果任一值在数组中出现 至少两次 ，返回 true ；
 * 如果数组中每个元素互不相同，返回 false 。
 * </p>
 *
 * @author hwy
 * @version 1.0.0
 * @description 存在重复元素
 * @date 2023/4/2123:39
 */
public class ExistRepeatElement {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		System.out.println(containsDuplicateNew(nums));
	}

	public static boolean containsDuplicateNew(int[] nums) {
		Set<Integer> dupSet = new HashSet<>();
		// 利用 Set 集合的特性解决问题
		for (int i = 0; i < nums.length; i++) {
			if (dupSet.contains(nums[i])) {
				return true;
			}
			dupSet.add(nums[i]);
		}
		return false;
	}
}
