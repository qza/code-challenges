package codechallenges.dynamicprogramming;

import codechallenges.model.graph.Edge;
import codechallenges.model.graph.Graph;
import codechallenges.model.graph.GraphImpl;
import codechallenges.model.graph.Vertex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.min;

/**
 * Shortest path in undirected graph
 *
 * Given undirected graph, with set of vertices and connections between
 * vertices, find shortest path between Vertex A and B.
 *
 * @see Graph
 * @author qza
 */
public class ShortestPathUndirectedGraph {

    public List<Vertex> solve(final Graph graph, final Vertex start, final Vertex end) {

        Map<Vertex, Integer> lengths = new HashMap<>();

        Iterator<Vertex> verticesIterator = graph.getVertices().iterator();
        while (verticesIterator.hasNext()) {
            lengths.put(verticesIterator.next(), graph.getVerticesCount());
        }

        lengths.put(start, 0);

        for (Vertex vertex : graph.getVertices()) {

            for (Vertex vertex2 : graph.getVertices()) {

                if (!vertex.equals(vertex2) && graph.hasEdge(vertex, vertex2)) {

                    lengths.put(vertex, min(lengths.get(vertex), lengths.get(vertex2) + 1));

                    lengths.put(vertex2, min(lengths.get(vertex2), lengths.get(vertex) + 1));

                }
            }
        }

        List<Vertex> path = new ArrayList<>(lengths.get(end));

        path.add(end);

        Vertex current = end;

        while (!start.equals(current)) {

            Vertex next = null;

            for (Edge edge : current.edges()) {

                boolean isStart = edge.getStart().equals(current);

                Vertex nextCheck = isStart ? edge.getEnd() : edge.getStart();

                next = next == null ? nextCheck
                        : lengths.get(nextCheck) < lengths.get(next)
                                ? nextCheck : next;
            }

            path.add(next);

            current = next;
        }

        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {

        ShortestPathUndirectedGraph solver = new ShortestPathUndirectedGraph();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");

        Graph graph = new GraphImpl();

        graph.add(a, d);
        graph.add(a, e);
        graph.add(b, e);
        graph.add(d, c);
        graph.add(c, e);
        graph.add(c, f);

        List<Vertex> result = solver.solve(graph, b, f);

        System.out.println("\n");
        System.out.println("length: " + (result.size() - 1));
        System.out.print("shortest path: ");

        for (Vertex v : result) {
            System.out.print(v.getName() + " ");
        }

        System.out.println("\n");
    }
}
