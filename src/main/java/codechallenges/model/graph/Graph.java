package codechallenges.model.graph;

/**
 * Graph
 *
 * A graph is, in a sense, nothing more than a binary relation.
 *
 * It has a powerful visualization as a set of points (called nodes or vertices)
 * connected by lines (called edges) or by arrows (called arcs).
 *
 * This Graph API supports processing of graph structures.
 *
 * @see Vertex
 * @see Edge
 *
 */
public interface Graph {

    void add(Vertex start, Vertex end);
    
    void add(Vertex start, Vertex end, int weight, boolean oriented);

    int getVerticesCount();

    int getEdgeCount();

    Iterable<Vertex> getVertices();

    Iterable<Edge> getEdges();

    boolean hasVertex(Vertex target);

    boolean hasEdge(Vertex start, Vertex end);

}
