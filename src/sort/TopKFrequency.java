package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class TopKFrequency {
	
	
	// 低效率版本,空间复杂度 O(n) 时间复杂度nlgn
	static class ValueComparator implements Comparator<Integer> {

        private Map<Integer, Integer> map;

        public ValueComparator(Map<Integer, Integer> map) {
            this.map = map;
        }

        public int compare(Integer a, Integer b) {
            return map.get(b).compareTo(map.get(a));
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        List<Integer> result = new ArrayList<Integer>();
        
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
 
        for(int i: nums){
            if(counter.containsKey(i)){
                counter.put(i, counter.get(i)+1);
            }else{
                counter.put(i, 1);
            }    
        }
 
        TreeMap<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(new ValueComparator(counter));
        sortedMap.putAll(counter);
 
        int i=0;
        for(Map.Entry<Integer, Integer> entry: sortedMap.entrySet()){
            result.add(entry.getKey());
            i++;
            if(i==k)
                break;
        }
 
        return result;
    }
    
    // 再次采用最小堆的性质,始终维护当前最大的k个数
    static class Pair {
    	int number;
    	int count;
    	public Pair(int number, int count) {
    		this.number = number;
    		this.count = count;
    	}
        
    }
    public List<Integer> topKFrequent1(int[] nums, int k) {
    	if (nums == null || nums.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair> (new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                return a.count - b.count;
            }
        });
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            minHeap.offer(pair);
            if (minHeap.size()>k) {
                minHeap.poll();
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        while(minHeap.size()>0) {
            res.add(minHeap.poll().number);
        }
        Collections.reverse(res);
        return res;
    }
    
    //　bucket sort
    public List<Integer> topKFrequent2(int[] nums, int k) {
    	if (nums == null || nums.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        ArrayList<Integer>[] bucket = new ArrayList[nums.length+1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<Integer>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        
        List<Integer> res = new ArrayList<Integer>();
        for (int i = bucket.length-1; i > 0; i--) {
            for (int j = 0; bucket[i] != null && j < bucket[i].size(); j++) {
                res.add(bucket[i].get(j));
                k --;
                if (k == 0) return res;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
    	int[] a = new int[]{1,1,1,2,2,3};
    	TopKFrequency tkf = new TopKFrequency();
    	System.out.println(tkf.topKFrequent(a, 2));
    }
}