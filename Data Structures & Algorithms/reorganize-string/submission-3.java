class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]){
                return b[1] - a[1];
            }else{
                return a[0] - b[0];
            }
        });
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.add(new int[]{i , freq[i]});
            }
            if(freq[i]> (s.length()+1)/2  ) return "";
        }
        StringBuilder sb = new StringBuilder();
        int[] prev = null;

        while(!pq.isEmpty()){
            int[] first = pq.poll();

           
            sb.append((char)(first[0]+'a'));
            first[1]--;

            if(prev!=null && prev[1]>0 ){
                pq.add(prev);
            }

            prev = first;
            
            
            
        }


        return sb.toString();





    }
}