package cf.carefulhuo.leetcode.array;


import java.util.stream.IntStream;

/**
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * </p>
 *
 * @author hwy
 * @version 1.0.0
 * @description 寻找两个正序数组的中位数
 * @date 2023/3/2215:51
 */
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {1, 2};
		int[] nums2 = {3};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0
				&& nums2.length == 0) {
			return 0;
		}
		int[] res = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).sorted().toArray();
		if (res.length % 2 != 0) {
			return res[res.length / 2];
		}

		int sum = (res[res.length / 2] + res[(res.length / 2) - 1]);
		return sum / 2.0;
	}
}
