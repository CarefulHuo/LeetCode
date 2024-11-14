package cf.carefulhuo.leetcode.sort;


/**
 * 215.数组中的第K个最大元素
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest2(nums, k));
    }

    /**
     * 常规的快速排序，无法搞定这个题目，因为快速排序最坏的时间复杂度为O(n^2)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    private static void quickSort(int[] nums, int p, int r) {
        if (p >= r) return;
        int q = partition(nums, p, r);
        quickSort(nums, p, q - 1);
        quickSort(nums, q + 1, r);
    }

    private static int partition(int[] nums, int p, int r) {
        int pivot = nums[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (nums[j] > pivot) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
            }
        }
        int tmp = nums[i];
        nums[i] = nums[r];
        nums[r] = tmp;
        return i;
    }

    /**
     * 归并排序，搞定
     */
    public static int findKthLargest2(int[] nums, int k) {
        mergeSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private static void mergeSort(int[] nums, int p, int r) {
        if (p >= r) return;
        int q = (p + r) / 2;
        mergeSort(nums, p, q);
        mergeSort(nums, q + 1, r);
        merge(nums, p, q, r);
    }

    private static void merge(int[] nums, int p, int q, int r) {
        int[] leftArray = new int[q - p + 2];
        for (int i = 0; i < q - p + 1; i++) {
            leftArray[i] = nums[p + i];
        }
        leftArray[q - p + 1] = Integer.MAX_VALUE;

        int[] rightArray = new int[r - q + 1];
        for (int i = 0; i < r - q; i++) {
            rightArray[i] = nums[q + 1 + i];
        }
        rightArray[r - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }
    }
}
