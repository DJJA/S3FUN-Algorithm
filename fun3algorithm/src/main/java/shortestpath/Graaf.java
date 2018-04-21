package shortestpath;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Graaf{

    private static boolean isNodeInList(List<Node> nodes, Node node)
    {
        for (Node n : nodes)
        {
            if (n.getId() == node.getId()) return true;
        }
        return false;
    }

    private static List<Node> getConnectedNodes(Graaf graph, Node startNode, Node stopNode, List<Node> nodesPassedThrough){

        List<Node> connectedNodes = new ArrayList<Node>();

        for(Link edge : (List<Link>)graph) {
            if(edge.PointA.getId() == startNode.getId() && edge.getDirection() != Direction.BTOA){
                if(!isNodeInList(nodesPassedThrough, edge.PointB)){
                    connectedNodes.add(new Node(edge.getPointB().getId()));
                }
            }
            else if (edge.PointB.getId() == startNode.getId() && edge.Direction != Direction.ATOB){
                if(!isNodeInList(nodesPassedThrough, edge.PointA)){
                    connectedNodes.add(new Node(edge.getPointA().getId()));
                }
            }
        }

        for (Node node : connectedNodes)
        {
            if (node.getId() != stopNode.getId())
            {
                List<Node> curNodesPassedThrough = new ArrayList<Node>();
                //curNodesPassedThrough.add AddRange(nodesPassedThrough);
                //curNodesPassedThrough.Add(node);

                //node.IgnoredNodes = curNodesPassedThrough;
                //node.ConnectedNodes = GetConnectedNodes(graaf, node, stopNode, curNodesPassedThrough);
            }
        }

        return connectedNodes;
    }

    private static List<Route> getPossibleRoutes(Graaf  graph, Node startNode, Node stopNode, List<Node> nodesPassedThrough){



        throw new NotImplementedException();
    }

}
