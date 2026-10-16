class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] freq = new int[2001];
        for(int x: nums){
            freq[x+1000]++;
        }

        for(int i=2000;i>=0;i--){
            while(freq[i]>0){
                freq[i]--;
                k--;
                if(k==0) return i-1000;
            }
        }

        return -1;
    }
}
