package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
	public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        String cur = "";
        dfs(res, cur, 3, 3);
        return res;
    }
    
    public void dfs(ArrayList<String> res, String current, int leftRemain, int rightRemain) {
        if (leftRemain > rightRemain) return;
        
        if (leftRemain == 0 && rightRemain == 0) {
            res.add(current);
            return ;
        }
        
        if (leftRemain > 0) {
            dfs(res, current + "(", leftRemain - 1, rightRemain);
        }
        
        if (rightRemain > 0) {
            dfs(res, current + ")", leftRemain, rightRemain - 1);
        }
    }
}
