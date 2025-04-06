package Homework3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;




public class OutDegeeInDegree {

    private Graph graph;


    public void evenInOutDegree() {
        Node start = graph.getFirstNode();

        dfsApproach(start);

        graph.print();

    }


    public void dfsApproach(Node node) {
        for (int i = 0; i < node.getNumNeighbors(); i++) {
            if (node.getNeighbor(i).hasPath(node)) {
                System.out.println("removing " + node + " from " + node.getNeighbor(i));
                node.getNeighbor(i).removePath(node);
                dfsApproach(node.getNeighbor(i));
            }

        }
    }


    public void genGraph() {
        graph = testCase4();
        graph.print();
    }


    private Graph testCase4() {
        Graph g = new Graph();
        for (int i = 1; i <= 6; i++) {
            g.addNode(i);
        }

        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 5);

        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 6);
        g.addEdge(5, 6);

        return g;
    }


    private Graph testCase3() {
        Graph g = new Graph();
        for (int i = 1; i <= 7; i++) {
            g.addNode(i);
        }

        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        g.addEdge(1, 6);
        g.addEdge(1, 7);

        g.addEdge(7, 6);
        g.addEdge(3, 2);
        g.addEdge(4, 3);
        g.addEdge(5, 3);



        return g;
    }


    private Graph testCase2() {
        Graph g = new Graph();
        for (int i = 1; i <= 7; i++) {
            g.addNode(i);
        }

        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        g.addEdge(1, 6);
        g.addEdge(1, 7);

        g.addEdge(6, 7);
        g.addEdge(5, 4);
        g.addEdge(3, 2);

        return g;
    }


    private Graph testCase1() {
        Graph g = new Graph();
        for (int i = 1; i <= 5; i++) {
            g.addNode(i);
        }

        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 2);

        g.addEdge(1, 4);
        g.addEdge(1, 5);
        g.addEdge(4, 5);

        return g;
    }


}


class Graph {

    private HashMap<Integer, Node> nodes;

    public Graph() {
        nodes = new HashMap<>();
    }

    public void addNode(int key) {
        nodes.put(key, new Node(key));
    }

    public void addEdge(int start, int end) {
        nodes.get(start).addPath(nodes.get(end));
        nodes.get(end).addPath(nodes.get(start));
    }

    public Node getFirstNode() {
        return nodes.get(1);
    }

    public void print() {
        for (Node node : nodes.values()) {
            System.out.println(node);
        }
    }

}

class Node {

    private int key;
    private LinkedList<Node> adj;

    public Node(int num) {
        key = num;
        adj = new LinkedList<>();
    }

    public void addPath(Node node) {
        adj.add(node);
    }

    public void removePath(Node node) {
        adj.remove(node);
    }

    public boolean hasPath(Node node) {
        return adj.contains(node);
    }

    public LinkedList<Node> getNeighbors() {
        return adj;
    }

    public Node getNeighbor(int i) {
        return adj.get(i);
    }

    public int getNumNeighbors() {
        return adj.size();
    }

    @Override
    public String toString() {
        return "Node " + key + " has edges: " + getEdgesString();
    }

    public String getEdgesString() {
        StringBuilder edgesStr = new StringBuilder();
        for (Node node : adj) {
            edgesStr.append(node.key).append(" ");
        }
        return edgesStr.toString();
    }
}
