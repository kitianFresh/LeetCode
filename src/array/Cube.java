package array;

import java.util.Scanner;

public class Cube {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
        int[] cube = new int[6];
        for (int i=0; i<cube.length; i++) {
            cube[i] = i+1;
        }
        
        for (int i=0; i<temp.length(); i++) {
        	reverse(cube, temp.charAt(i));
        }
		for (int i=0; i<cube.length; i++) {
			System.out.print(cube[i]);
		}
	}
    
    public static void reverse(int[] cube, char ch) {
        int temp;
        switch(ch) {
            case 'L':
                temp  = cube[4];
                cube[4] = cube[1];
                cube[1] = cube[5];
                cube[5] = cube[0];
                cube[0] = temp;
                break;
            case 'R':
                temp = cube[4];
                cube[4] = cube[0];
                cube[0] = cube[5];
                cube[5] = cube[1];
                cube[1] = temp;
                break;
            case 'F':
                temp = cube[4];
                cube[4] = cube[3];
                cube[3] = cube[5];
                cube[5] = cube[2];
                cube[2] = temp;
                break;
            case 'B':
                temp = cube[2];
                cube[2] = cube[5];
                cube[5] = cube[3];
                cube[3] = cube[4];
                cube[4] = temp;
            	break;
            case 'A':
                temp = cube[0];
                cube[0] = cube[3];
                cube[3] = cube[1];
                cube[1] = cube[2];
                cube[2] = temp;
                break;
            case 'C':
                temp = cube[0];
                cube[0] = cube[2];
                cube[2] = cube[1];
                cube[1] = cube[3];
                cube[3] = temp;
                break;
        }
        
	}
}
