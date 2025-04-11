package Homework3;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;




public class OutDegeeInDegree {

    private Graph graph;
    private boolean[] finished;

    public void evenInOutDegree() {
        Node start = graph.getFirstNode();
        finished = new boolean[graph.getNumNodes() + 1];

        for (int i = 0; i < graph.getNumNodes(); i++) {
            finished[i] = false;
        }

        for (Node v : graph.getNodes()) {
            dfsApproach(v);
        }



        graph.print();

    }


    public void dfsApproach(Node node) {
        if (!finished[node.getKey()]) {
            for (int i = 0; i < node.getNumNeighbors(); i++) {
                if (node.getNeighbor(i).hasPath(node)) {
                    System.out.println("removing " + node + " from " + node.getNeighbor(i));
                    node.getNeighbor(i).removePath(node);
                    dfsApproach(node.getNeighbor(i));
                }

            }
            finished[node.getKey()] = true;
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

        g.addNode(7);
        g.addNode(8);
        g.addNode(9);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        g.addEdge(9, 7);

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

    public int getNumNodes() {
        return nodes.size();
    }
    public Graph() {
        nodes = new HashMap<>();
    }

    public Collection<Node> getNodes() {
        return nodes.values();
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

    public int getKey() {
        return key;
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
