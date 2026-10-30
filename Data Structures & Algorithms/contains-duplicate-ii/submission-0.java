class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> currElements =  new HashSet<>();
        for(int i=0;i<k;i++){
            if(currElements.contains(nums[i])) return true;
            currElements.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(currElements.contains(nums[i])) return true;
            currElements.add(nums[i]);
            currElements.remove(nums[i-k]);
        }


        return false;
    }
}