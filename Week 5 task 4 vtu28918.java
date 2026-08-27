class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;

        int currentMin = 0;
        int minSum = Integer.MAX_VALUE;

        for (int num : nums) {
            // Kadane for maximum subarray
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane for minimum subarray
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            totalSum += num;
        }

        // If all elements are negative, wrapping would give 0,
        // which is not allowed because the subarray must be non-empty.
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum of:
        // 1. Normal subarray
        // 2. Circular subarray
        return Math.max(maxSum, totalSum - minSum);
    }
}

Output

[1, -2, 3, -2]
3
