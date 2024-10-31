package cf.carefulhuo.leetcode.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 给你一个 非空 整数数组 nums ，
 * 除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * </p>
 *
 * @author hwy
 * @version 1.0.0
 * @description 只出现一次的数字
 * @date 2023/4/2222:29
 */
public class NumberThatOccursOnlyOnce {

	public static void main(String[] args) {
		int[] nums = {2, 2, 1};
		System.out.println(singleNumber(nums));
	}

	public static int singleNumber(int[] nums) {
		Map<Integer, Boolean> intMap = new HashMap<>(nums.length / 2 + 1);
		for (int i = 0; i < nums.length; i++) {
			if (intMap.containsKey(nums[i])) {
				intMap.put(nums[i], false);
			} else {
				intMap.put(nums[i], true);
			}
		}

		Set<Map.Entry<Integer, Boolean>> intSet = intMap.entrySet();
		Iterator setIterator = intSet.iterator();
		while (setIterator.hasNext()) {
			Map.Entry<Integer, Boolean> res = (Map.Entry<Integer, Boolean>) setIterator.next();
			if (res.getValue() == true) {
				return res.getKey();
			}
		}
		return 0;
	}
}
