public class Graph {
    Vertex[] vertices;

    public Graph() {
        vertices = new Vertex[0];
    }

    public void addEdge () {} // todo
    public void addVertex() {} // todo

    public void addMem() {
        Vertex[] temp = new Vertex[vertices.length + 1];
        for (int i = 0; i <=  vertices.length; i++) {
            temp[i] = vertices[i];
        }
        vertices = temp;
    }

}

abstract class Edge {
    Vertex from;
    Vertex to;

    public Edge(Vertex from, Vertex to) {
        this.from = from;
        this.to = to;
    }
}

class WeightEdge extends Edge {
    int weight;

    public WeightEdge(Vertex from, Vertex to, int weight) {
        super(from, to);
        this.weight = weight;
    }
}

class UnweightEdge extends Edge {

    public UnweightEdge (Vertex from, Vertex to) {
        super(from, to);
    }
}

class Vertex {
    int key;
    String name;
    Edge[] adj;

    public Vertex(int key, String name) {
        this.key = key;
        this.name = name;
        this.adj = new Edge[0];
    }

    public void addMem() {
        Edge[] temp = new Edge[adj.length + 1];
        for (int i = 0; i <=  adj.length; i++) {
            temp[i] = adj[i];
        }
        adj = temp;
    }
}
