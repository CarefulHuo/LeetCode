package cf.carefulhuo.leetcode.sort;


import java.util.Arrays;

/**
 * 215.数组中的第K个最大元素
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
//        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 4;
        System.out.println(findKthLargest4(nums, k));
    }

    /**
     * 使用常规的快速排序，将数组排序完成之后，直接返回第k个元素的方式不行，会超时，因为快速排序的最坏时间复杂度是O(n^2)
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
        int q = partitionDesc(nums, p, r);
        quickSort(nums, p, q - 1);
        quickSort(nums, q + 1, r);
    }

    /**
     * 此处是按照降序排列，大数在左边，小数在右边
     *
     * @param nums
     * @param p
     * @param r
     * @return
     */
    private static int partitionDesc(int[] nums, int p, int r) {
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
     * 快速，但是只递归到要找的元素所在的位置，而不是对整个数组排序后，只返回第k大的元素
     * 此方法也不可行，最后一个测试用例超时
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest3(int[] nums, int k) {
        return quickSort2(nums, 0, nums.length - 1, k);
    }

    private static int quickSort2(int[] nums, int p, int r, int k) {
        if (p > r) return 0;
        // 找到 q，此时 q 左边比 q 大，q 右边比 q 小
        int q = partitionDesc(nums, p, r);
        if ((q + 1) == k) {
            // 此处返回的正好是第 K 大的元素
            return nums[q];
        } else if ((q + 1) < k) {
            // 说明要找的元素在右半边，继续递归
            return quickSort2(nums, q + 1, r, k);
        } else {
            // 说明要找的元素在左半边，继续递归
            return quickSort2(nums, p, q - 1, k);
        }
    }

    /**
     * 三向切分法，快速排序
     * 先使用三向切分法对数据进行预处理，将小于切割点的放到左边，等于切割点的放到中间，大于切割点的放到右边。
     * 再对数据进行快速排序，只不过是对两个数据组排序，而不是对整个数组进行排序。
     */
    public static int findKthLargest4(int[] nums, int k) {
        quickSort3(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }

    private static void quickSort3(int[] nums, int left, int right) {
        if (left >= right) return;
        int l = left;
        int k = left + 1;
        int r = right;
        int pivot = nums[l];

        while (k <= r) {
            if (nums[k] < pivot) {
                int tmp = nums[k];
                nums[k] = nums[l];
                nums[l] = tmp;
                l++;
                k++;
            } else if (nums[k] == pivot) {
                k++;
                // 此时的 nums[k] > pivot
            } else {
                // nums[r] < pivot，需要与 nums[l] 元素交换
                if (nums[r] < pivot) {
                    int tmp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = nums[k];
                    nums[k] = tmp;
                    r--;
                    k++;
                    l++;
                } else if (nums[r] > pivot) {
                    r--;
                } else {
                    int tmp = nums[k];
                    nums[k] = nums[r];
                    nums[r] = tmp;
                    r--;
                    k++;
                }
            }
        }

        quickSelect(nums, left, l - 1);
        quickSelect(nums, r + 1, right);
    }

    public static void quickSelect(int[] nums, int p, int r) {
        if (p >= r) return;
        int q = partitionAsc(nums, p, r);
        quickSelect(nums, p, q - 1);
        quickSelect(nums, q + 1, r);
    }

    private static int partitionAsc(int[] nums, int p, int r) {
        int pivot = nums[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (nums[j] < pivot){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i++] = tmp;
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
