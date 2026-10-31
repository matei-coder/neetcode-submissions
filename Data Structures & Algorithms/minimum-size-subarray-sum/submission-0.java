class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int currSum = 0; 
        for(int right = 0; right< len ; right++){
            currSum += nums[right];
            if(currSum >= target){
                minLen = Math.min(minLen , right - left+1);
            }
            //System.out.println(right+" "+left);
            while(currSum > target){
                currSum -= nums[left++];
                if(currSum >= target){
                minLen = Math.min(minLen , right - left+1);
            }
            }
        }


        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}