package com.buildingLogic.arraySpecial;

import java.util.ArrayList;
import java.util.List;

/*//Definition of Interval:
  class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
 }*/
 

public class InsertInterval {
   	/**
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	
    	int intervalsLength = intervals.size();
    	// If set is empty then simply insert
        // newInterval and return.
        if (intervalsLength == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        // Case 1 (new interval to be inserted at left corner)
        if (newInterval.end < intervals.get(0).start) {
            intervals.add(0,newInterval);
            return intervals;
        }

        //Case 2 (new interval to be inserted at right corner)
        if (newInterval.start > intervals.get(intervalsLength-1).end) {
            intervals.add(newInterval);
            return intervals;
        }

        //case 3 (New interval covers all existing intervals)
        if (newInterval.start < intervals.get(0).start &&
            newInterval.end > intervals.get(intervalsLength-1).end) {
            List<Interval> temp = new ArrayList<Interval>();
            temp.add(newInterval);
            return temp;
        }
        
        // Case 4 and Case 5
        // These two cases need to check whether
        // intervals overlap or not. For this we
        // can use a subroutine that will perform
        // this function.

        List<Interval> finalIntervals = new ArrayList<Interval>();

        for (int i = 0; i < intervalsLength; ++i) {
            boolean overlap = doOverlap(newInterval, intervals.get(i));

            if (!overlap) {
                finalIntervals.add(intervals.get(i));

                // Case 4 : To check if given interval
                // lies between two intervals.
                if (i < intervalsLength &&
                    newInterval.start > intervals.get(i).end &&
                    newInterval.end < intervals.get(i+1).start) {
                    finalIntervals.add(newInterval);
                }

                continue;
            }

            // Case 5 : Merge Overlapping Intervals.
            // Starting time of new merged interval is
            // minimum of starting time of both
            // overlapping intervals.
            Interval temp = new Interval(0,0);
            temp.start = Math.min(newInterval.start, intervals.get(i).start);

            // Traverse the set until intervals are
            // overlapping
            while (i < intervalsLength && overlap) {

                // Ending time of new merged interval
                // is maximum of ending time both
                // overlapping intervals.
                temp.end = Math.max(intervals.get(i).end, newInterval.end);


                if (i == intervalsLength - 1) {
                    overlap = false;
                } else {
                    overlap = doOverlap(intervals.get(i+1), newInterval);
                }
                ++i;
            }
            --i;
            finalIntervals.add(temp);
        }

		return finalIntervals;
    }

	public static boolean doOverlap(Interval intervalOne, Interval intervalTwo) {
    	    return Math.min(intervalOne.end, intervalTwo.end) >= Math.max(intervalOne.start, intervalTwo.start);
     }
}