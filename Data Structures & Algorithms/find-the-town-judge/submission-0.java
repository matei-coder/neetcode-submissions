class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusting = new int[n+1];
        for(int[] individualTrust : trust){
            trusting[individualTrust[1]]++;
            trusting[individualTrust[0]]--;
        }

        for(int i=1;i<=n;i++){
            //System.out.print(trusting[i]);
            if(trusting[i] == n-1) return i;
        }
        return -1;
    }
}