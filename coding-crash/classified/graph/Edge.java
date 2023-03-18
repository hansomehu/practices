package classified.graph;

public class Edge {

    // the properties of each edge
    public int weight;
    // entry point
    public Node from;
    // exit point
    public Node to;

    public Edge(int weight, Node from, Node to) {

        this.weight = weight;
        this.from = from;
        this.to = to;

    }

}
