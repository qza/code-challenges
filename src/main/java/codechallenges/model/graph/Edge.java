package codechallenges.model.graph;

import java.util.Objects;

/**
 * Edge
 *
 * Connection between two {@link Vertex} of the {@link Graph}
 *
 * @author qza
 */
public class Edge {

    final Vertex start;
    final Vertex end;
    final int weight;
    final boolean oriented;

    Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
        this.weight = 0;
        this.oriented = false;
    }

    Edge(Vertex start, Vertex end, int weight, boolean oriented) {
        this.start = start;
        this.end = end;
        this.weight = weight;
        this.oriented = oriented;
    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isOriented() {
        return oriented;
    }

    @Override
    public int hashCode() {
        return weight;
    }

    public boolean isSame(Vertex start, Vertex end) {
        return (Objects.equals(this.start, start)
                && Objects.equals(this.end, end))
                || (Objects.equals(this.start, end)
                && Objects.equals(this.end, start));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Edge)) {
            return false;
        }
        return isSame(((Edge) obj).start, ((Edge) obj).end);
    }

    @Override
    public String toString() {
        return "edge [start: " + (getEnd() != null ? getEnd().getName() : " ") + "]"
                + "[weight: " + getWeight() + "][oriented: " + isOriented() + "]";
    }

}
