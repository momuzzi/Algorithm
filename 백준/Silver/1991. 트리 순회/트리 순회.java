import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder builder;
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        Map<String, Node> map = new HashMap<>();
        builder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] s = reader.readLine().split(" ");

            String parent = s[0];
            String left = s[1];
            String right = s[2];

            if (map.containsKey(parent)) {
                Node node = map.get(parent);
                if (!left.equals(".")) {
                    Node leftNode = new Node(left);
                    node.left = leftNode;
                    map.put(left, leftNode);
                }

                if (!right.equals(".")) {
                    Node rightNode = new Node(right);
                    node.right = rightNode;
                    map.put(right, rightNode);
                }
            } else {
                Node node = new Node(parent);
                map.put(parent, node);
                if (!left.equals(".")) {
                    Node leftNode = new Node(left);
                    node.left = leftNode;
                    map.put(left, leftNode);
                }

                if (!right.equals(".")) {
                    Node rightNode = new Node(right);
                    node.right = rightNode;
                    map.put(right, rightNode);
                }

                if (i == 0) {
                    root = node;
                }
            }
        }

        pre(root);
        builder.append("\n");
        in(root);
        builder.append("\n");
        post(root);
        
        System.out.print(builder);
    }

    static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    static void pre(Node node) {
        if (node == null) {
            return;
        }

        builder.append(node.value);
        pre(node.left);
        pre(node.right);
    }

    static void in(Node node) {
        if (node == null) {
            return;
        }

        in(node.left);
        builder.append(node.value);
        in(node.right);
    }

    static void post(Node node) {
        if (node == null) {
            return;
        }

        post(node.left);
        post(node.right);
        builder.append(node.value);
    }
}