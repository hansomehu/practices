package classified.graph;

// import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.HashSet;

public class Dijkstra01 {

    public static HashMap<Node, Integer> dijkstra01(Node from) {

        HashMap<Node, Integer> distanceMap = new HashMap<>();
        // key, from the start point to key-point
        // value, the distance(weight)
        //
        // the first element from-from value is 0 of course
        distanceMap.put(from, 0);
        HashSet<Node> selectedNodes = new HashSet<>();

        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        // use current minNode as the conjucture point
        while (minNode != null) {
            // the distance from "start-point -> minnode"
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                // parse all the edges of this toNode
                Node toNode = edge.to;
                // if the toNode not in Map, insert
                // if the toNode is already in Map, update
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }

            }
            // after parsed this minNode'a all edges, put it into the blacklist
            // and then fetch a new minNode
            // utill there's no minNode anymore
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }

        return distanceMap;

    }

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {

        Node minNode = null;

        // initial value +finite
        int minDistance = Integer.MAX_VALUE;

        for (java.util.Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {

            Node node = entry.getKey();
            int distance = entry.getValue();

            // if this is a brand new record
            if (!touchedNodes.contains(node) && distance < minDistance) {

                minNode = node;
                minDistance = distance;

            }
        }

        return minNode;

    }

}