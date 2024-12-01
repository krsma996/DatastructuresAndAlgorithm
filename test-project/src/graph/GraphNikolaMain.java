package graph;

public class GraphNikolaMain {

	public static void main(String[] args) {
		
		GraphNikola graph = new GraphNikola();
		graph.addVertex("A");	
		graph.addVertex("B");
		graph.addVertex("C");
		
	
		
		graph.addEdge("A", "B");
		graph.addEdge("C", "A");
		
		graph.addEdge("B", "C");
		
		graph.removeNode("A");
		
		graph.pringGraph();

	}

}
