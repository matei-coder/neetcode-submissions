class Solution {
    public int openLock(String[] deadends, String target) {
        //add all element into a HashSet for O(1) lookup
        Set<String> deadEnds = new HashSet<>();
        for(String deadend : deadends) deadEnds.add(deadend);
        Set<String> visited = new HashSet<>();

        if(deadEnds.contains("0000")) return -1;
        if(target.equals("0000")) return 0;

        int length = 0;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int j=0;j<size;j++){
                String curr = q.poll();
                if(curr.equals(target)) return length;
                
                
                for(int i=0;i<4;i++){
                    char[] c  = curr.toCharArray(); 
                    if(c[i] - '9' < 0)
                    c[i] = (char)('0'+((c[i] - '0')+1));
                    else{
                        c[i] = '0';
                    }
                    String next = new String(c);
                    if(!visited.contains(next) && !deadEnds.contains(next)){
                        q.offer(next);
                        visited.add(next);
                    }

                }
                

                
                for(int i=0;i<4;i++){
                    char[] c  = curr.toCharArray(); 
                    if(c[i] - '0' > 0)
                    c[i] = (char)('0' + ((c[i] - '0')-1));
                    else{
                        c[i] = '9';
                    }
                    String next = new String(c);
                    if(!visited.contains(next) && !deadEnds.contains(next)){
                        q.offer(next);
                        visited.add(next);
                    }
                    
                }
                

            }
            length++;
                 
        }




        return -1;

    }

}