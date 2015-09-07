package codechallenges.model.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * GraphImpl
 *
 * Implementation of {@link Graph}
 *
 * @see Vertex
 * @see Edge
 *
 * @author qza
 */
public class GraphImpl implements Graph {

    final Set<Vertex> vertices;
    final Set<Edge> edges;

    public GraphImpl() {
        this.vertices = new HashSet<>();
        this.edges = new HashSet<>();
    }
    
    @Override
    public void add(Vertex start, Vertex end) {
        vertices.add(start);
        vertices.add(end);
        Edge edge = new Edge(start, end);
        start.edges.put(end, edge);
        end.edges.put(start, edge);
        edges.add(edge);
    }

    @Override
    public void add(Vertex start, Vertex end, int weight, boolean oriented) {
        vertices.add(start);
        vertices.add(end);
        Edge edge = new Edge(start, end, weight, oriented);
        start.edges.put(end, edge);
        end.edges.put(start, edge);
        edges.add(edge);
    }

    @Override
    public int getVerticesCount() {
        return vertices.size();
    }

    @Override
    public int getEdgeCount() {
        return edges.size();
    }

    @Override
    public Iterable<Vertex> getVertices() {
        return vertices;
    }

    @Override
    public Iterable<Edge> getEdges() {
        return edges;
    }

    @Override
    public boolean hasVertex(Vertex target) {
        return vertices.contains(target);
    }

    @Override
    public boolean hasEdge(Vertex start, Vertex end) {
        for (Edge edge : edges) {
            if (edge.isSame(start, end)) {
                return true;
            }
        }
        return false;
    }

}
