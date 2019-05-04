package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeIntervals {
	// [56. Merge Intervals](https://leetcode.com/problems/merge-intervals/description/)
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) return res;
        if (intervals.size() == 1) {
            res.add(intervals.get(0));
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start < i2.start) return -1;
	            else if (i1.start > i2.start) return 1;
	            else return 0;
			}
            
        });
        Interval temp = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (temp.end < intervals.get(i).start) {
                res.add(temp);
                temp = intervals.get(i);
            }
            else{
                temp = new Interval(temp.start, Math.max(intervals.get(i).end, temp.end));
            }
        }
        res.add(temp);
        return res;
    }
}
