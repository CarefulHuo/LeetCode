package cf.carefulhuo.leetcode.array;


/**
 * <p>
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * </p>
 * myAtoi(string s) 的算法如下：
 * <p>
 * 1.读入字符串并丢弃无用的前导空格
 * 2.检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。
 * 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 3.读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 4.将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。
 * 如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 5.如果整数数超过 32 位有符号整数范围 [−2^31, 2^31− 1] ，需要截断这个整数，
 * 使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 231^− 1 的整数应该被固定为 231^− 1 。
 * 6.返回整数作为最终结果。
 * </p>
 *
 * @author hwy
 * @version 1.0.0
 * @description 字符串转换整数 (atoi)
 * @date 2023/3/2217:18
 */
public class StringToInteger {

	public static void main(String[] args) {
		System.out.println(myAtoi(" +12"));
	}

	public static Integer myAtoi(String s) {
		char[] chars = s.toCharArray();
		StringBuilder str = new StringBuilder();
		boolean notExitNum = true;
		boolean negativeNumber = false;
		int count = 0;
		Double resNum = 0.0;

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				// 如果前面已经存在 + 或 - 符号，则这时将空格认为为非数字字符，否则忽略掉
				if (count > 0) {
					count++;
				}
				// 说明已经存在数字，则这时将空格认为为非数字字符
				if (str.length() > 0) {
					break;
				}
				continue;
			}

			if (chars[i] == '-') {
				count++;
				// 说明已经存在数字，则这时将 - 认为为非数字字符
				if (str.length() > 0) {
					break;
				}
				negativeNumber = true;
				continue;
			}

			if (chars[i] == '+') {
				count++;
				// 说明已经存在数字，则这时将 + 认为为非数字字符
				if (str.length() > 0) {
					break;
				}
				continue;
			}

			// 说明 + - '' 三个符号中有两个连续存在的，故符合第 3 条规则
			if (count > 1) {
				return 0;
			}

			if (chars[i] == '.') {
				str.append(".");
				continue;
			}

			// 通过 ascii 码判断是否是数字
			if (Integer.valueOf(chars[i]) < 58
					&& Integer.valueOf(chars[i]) > 47) {
				notExitNum = false;
				str.append(chars[i]);

				// 判断组合后的数字是否介于 [-2^31,2^31-1]
				resNum = Double.valueOf(str.toString());
				if (negativeNumber) resNum = -resNum;
				if (resNum > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
				if (resNum < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
			} else {
				break;
			}
		}
		if (notExitNum) return 0;
		return resNum.intValue();
	}
}
