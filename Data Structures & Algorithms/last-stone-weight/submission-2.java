class Solution {
    public int lastStoneWeight(int[] stones) {
        int[] freq = new int[101];
        for(int stone : stones){
            freq[stone]++;
        }
        boolean egol = false;

        while(true){
            int x = -1;
            int y = -1;
            for(int ix = 100;ix>=0;ix--){
                
                if(x != -1 && y != -1){
                    break;
                }
                if(freq[ix]>0 && x==-1){
                    freq[ix]--;
                    x = ix;
                }
                if(freq[ix]>0){
                    freq[ix]--;
                    y = ix;
                }
            }
            System.out.println(x+" "+y);
            
            if(x == -1) return 0;
            if(y == -1) return x;
            freq[x - y]++;
        }

    }
}
