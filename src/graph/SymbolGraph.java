package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class SymbolGraph {
	// 必须要加入符号表做映射
	private HashMap<String, Integer> st;
	private String[] keys;
	private Graph G;
	public SymbolGraph(String filename, String delim) throws IOException {
		File file = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		st = new HashMap<String, Integer>();
		while ((line=br.readLine()) != null) {
			String[] a = line.split(delim);
			for (int i=0; i < a.length; i++) {
				if (!st.containsKey(a[i]))
					st.put(a[i], st.size());
			}
		}
		keys = new String[st.size()];
		for (String name : st.keySet()) {
			keys[st.get(name)] = name;
		}
		
		// 第二遍, 构造这个图
		G = new Graph(st.size());
		file = new File(filename);
		br = new BufferedReader(new FileReader(file));
		while ((line=br.readLine()) != null) {
			String[] a = line.split(delim);
			int v = st.get(a[0]);
			for (int i=1; i < a.length; i++) {
				G.addEdge(v, st.get(a[i]));
			}
		}
	}
	
	public boolean contains(String key) {
		return st.containsKey(key);
	}
	
	public int index(String key) {
		return st.get(key);
	}
	
	public String name(int v) {
		return keys[v];
	}
	
	public Graph G() {
		return this.G;
	}
	
	public static void main(String[] args) throws IOException {
		SymbolGraph sg = new SymbolGraph(args[0], args[1]);
		Graph G = sg.G();
		String source = args[2];
		if (!sg.contains(source)) {
			System.out.println(source + " not in database.");
			return ;
		}
		int s = sg.index(source);
		BreathFirstPath bfp  = new BreathFirstPath(G, s);
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			String sink = cin.nextLine();
			if (sg.contains(sink)) {
				int t = sg.index(sink);
				if (bfp.hasPathTo(t)) {
					Stack<Integer> stack = (Stack<Integer>)bfp.pathTo(t);
					while (!stack.isEmpty()) {
						System.out.println("\t" + sg.name(stack.pop()));
					}
				}
				else {
					System.out.println("not connected!");
				}
			}
			else {
				System.out.println("not in database!");
			}
		}
	} 
}
