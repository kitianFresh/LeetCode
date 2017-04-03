package stack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStack {

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
	
	@Test
	public void testBracketMatch() {
		System.out.println(Expr.bracketMatch("{[]{}(){[()]}}"));
		System.out.println(Expr.infixExprToPostfix("3+4*2/(1-5)^2^3"));
		System.out.println(Expr.inToPost("3+4*2/(1-5)^2^3^5^(8%2)"));
	}
	
	
}
