class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            ans[index++] = nums[i];      // xi
            ans[index++] = nums[i + n];  // yi
        }

        return ans;
    }
}

Output

[2,5,1,3,4,7]
3
[1,2,3,4,4,3,2,1]
4
[1,1,2,2]
2
