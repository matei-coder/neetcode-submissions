/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals , (a,b)->{
            return a.start - b.start;
        });
        int iend = 0;
        for(Interval i : intervals){
            if(i.start < iend) return false;
            iend = i.end;
        }

        return true;
    }
}
