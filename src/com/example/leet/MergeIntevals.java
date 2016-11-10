package com.example.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *Given a collection of intervals, merge all overlapping intervals.
    For example,
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18]. * 
 * 
 * @author bin zhou
 * @since 2016-02-03
 */

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}

//class IntervalSortByStartComparator implements Comparator<Interval>{
//        public int compare(Interval o1, Interval o2) {
//        return o1.start - o2.start;
//    }
//}

public class MergeIntevals{
    public static void main(String[] args) {
        ArrayList<Interval> input = new ArrayList<Interval>() ;
        input.add(new Interval(1,4));
        input.add(new Interval(2, 5));
        
        ArrayList<Interval> result = merge(input);
        
        for (Interval curInterval : result)
            System.out.println(curInterval.start + " - " +  curInterval.end + ", ");
    }
    
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size()<2) return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>(){
             public int compare(Interval o1, Interval o2) {
                 return o1.start - o2.start;
             }
            
        });
        ArrayList<Interval> result = new ArrayList<Interval>() ;
        Interval pre = null;
        for (Interval cur : intervals){
            if(pre==null){
                pre = cur;
            } else {
                if (cur.start <= pre.end ) {
                    pre.end = cur.end > pre.end ? cur.end : pre.end;
                } else if (cur.start > pre.end) {
                    result.add(pre);
                    pre = cur;
                }                   
            }
        }
        
        result.add(pre);
        
        return result; 
    }   
}



