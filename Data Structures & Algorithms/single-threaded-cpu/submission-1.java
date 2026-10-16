class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] proceses = new int[n][3];
        for(int i=0;i<n;i++){
            proceses[i][0] = tasks[i][0]; // enqueue time
            proceses[i][1] = tasks[i][1]; // processig time
            proceses[i][2] = i; // index

        }
        //avalabile reprsents all trhe procesess that can be started at curr time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b)->{
            if(a[1] != b[1]){
                return a[1] - b[1];
            }
            else {
                return a[2] - b[2];
            }
        });

        Arrays.sort(proceses , (a,b)->{
            return a[0] - b[0];
        });

        int time = 0;
        int busytime = 0;
        int [] ans = new int[n];
        int ix = 0;
        int i =0;

        while(i<n || !pq.isEmpty()){
            while(i<n && proceses[i][0] <= time){
                pq.add(proceses[i]);
                i++;
            }
            if(busytime <= time && !pq.isEmpty()){
                ans[ix++] = pq.peek()[2];
                busytime = pq.poll()[1] + time;
                time = busytime;
            }else{
                time++;
            }


            
        }

        return ans;


    }
}