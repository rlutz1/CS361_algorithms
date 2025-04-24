package utils;

public class Graph {
    Vertex[] vertices;

    public Graph() {
        vertices = new Vertex[0];
    }

    public void addEdge (String from, String to, int weight) {
        Vertex u = getVertex(from);
        Vertex v = getVertex(to);
        u.addEdge(v, weight);
    }

    public void addEdge (String from, String to) {
        Vertex u = getVertex(from);
        Vertex v = getVertex(to);
        u.addEdge(v);
    }

    public void addVertex(String name) {
        addMem();
        vertices[vertices.length - 1] = new Vertex(vertices.length - 1, name);
    }

    public Vertex getVertex(String name) {
        for (Vertex v : vertices) {
            if (v.name == name) {
                return v;
            }
        }
        return null;
    }

    public void addMem() {
        Vertex[] temp = new Vertex[vertices.length + 1];
        for (int i = 0; i <  vertices.length; i++) {
            temp[i] = vertices[i];
        }

        vertices = temp;
    }

    public int numVertices() {
        return vertices.length;
    }

}








