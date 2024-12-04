package cf.carefulhuo.leetcode.hash;

import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 * 解题思想：滑动窗口、哈希
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>(n);
        char[] chars = s.toCharArray();

        int rk = -1;
        int maxLength = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i != 0) {
                // 左指针移动一位，就要移除掉一个字符，因为当左指针移动时，就说明上一个左指针和右指针之间出现了重复的元素，要重新开始从第一个元素开始，所以要移除掉上一个左指针
                set.remove(chars[i - 1]);
            }
            // 移动右指针，直到右指针到元素末尾或者右指针指向的元素和左指针指向的元素重复
            while (rk + 1 < n && !set.contains(chars[rk + 1])) {
                set.add(chars[rk + 1]);
                rk++;
            }
            // 为什么是 rk - i + 1，因为 rk 是一个指针，指向的是当前窗口的最后一个元素，而 i 是窗口的左边界，所以窗口的长度是 rk - i + 1
            maxLength = Math.max(maxLength, rk - i + 1);
        }

        return maxLength;
    }
}
