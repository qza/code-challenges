package codechallenges.model.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Graph implementation test class
 *
 * @author qza
 */
public class GraphImplTest {

    Graph graph = new GraphImpl();

    @Before
    public void setUp() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        graph.add(a, b);
        graph.add(a, c);
        graph.add(c, a);
        graph.add(b, d);
    }

    @Test
    public void shouldHaveNotNullVertices() {
        for (Vertex v : graph.getVertices()) {
            assertNotNull(v);
        }
    }

    @Test
    public void shouldHaveNotNullEdges() {
        for (Edge e : graph.getEdges()) {
            assertNotNull(e);
        }
    }

    @Test
    public void shouldFindProperNumberOfVertices() {
        assertEquals(4, graph.getVerticesCount());
    }

    @Test
    public void shouldFindProperNumberOfEdges() {
        assertEquals(3, graph.getEdgeCount());
    }

    @Test
    public void shouldHaveVertex() {
        assertTrue(graph.hasVertex(new Vertex("A")));
    }

    @Test
    public void shouldNotHaveVertex() {
        assertFalse(graph.hasVertex(new Vertex("X")));
    }

    @Test
    public void shouldHaveEdge() {
        assertTrue(graph.hasEdge(new Vertex("A"), new Vertex("B")));
    }

    @Test
    public void shouldNotHaveEdge() {
        assertFalse(graph.hasEdge(new Vertex("X"), new Vertex("A")));
    }

}
