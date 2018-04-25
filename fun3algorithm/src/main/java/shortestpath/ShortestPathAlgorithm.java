package shortestpath;

import stopwatch.TimeStamp;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestPathAlgorithm {

    private static boolean isNodeInList(List<Node> nodes, Node node)
    {
        for (Node n : nodes)
        {
            if (n.getId() == node.getId()) return true;
        }
        return false;
    }

    public static Graaf graaf1 = new Graaf(Arrays.asList(

            new Link('A', 'B', 5),
            new Link('A', 'D', 6),
            new Link('D', 'E', 5),
            new Link('D', 'F', 8),
            new Link('F', 'C', 12),
            new Link('B', 'E', 7),
            new Link('B', 'C', 2),
            new Link('E', 'C', 3)
    ));

    public static Graaf graaf1Verdubbeld = new Graaf(Arrays.asList(

            new Link('A', 'G', 5),
            new Link('A', 'D', 6),
            new Link('B', 'D', 5),
            new Link('B', 'C', 8),
            new Link('B', 'H', 12),
            new Link('B', 'G', 7),
            new Link('C', 'I', 2),
            new Link('C', 'D', 3),
            new Link('C', 'H', 3),
            new Link('D', 'F', 3),
            new Link('D', 'J', 3),
            new Link('E', 'F', 3),
            new Link('E', 'L', 3),
            new Link('F', 'K', 3),
            new Link('F', 'L', 3),
            new Link('I', 'J', 3)
    ));

    public static Graaf graaf1TweeMaalVerdubbeld = new Graaf(Arrays.asList(
            new Link('A', 'G', 5),
            new Link('A', 'D', 6),
            new Link('B', 'D', 5),
            new Link('B', 'C', 8),
            new Link('B', 'H', 12),
            new Link('B', 'G', 7),
            new Link('C', 'I', 2),
            new Link('C', 'D', 3),
            new Link('C', 'H', 3),
            new Link('D', 'F', 3),
            new Link('D', 'J', 3),
            new Link('E', 'F', 3),
            new Link('E', 'L', 3),
            new Link('F', 'K', 3),
            new Link('F', 'L', 3),
            new Link('I', 'J', 3),
            new Link('I', 'O', 3),
            new Link('K', 'N', 3),
            new Link('L', 'X', 3),
            new Link('M', 'N', 3),
            new Link('M', 'W', 3),
            new Link('P', 'H', 3),
            new Link('Q', 'H', 3),
            new Link('R', 'H', 3),
            new Link('R', 'S', 3),
            new Link('S', 'G', 3),
            new Link('T', 'A', 3),
            new Link('U', 'E', 3),
            new Link('V', 'E', 3),
            new Link('W', 'F', 3),
            new Link('N', 'D', 3),
            new Link('J', 'C', 3)
    ));

    public static Graaf graafOverdrevenEdges = new Graaf(Arrays.asList(
            new Link('A', 'G', 5),
            new Link('A', 'D', 6),
            new Link('B', 'D', 5),
            new Link('B', 'C', 8),
            new Link('B', 'H', 12),
            new Link('B', 'G', 7),
            new Link('C', 'I', 2),
            new Link('C', 'D', 3),
            new Link('C', 'H', 3),
            new Link('D', 'F', 3),
            new Link('D', 'J', 3),
            new Link('E', 'F', 3),
            new Link('E', 'L', 3),
            new Link('F', 'K', 3),
            new Link('F', 'L', 3),
            new Link('I', 'J', 3),
            new Link('I', 'O', 3),
            new Link('K', 'N', 3),
            new Link('L', 'X', 3),
            new Link('M', 'N', 3),
            new Link('M', 'W', 3),
            new Link('P', 'H', 3),
            new Link('Q', 'H', 3),
            new Link('R', 'H', 3),
            new Link('R', 'S', 3),
            new Link('S', 'G', 3),
            new Link('T', 'A', 3),
            new Link('U', 'E', 3),
            new Link('V', 'E', 3),
            new Link('W', 'F', 3),
            new Link('N', 'D', 3),
            new Link('J', 'C', 3),
            new Link('M', 'O', 3),
            new Link('J', 'O', 3),
            new Link('M', 'J', 3),
            new Link('P', 'O', 3),
            new Link('P', 'I', 3),
            new Link('H', 'I', 3),
            new Link('P', 'Q', 3),
            new Link('Q', 'R', 3),
            new Link('B', 'R', 3),
            new Link('B', 'S', 3),
            new Link('G', 'R', 3),
            new Link('T', 'S', 3),
            new Link('T', 'U', 3),
            new Link('A', 'U', 3),
            new Link('E', 'T', 3),
            new Link('V', 'A', 3),
            new Link('V', 'U', 3),
            new Link('V', 'L', 3),
            new Link('X', 'E', 3),
            new Link('X', 'W', 3),
            new Link('X', 'U', 3),
            new Link('X', 'V', 3),
            new Link('W', 'K', 3),
            new Link('K', 'M', 3),
            new Link('A', 'B', 3),
            new Link('T', 'G', 3),
            new Link('T', 'B', 3),
            new Link('E', 'D', 3),
            new Link('W', 'L', 3),
            new Link('N', 'C', 3),
            new Link('D', 'J', 3),
            new Link('C', 'P', 3)
    ));


    public static Graaf graaf1WithDirections = new Graaf(Arrays.asList(

            new Link('A', 'B', 5, Direction.ATOB),
            new Link('A', 'D', 6),
            new Link('D', 'E', 5),
            new Link('D', 'F', 8),
            new Link('F', 'C', 12),
            new Link('B', 'E', 7, Direction.BTOA),
            new Link('B', 'C', 2),
            new Link('E', 'C', 3)
    ));

    public static Graaf graaf2 = new Graaf(Arrays.asList(

            //region outer ring
            new Link('A', 'E', 4),
            new Link('E', 'L', 3),
            new Link('L', 'T', 18),
            new Link('T', 'O', 3),
            new Link('O', 'N', 5),
            new Link('N', 'K', 2),
            new Link('K', 'H', 3),
            new Link('H', 'D', 2),
            new Link('D', 'S', 11),
            new Link('S', 'A', 1),
            //endregion
            //region outer nodes to inner nodes
            new Link('A', 'B', 2),
            new Link('A', 'F', 5),

            new Link('E', 'F', 2),
            new Link('E', 'I', 1),

            new Link('L', 'I', 1),
            new Link('L', 'J', 2),
            new Link('L', 'M', 10),

            new Link('T', 'M', 7),

            new Link('O', 'M', 3),

            new Link('N', 'M', 1),
            new Link('N', 'J', 10),

            new Link('K', 'J', 7),
            new Link('K', 'G', 9),

            new Link('H', 'G', 6),
            new Link('H', 'C', 3),

            new Link('D', 'C', 2),

            new Link('S', 'C', 13),
            new Link('S', 'B', 2),
            //endregion

            new Link('F', 'I', 3),
            new Link('I', 'J', 1),
            new Link('J', 'G', 3),
            new Link('G', 'C', 1),
            new Link('C', 'B', 9),
            new Link('B', 'F', 3),

            new Link('J', 'M', 9),
            new Link('I', 'G', 2),
            new Link('F', 'G', 1),
            new Link('B', 'G', 5)

    ));


    public static List<Route> GetPossibleRoutes(Graaf graaf, char pointStart, char pointDestination, int maxNodesPerRoute)
    {
        return FilterRoutesByNodeCount(GetPossibleRoutes(graaf, pointStart, pointDestination), maxNodesPerRoute);
    }

    public static List<Route> GetPossibleRoutes(Graaf graaf, char pointStart, char pointDestination, List<Node> nodesToAvoid, int maxNodesPerRoute)
    {
        return FilterRoutesByNodeCount(GetPossibleRoutes(graaf, pointStart, pointDestination, nodesToAvoid), maxNodesPerRoute);
    }

    public static List<Route> GetPossibleRoutes(Graaf graaf, char pointStart, char pointDestination)
    {
        Node startNode = new Node(pointStart);
        Node stopNode = new Node(pointDestination);
        List<Node> nodesPassedThrough = new ArrayList<Node>();

        nodesPassedThrough.add(startNode);
        return GetPossibleRoutes(graaf, startNode, stopNode, nodesPassedThrough);
    }

    public static List<Route> GetPossibleRoutes(Graaf graaf, char pointStart, char pointDestination, List<Node> nodesToAvoid)
    {
        Node startNode = new Node(pointStart);
        Node stopNode = new Node(pointDestination);
        nodesToAvoid.add(startNode);
        return GetPossibleRoutes(graaf, startNode, stopNode, nodesToAvoid);
    }

    private static List<Route> FilterRoutesByNodeCount(List<Route> routes, int maxNodeCount)
    {
        List<Route> filteredRoutes = new ArrayList<Route>();
        for (Route route : routes)
        {
            if (route.Links.size() <= (maxNodeCount - 1))
            {
                filteredRoutes.add(route);
            }
        }
        return filteredRoutes;
    }

    private static List<Route> GetPossibleRoutes(Graaf graaf, Node startNode, Node stopNode, List<Node> nodesPassedThrough)
    {
        TimeStamp tsGetConnectedNodes = new TimeStamp();
        tsGetConnectedNodes.init();
        tsGetConnectedNodes.setBegin("Start getConnectedNodes");
        startNode.setConnectedNodes(GetConnectedNodes(graaf, startNode, stopNode, nodesPassedThrough));
        tsGetConnectedNodes.setEnd("Finished getConnectedNodes");
        System.out.println("[GetPossibleRoutes]Time spent getting connected nodes: " +tsGetConnectedNodes);

        TimeStamp tsGetRoutes = new TimeStamp();
        tsGetRoutes.init();
        tsGetRoutes.setBegin("Start getRoutes");
        List<Route> routes = GetConnectedNodeRoutes(startNode, graaf);
        tsGetRoutes.setEnd("Finished getRoutes");
        System.out.println("[GetPossibleRoutes]Time spent converting connected nodes to routes: " + tsGetRoutes);

        TimeStamp tsFiltering = new TimeStamp();
        tsFiltering.init();
        tsFiltering.setBegin("Start filtering");
        List<Route> routesWithEnding = new ArrayList<Route>();
        for (Route route : routes)
        {
            Link lastLink = route.Links.get(route.Links.size() - 1);
            if (lastLink.PointA.getId() == stopNode.getId() || lastLink.PointB.getId() == stopNode.getId())
                routesWithEnding.add(route);
        }
        tsFiltering.setEnd("Finished filtering");
        System.out.println("[GetPossibleRoutes]Time spent filtering out routes not reaching the end node: " + tsFiltering);

        return routesWithEnding;
    }

    public static Route GetShortestRoute(List<Route> routes)
    {
        //BubleSortRoutes(routes);
        Route shortest = null;
        for (Route route : routes)
        {
            if (shortest == null)
            {
                shortest = route;
            }
            else
            {
                if (route.Distance < shortest.Distance)
                {
                    shortest = route;
                }
            }
        }
        return shortest;
    }

    public static List<Route> Get10ShortestRoutes(List<Route> routes)
    {
        BubleSortRoutes(routes);

        List<Route> shortestRoutes = new ArrayList<Route>();
        for (int i = 0; i < (routes.size() >= 10 ? 10 : routes.size()); i++)
        {
            shortestRoutes.add(routes.get(i));
        }

        return shortestRoutes;
    }

    private static List<String> GetConnectedNodesPathsAsString(Node node)
    {
        List<String> list = new ArrayList<String>();
        String curNode = node.getId() + "";
        if (node.getConnectedNodes() != null && node.getConnectedNodes().size() > 0)   // If the GetConnectedNodes algorithm reaches the specified endNode, connected nodes will be null. If it finds a node without connection, path to nowhere, it's not null
        {
            for (Node conNode : node.getConnectedNodes())
            {
                List<String> childPaths = GetConnectedNodesPathsAsString(conNode);
                for (String childPath : childPaths)
                {
                    list.add(curNode + " " + childPath);
                }
            }
        }
        else
        {
            list.add(curNode);
        }
        return list;
    }

    private static List<Route> GetConnectedNodeRoutes(Node node, Graaf graaf)
    {
        List<Route> possibleRoutes = new ArrayList<Route>();

        if (node.getConnectedNodes() != null && node.getConnectedNodes().size() > 0)
        {
            for (Node conNode : node.getConnectedNodes())
            {
                // We have a link --> add it to the route
                // Check if this node has more links
                Link curLink = graaf.GetLink(node.getId(), conNode.getId());

                List<Route> subRoutes = GetConnectedNodeRoutes(conNode, graaf);
                if (subRoutes.size() > 0)
                {
                    for (Route subRoute : subRoutes)
                    {
                        Route route = new Route();
                        route.AddLink(curLink);
                        for (Link link : subRoute.Links)
                        {
                            route.AddLink(link);
                        }
                        possibleRoutes.add(route);
                    }
                }
                else
                {
                    // No more subroutes, only add the current link
                    Route route = new Route();                             // Should perhaps use a List<Link> in stead of Route to save memory
                    route.AddLink(curLink);
                    possibleRoutes.add(route);
                }
            }
        }
        else
        {
            // If there are no more connected nodes, there're no new links
        }

        return possibleRoutes;
    }

    private static List<Node> GetConnectedNodes(Graaf graaf, Node inputNode, Node stopNode, List<Node> nodesPassedThrough)
    {
        List<Node> connectedNodes = new ArrayList<Node>();

        for (Link route : graaf.getLinks())
        {
            // Check if route has nodeStart in it
            if (route.PointA.getId() == inputNode.getId() && route.Direction != Direction.BTOA)
            {
                if (!isNodeInList(nodesPassedThrough, route.PointB))
                {
                    connectedNodes.add(new Node(route.PointB.getId()));  // Was a reference problem --> connectedNodes.Add(route.PointB); --> Takes point from graaf, does it again later and changes it what causes the bug
                }
            }
            else if (route.PointB.getId() == inputNode.getId() && route.Direction != Direction.ATOB)
            {
                if (!isNodeInList(nodesPassedThrough, route.PointA))
                {
                    connectedNodes.add(new Node(route.PointA.getId()));
                }
            }
        }

        for (Node node : connectedNodes)
        {
            if (node.getId() != stopNode.getId())
            {
                List<Node> curNodesPassedThrough = new ArrayList<Node>();
                curNodesPassedThrough.addAll(nodesPassedThrough);
                curNodesPassedThrough.add(node);

                //node.IgnoredNodes = curNodesPassedThrough;
                node.setConnectedNodes(GetConnectedNodes(graaf, node, stopNode, curNodesPassedThrough));
            }
        }

        return connectedNodes;
    }

//    private static bool IsNodeInList(List<Node> nodes, Node node)
//    {
//        foreach (var n in nodes)
//        {
//            if (n.Id == node.Id) return true;
//        }
//        return false;
//    }

    public static void BubleSortRoutes(List<Route> routes)
    {
        boolean swapped = true;
        int iteration = 0;
        while (swapped)
        {
            swapped = false;
            for (int i = 1; i < (routes.size() - iteration); i++)
            {
                if (routes.get(i).Distance < routes.get(i - 1).Distance)
                {
                    Route route = routes.get(i);
                    routes.set(i, routes.get(i - 1));
                    routes.set(i - 1, route);
                    swapped = true;
                }
            }
            iteration++;
        }
    }

}
