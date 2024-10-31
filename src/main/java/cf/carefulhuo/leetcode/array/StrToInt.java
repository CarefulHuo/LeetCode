package cf.carefulhuo.leetcode.array;

/**
 * 将字符串数字转为数值
 *
 * @author hwy
 * @date 2023/06/21 16:40
 */
public class StrToInt {

    public static void main(String[] args) {
        System.out.println(strToInt("  0000000000012345678"));
    }

    public static int strToInt(String str) {
        boolean fushu = false;
        boolean firstNumber = false;
        StringBuffer number = new StringBuffer();
        str = str.trim();
        if (str.length() < 1
                || "-".equals(str)
                || "+".equals(str)) {
            return 0;
        }

        if ("-".equals(str.substring(0, 1))) {
            fushu = true;
            str = str.substring(1, str.length());
        } else if ("+".equals(str.substring(0, 1))) {
            str = str.substring(1, str.length());
        }

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((int) chars[i] < 48
                    || (int) chars[i] > 57) {
                if (i == 0) {
                    firstNumber = true;
                }
                break;
            } else {
                if (fushu && i == 0) {
                    number.append("-");
                }
                number.append(chars[i]);
//                if (number.toString().st("0")){
//                    number.toString().substring(1,number.toString().length());
//                }
            }
        }

        if (firstNumber) {
            return 0;
        }

        int length = String.valueOf(Integer.MIN_VALUE).length();
        if (number.toString().length() > length
                && !fushu) {
            return Integer.MAX_VALUE;
        }
        if (number.toString().length() > length
                && fushu) {
            return Integer.MIN_VALUE;
        }

        return Integer.valueOf(number.toString()).intValue();
    }
}
