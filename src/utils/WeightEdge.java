package utils;

public class WeightEdge extends Edge {
    int weight;

    public WeightEdge(Vertex from, Vertex to, int weight) {
        super(from, to);
        this.weight = weight;
    }
}
