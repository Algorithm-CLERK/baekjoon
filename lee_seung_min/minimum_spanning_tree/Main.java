package lee_seung_min.minimum_spanning_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int V;
    private static int E;
    private static List<Node> nodes = new ArrayList<>();
    private static boolean[] visited;
    private static int answer;

    // Node
    private static class Node {
        private int name;
        private List<Edge> edges;

        public Node(int name) {
            this.name = name;
            this.edges = new ArrayList<>();
        }

        public int getName() {
            return name;
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public void addEdges(Edge edge) {
            edges.add(edge);
        }
    }
    
    // Edge
    private static class Edge implements Comparable<Edge> {
        private Node source;
        private Node destination;
        private int weight;

        public Edge(Node source, Node destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public Node getSource() {
            return source;
        }

        public Node getDestination() {
            return destination;
        }

        @Override
        public int compareTo(Edge edge) {
            if (this.weight > edge.getWeight())
                return 1;
            else if (this.weight < edge.getWeight())
                return -1;
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        process();
        System.out.println(answer);
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // O(N)
        for (int i = 1; i < V + 1; i++) {
            Node node = new Node(i);
            nodes.add(node);
        }

        //O(N)
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int sourceNum = Integer.parseInt(st.nextToken());
            int destinationNum = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Node source = nodes.get(sourceNum-1);
            Node destination = nodes.get(destinationNum-1);
            source.addEdges(new Edge(source, destination, weight));
            destination.addEdges(new Edge(destination, source, weight));
        }
        visited = new boolean[V + 1];
        answer = 0;
    }

    private static void process() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(nodes.get(0), nodes.get(0), 0));
        
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            Node source = edge.getSource();
            Node destination = edge.getDestination();
            int weight = edge.getWeight();
            if (visited[destination.getName()])
                continue;
            visited[destination.getName()] = true;
            answer += weight;
            List<Edge> edges = destination.getEdges();
            for (Edge e : edges) {
                pq.add(e);
            }
        }
    }
}
