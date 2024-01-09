package lee_seung_min.line_up;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상 정렬
public class Main {
    private static int N;
    private static int M;
    private static List<Node> graph;
    private static Queue<Node> q;
    private static StringBuilder sb;
    
    private static class Node {
        int num;
        int size;
        List<Node> linkNodes;

        public Node(int num) {
            this.num = num;
            this.size = 0;
            linkNodes = new ArrayList<>();
        }
        
        public void add(Node n) {
            linkNodes.add(n);
        }

        public void remove(Node n) {
            linkNodes.remove(n);
        }
        
        public void rmoveAll() {
            linkNodes.clear();
        }

        public int getNum() {
            return num;
        }

        public void sizeUp() {
            size += 1;
        }

        public void sizeDown() {
            size -= 1;
        }

        public int getSize() {
            return size;
        }

        public List<Node> getNodes() {
            return linkNodes;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new Node(i + 1));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            Node sourceNode = graph.get(source - 1);
            Node destinationNode = graph.get(destination - 1);
            sourceNode.add(destinationNode);
            destinationNode.sizeUp();
        }
        
        sb = new StringBuilder();
    }
    

    private static void process() {
        q = new LinkedList<>();
        for (Node node : graph) {
            if (node.getSize() == 0) {
                q.offer(node);
            }
        }

        while (!q.isEmpty()) {
            Node n = q.poll();
            sb.append(n.getNum()).append(" ");
            List<Node> nodes = n.getNodes();
            for (Node node : nodes) {
                node.sizeDown();
                if (node.getSize() == 0)
                    q.add(node);
            }
            n.rmoveAll();
        }
        
    }
    public static void main(String[] args) throws IOException {
        init();
        process();
        System.out.println(sb);
    }
}
