package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReconstructQueue {
	
	public static void main(String[] args) {
		ReconstructQueue rq = new ReconstructQueue();
		int[][] people = {{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}};
		int[][] ps = rq.reconstructQueue(people);
		
		for (int[] p : ps)
			System.out.print("[" + p[0] + ", " + p[1] + "], ");
	}
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0]) return -1;
				else if (o1[0] == o2[0]) {
					if (o1[1] < o2[1]) return -1;
					else if (o1[1] == o2[1]) return 0;
					else return 1;
				}
				else return 1;
			}
        });
		for (int[] p : people)
			System.out.print("[" + p[0] + ", " + p[1] + "], ");
		System.out.println();
		List<int[]> list = new ArrayList<int[]>(people.length);
		
		for (int i=0; i<people.length;i++) {
			list.add(people[i][1], people[i]);
		}
		int[][] res = new int[people.length][2];
		int i=0;
		for (int[] p : list) {
			res[i][0] = p[0];
			res[i++][1] = p[1];
		}
		return res;
        
    }
}
