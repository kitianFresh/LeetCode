package sort.comparebased;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sort.Util;

public class TestSort {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Before
	public void init(){
		
	}
	
	@After
	public void destroy(){
		
	}
	
	@org.junit.Test
	public void testQuickSort() {
		System.out.println("----------QuickSort--------");
		int[] A = new int[]{9,5,4,6,7,3,8,2,0,1};
//		arr = new int[]{2,2,2,2,2,2,2,2,2};
		Util.display(A);
		QuickSort.quickSort(A, 0, A.length-1);
		Util.display(A);
		
	}
	
	@org.junit.Test
	public void testHeapSort() {
		System.out.println("----------HeapSort--------");
		int[] A = new int[]{4,1,3,0,9,2,6,8,7,5};
		Util.display(A);
		HeapSort.heapSort(A, 0, A.length-1);
		Util.display(A);
		
		A = new int[]{9,8,7,6,5,4,3,2,1,0};
		Util.display(A);
		HeapSort.heapSort(A, 0, A.length-1);
		Util.display(A);
	}
	
	@org.junit.Test
	public void testInsertSort() {
		System.out.println("----------InsertSort--------");
		int[] A = new int[]{4,1,3,0,9,2,6,8,7,5};
		Util.display(A);
		InsertSort.insertSort(A);
		Util.display(A);
	}
	
	@org.junit.Test
	public void testSelectSort() {
		
		System.out.println("----------SelectSort--------");
		int[] A = new int[]{4,1,3,0,9,2,6,8,7,5};
		Util.display(A);
		SelectSort.selectSort(A);
//		SelectSort.swap(A, 0, 9);
		Util.display(A);
	}
	
	@org.junit.Test
	public void testShellSort() {
		System.out.println("----------ShellSort--------");
		int[] A = new int[]{4,1,3,0,9,2,6,8,7,5};
		Util.display(A);
		ShellSort.shellSort(A, 3);
		Util.display(A);
	}
	

}
