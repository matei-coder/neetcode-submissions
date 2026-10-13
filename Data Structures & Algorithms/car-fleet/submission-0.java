class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        for (int i = 0; i < position.length; i++) {
            pq.offer(new int[]{position[i], speed[i]});
        }

        int fleets = 0;
        double lastTime = -1;

        while (!pq.isEmpty()) {
            int[] car = pq.poll();

            double time = (target - car[0]) / (double) car[1];

            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
        }

        return fleets;
    }
}