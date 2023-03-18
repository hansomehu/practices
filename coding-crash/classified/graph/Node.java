package classified.graph;

import java.util.ArrayList;

public class Node {

    public int value;
    // 表示值
    public int in;
    // 入度:有多少个边指向此处
    public int out;
    // 出度:有多少指出去的边
    public ArrayList<Node> nexts;
    // 直接邻居,指向下一个的点集合
    public ArrayList<Edge> edges;
    // 边，从我出发的边的集合

    public Node(int value) {

        this.value = value;

        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();

    }
}