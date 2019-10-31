package travellingSalesman;

import java.util.Stack;

public class DepthFirstSearch {
	
	private Stack<Integer> treeExplorerStack; 
	
	
	DepthFirstSearch(){
		treeExplorerStack = new Stack<Integer>(); 
	}
	
//	pseudo-code 
//	procedure DFS-iterative(G,v):
//		      let S be a stack
//		      S.push(v)
//		      while S is not empty
//		          v = S.pop()
//		          if v is not labeled as discovered:
//		              label v as discovered
//		              for all edges from v to w in G.adjacentEdges(v) do 
//		                  S.push(w)

	public void iterativeSearch(){
		
	}
	

}
