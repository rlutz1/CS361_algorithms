package utils;

public class Vertex {
int key;
String name;
Edge[] adj;

public Vertex(int key, String name) {
    this.key = key;
    this.name = name;
    this.adj = new Edge[0];
}

public void addEdge(Vertex to, int weight) {
    addMem();
    adj[adj.length - 1] = new WeightEdge(this, to, weight);
}

public void addEdge(Vertex to) {
    addMem();
    adj[adj.length - 1] = new UnweightEdge(this, to);
}

public void addMem() {
    Edge[] temp = new Edge[adj.length + 1];
    for (int i = 0; i <  adj.length; i++) {
        temp[i] = adj[i];
    }
    adj = temp;
}
}
