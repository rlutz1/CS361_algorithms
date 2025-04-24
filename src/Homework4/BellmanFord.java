package Homework4;

import utils.Graph;
import utils.Vertex;

public class BellmanFord {

    public BellmanFord() {}

    public int[] bellmanFord(Graph G, String start) {
        int src = G.getVertex(start);

        int [] distFromSrc = new int[G.numVertices()];
        for (int i = 0; i < distFromSrc.length; i++) {
            distFromSrc[i] = Integer.MAX_VALUE;
        }


    }
}



