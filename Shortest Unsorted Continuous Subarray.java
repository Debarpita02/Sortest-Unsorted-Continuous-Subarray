public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        
        // Find the left boundary of the unsorted subarray
        while (left < n - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }
        
        // If we reached the end, the array is already sorted
        if (left == n - 1) {
            return 0;
        }
        
        // Find the right boundary of the unsorted subarray
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }
        
        // Find the minimum and maximum values within the unsorted subarray
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        // Extend the left and right boundaries to include any elements greater than min and less than max
        while (left > 0 && nums[left - 1] > min) {
            left--;
        }
        while (right < n - 1 && nums[right + 1] < max) {
            right++;
        }
        
        // Calculate the length of the unsorted subarray
        return right - left + 1;
    }
}