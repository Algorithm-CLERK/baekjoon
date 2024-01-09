package lee_seung_min.minimum_cost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 그래프릐 노드 클래스
class Node {
    private String name;
    private List<Edge> edges;
    private int distance;
    private boolean visited;

    public Node(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
        this.distance = Integer.MAX_VALUE;
        this.visited = false;
    }

    public void addEdges(Edge edge) {
        edges.add(edge);
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void visit() {
        this.visited = true;
    }

    public String getName() {
        return name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public int getDistance() {
        return distance;
    }

    public boolean getVisited() {
        return visited;
    }

}

// 그래프의 엣지 클래스
class Edge {
    private Node source;
    private Node destination;
    private int weight;

    public Edge(Node source, Node destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}

public class Main {
    private static int N; // 도시의 개수
    private static int M; // 버스의 개수
    private static List<Node> nodes = new ArrayList<>();
    private static Node sourceNode;
    private static Node destinationNode;
    private static String startNodeName;
    private static Node startNode;
    private static String endNodeName;
    private static Node endNode;
    private static Node visitNode;

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String source = st.nextToken();
            String destination = st.nextToken();
            int cost = Integer.parseInt(st.nextToken());
            if (!isNode(source)) {
                sourceNode = new Node(source);
                nodes.add(sourceNode);
            } else {
                sourceNode = findNode(source);
            }
            if (!isNode(destination)) {
                destinationNode = new Node(destination);
                nodes.add(destinationNode);
            } else {
                destinationNode = findNode(destination);
            }
            
            Edge e = new Edge(sourceNode, destinationNode, cost);
            sourceNode.addEdges(e);
            destinationNode.addEdges(e);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        startNodeName = st.nextToken();
        endNodeName = st.nextToken();
        startNode = findNode(startNodeName);
        endNode = findNode(endNodeName);
    }

    private static boolean isNode(String nodeName) {
        for (Node node : nodes) {
            if (node.getName().equals(nodeName)) {
                return true;
            }
        }
        return false;
    }

    private static Node findNode(String nodeName) {
        for (Node node : nodes) {
            if (node.getName().equals(nodeName)) {
                return node;
            }
        }
        return null; // TODO NodeNotFound Exception
    }

    private static void process() {
        startNode.setDistance(0);
        for (int i = 0; i < N; i++) {
            int nodeValue = Integer.MAX_VALUE;
            for (Node node : nodes) {
                if (!node.getVisited() && node.getDistance() < nodeValue) {
                    nodeValue = node.getDistance();
                    visitNode = node;
                }
            }

            visitNode.visit();
            
            List<Edge> edges = visitNode.getEdges();
            for (Edge edge : edges) {
                Node node = edge.getDestination();
                if (node.getDistance() > visitNode.getDistance() + edge.getWeight()) {
                    node.setDistance(visitNode.getDistance() + edge.getWeight());
                }
            }
        }
        
    }

    public static void main(String[] args) throws IOException{
        init();
        process();
        System.out.println(endNode.getDistance());
    }
}
