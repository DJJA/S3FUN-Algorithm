package shortestpath;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private char id;
    private List<Node> connectedNodes;

    public Node(char id) {
        this.id = id;
        this.connectedNodes = new ArrayList<Node>();
    }

    @Override
    public String toString() {
        return "(" + id + ")";
    }
}
