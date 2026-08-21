class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }

        return nums;
    }
}

Output

nums = [1, 2, 3, 4]
[1, 3, 6, 10]
