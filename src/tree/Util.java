package tree;

import java.util.List;

public class Util {
	public static void display(List<?> list) {
		for (Object o : list) {
			System.out.print(o + " ");
		}
		System.out.println();
	}
}
