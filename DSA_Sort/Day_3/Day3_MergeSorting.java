package DSA.April_30;


import java.util.Arrays;
public class Day3_MergeSorting {
        public static void mergeSort(int[] arr, int left, int right, int[] tempArr) {
             if (left < right) {
                 int mid = (left + right) / 2;
                 mergeSort(arr, left, mid, tempArr);
                 mergeSort(arr, mid + 1, right, tempArr);
                 merge(arr, left, mid, right, tempArr);
             }
        }

        public static void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
             for (int i = left; i <= right; i++) {
                 tempArr[i] = arr[i];
             }

             int i = left;
             int j = mid + 1;
             int k = left;

             while (i <= mid && j <= right) {
                 if (tempArr[i] <= tempArr[j]) {
                     arr[k] = tempArr[i];
                     i++;
                 } else {
                     arr[k] = tempArr[j];
                     j++;
                 }
                 k++;
             }

             while (i <= mid) {
                 arr[k] = tempArr[i];
                 i++;
                 k++;
             }

             while (j <= right) {
                 arr[k] = tempArr[j];
                 j++;
                 k++;
             }
        }

        public static int[] sortArray(int[] nums) {
            int[] tempArr = new int[nums.length];
            mergeSort(nums, 0, nums.length - 1, tempArr);
            return nums;
        }

        public static void main(String[] args) {
            int[] nums = {5, 2, 3, 1};
            int[] sortedNums = sortArray(nums);
            System.out.println(Arrays.toString(sortedNums));
        }


}
