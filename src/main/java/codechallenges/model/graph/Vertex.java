package codechallenges.model.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Vertex
 *
 * Basic {@link Graph} element (aka Node)
 *
 * @author qza
 */
public class Vertex {

    final String name;
    final Map<Vertex, Edge> edges;

    public Vertex(String name) {
        this.name = name;
        this.edges = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Iterable<Vertex> vertices() {
        return edges.keySet();
    }

    public Iterable<Edge> edges() {
        return edges.values();
    }

    public Map<Vertex, Edge> getEdges() {
        return edges;
    }
    
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vertex)) {
            return false;
        }
        return Objects.equals(this.name, ((Vertex) obj).name);
    }

    @Override
    public String toString() {
        return "vertex [" + getName() + "]";
    }

}
