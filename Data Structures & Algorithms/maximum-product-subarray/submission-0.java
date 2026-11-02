
class Solution {
    public int maxProduct(int[] nums) {
        int maxEnding = nums[0];
        int minEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            int a = x * maxEnding;
            int b = x * minEnding;

            maxEnding = Math.max(x, Math.max(a, b));
            minEnding = Math.min(x, Math.min(a, b));

            ans = Math.max(ans, maxEnding);
        }

        return ans;
    }
}
