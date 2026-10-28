class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for(int c : nums){
            x = x ^c;
        }

        return x;
    }
}
