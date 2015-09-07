package codechallenges.model.graph;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Edge test class
 *
 * @author qza
 */
public class EdgeTest {

    final Vertex A = new Vertex("A");
    final Vertex B = new Vertex("B");

    final Edge edge = new Edge(A, B);

    @Test
    public void shouldBeProperlyInitialized() {
        assertEquals(A, edge.getStart());
        assertEquals(B, edge.getEnd());
        assertEquals(0, edge.getWeight());
        assertFalse(edge.isOriented());
    }

    @Test
    public void shouldBeEqualyInitialized() {
        Edge edge2 = new Edge(A, B, 0, false);
        assertEquals(edge, edge2);
    }

    @Test
    public void shouldNotBeEqual() {
        assertNotEquals(edge, null);
        assertNotEquals(edge, "");
        assertNotEquals(edge, new Edge(A, new Vertex("C")));
    }

    @Test
    public void shouldBeEqual() {
        assertEquals(edge, edge);
        assertEquals(edge, new Edge(B, A));
    }

}
