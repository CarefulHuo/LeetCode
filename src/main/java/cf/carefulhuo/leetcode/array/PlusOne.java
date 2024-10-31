package cf.carefulhuo.leetcode.array;


/**
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * </p>
 *
 * @author hwy
 * @version 1.0.0
 * @description 加一
 * @date 2023/4/2123:55
 */
public class PlusOne {

	public static void main(String[] args) {
		int[] digits = {9, 9, 9, 9};
		digits = plusOne(digits);
		for (int i = 0; i < digits.length; i++) {
			System.out.println(digits[i]);
		}
	}

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + 1 > 9) {
				// 加一后，等于 10 的，都进一，数值改为 0
				digits[i] = 0;
			} else {
				// 加一后，不等于 0 的，数值加一，跳出循环，防止多加一倍
				digits[i] = digits[i] + 1;
				break;
			}
		}
		// 处理数组元素全为 9 的特殊情况
		if (digits[0] == 0) {
			int[] digitsNew = new int[digits.length + 1];
			digitsNew[0] = 1;
			for (int i = 1; i < digitsNew.length; i++) {
				digitsNew[i] = 0;
			}
			return digitsNew;
		}
		return digits;
	}
}
