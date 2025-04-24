import Homework4.BellmanFord;
import utils.Graph;

public class Driver {

    public static void main(String[] args) {
        // run anything here.

        Graph G = new Graph();

        G.addVertex("A");
        G.addVertex("B");
        G.addVertex("C");
        G.addVertex("D");
        G.addVertex("E");
        G.addVertex("F");
        G.addVertex("G");

        G.addEdge("A", "B", 15);
        G.addEdge("A", "C", -10);
        G.addEdge("B", "D", 5);
        G.addEdge("C", "D", -3);
        G.addEdge("D", "E", 8);
        G.addEdge("E", "F", -12);
        G.addEdge("F", "G", 6);
        G.addEdge("G", "A", -4);
        G.addEdge("C", "E", 7);
        G.addEdge("B", "F", -1);

        BellmanFord bf = new BellmanFord();
        int[] distFromSrc = bf.bellmanFord(G, "A");

    }

}

//KSmaller ks = new KSmaller();
//System.out.println(ks.areKSmallerElements(4, 32));
