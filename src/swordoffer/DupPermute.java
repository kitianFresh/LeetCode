package swordoffer;

import java.util.ArrayList;
import java.util.Collections;

public class DupPermute {
	public ArrayList<String> Permutation(String str) {
	       char[] chs = str.toCharArray();
	       //Arrays.sort(chs);
	       StringBuilder sb = new StringBuilder(String.valueOf(chs));
	       ArrayList<String> res = new ArrayList<String>();
	       if (str == null || str.length() == 0) return res;
	       permute(res, sb, 0);
	       Collections.sort(res);
	       return res;
	    }
	     
	    public void permute(ArrayList<String> res, StringBuilder sb, int pos) {
	       if (pos == sb.length()) {
	           res.add(sb.toString());
	           return;
	       }
	       for (int i = pos; i < sb.length(); i++) {
	           if (i != pos && sb.charAt(i) == sb.charAt(pos)) continue; // 在不同的位置上相同的值,交换了也没用
	           char temp = sb.charAt(i);
	           sb.setCharAt(i, sb.charAt(pos));
	           sb.setCharAt(pos, temp);
	           permute(res, sb, pos + 1);
	           temp = sb.charAt(i);
	           sb.setCharAt(i, sb.charAt(pos));
	           sb.setCharAt(pos, temp);
	           
	            
	       }
	       return;
	    }
}
