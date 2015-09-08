package codechallenges.dynamicprogramming;

import codechallenges.model.graph.Graph;
import codechallenges.model.graph.GraphImpl;
import codechallenges.model.graph.Vertex;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

/**
 * ShortestPathUndirectedGraph test class
 *
 * @author qza
 */
@RunWith(Parameterized.class)
public class ShortestPathUndirectedGraphTest {

    final static Vertex a = new Vertex("A");
    final static Vertex b = new Vertex("B");
    final static Vertex c = new Vertex("C");
    final static Vertex d = new Vertex("D");
    final static Vertex e = new Vertex("E");
    final static Vertex f = new Vertex("F");
    final static Vertex g = new Vertex("G");
    final static Vertex h = new Vertex("H");
    final static Vertex i = new Vertex("I");
    final static Vertex j = new Vertex("J");
    final static Vertex k = new Vertex("K");

    final Graph graph;

    final Vertex start, end;
    final List<Vertex> expected;

    public ShortestPathUndirectedGraphTest(Vertex start, Vertex end, List<Vertex> expected) {

        this.start = start;
        this.end = end;
        this.expected = expected;

        graph = new GraphImpl();

        graph.add(a, d);
        graph.add(d, c);
        graph.add(a, g);
        graph.add(k, j);
        graph.add(c, e);
        graph.add(b, e);
        graph.add(c, h);
        graph.add(c, f);
        graph.add(i, c);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {

        Object[][] parameters = new Object[][]{
            {a, d, Arrays.asList(a, d)},
            {a, h, Arrays.asList(a, d, c, h)},
            {e, i, Arrays.asList(e, c, i)},
            {b, g, Arrays.asList(b, e, c, d, a, g)}
        };
        return Arrays.asList(parameters);
    }

    @Test
    public void shouldFindShortestPath() {
        ShortestPathUndirectedGraph solver = new ShortestPathUndirectedGraph();
        assertEquals(expected, solver.solve(graph, start, end));
    }

}
