package cf.carefulhuo.leetcode.array;

/**
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 1. 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 2. 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 * </p>
 *
 * @author hwy
 * @version 1.0.0
 * @description 整数反转
 * @date 2023/3/2214:31
 */
public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(2147483647));
	}

	/**
	 * 整数反转
	 *
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		if (x == 0) {
			return 0;
		}

		// 将数字拆分
		char[] nums = String.valueOf(x).toCharArray();
		char[] reverseNums = new char[nums.length];
		boolean negativeNumber = false;

		// 如果是负数，将数组的长度减一
		if (x < 0) {
			negativeNumber = true;
			reverseNums = new char[nums.length - 1];
		}

		// 倒转数组
		for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
			if (negativeNumber && i == 0) {
				continue;
			}
			reverseNums[j] = nums[i];
		}

		// 将数组转换为数字
		Long reverseNum;
		if (negativeNumber) {
			reverseNum = Long.valueOf("-" + new String(reverseNums));
		} else {
			reverseNum = Long.valueOf(new String(reverseNums));
		}

		// 判断倒转后的数字是否越界
		if (reverseNum < Integer.MIN_VALUE
				|| reverseNum > Integer.MAX_VALUE) {
			return 0;
		}

		return reverseNum.intValue();
	}
}

