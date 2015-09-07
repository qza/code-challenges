package codechallenges.model.graph;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Vertex test class
 *
 * @author qza
 */
public class VertexTest {

    final String TEST = "TEST";

    final Vertex vertex = new Vertex(TEST);

    @Test
    public void shouldBeProperlyInitialized() {
        assertEquals(TEST, vertex.getName());
        assertNotNull(vertex.getEdges());
        assertNotNull(vertex.edges());
        assertNotNull(vertex.vertices());
    }

    @Test
    public void shouldHaveProperToString() {
        assertNotNull(vertex.toString());
        assertTrue(vertex.toString().contains(TEST));
    }

    @Test
    public void shouldNotBeEqualTo() {
        assertNotEquals(vertex, null);
        assertNotEquals(vertex, "");
        assertNotEquals(vertex, new Vertex(TEST + "_"));
    }

    @Test
    public void shouldBeEqual() {
        assertEquals(vertex, vertex);
        assertEquals(vertex, new Vertex(TEST));
    }

}
