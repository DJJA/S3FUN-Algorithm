import shortestpath.Route;
import shortestpath.ShortestPathAlgorithm;

import java.util.List;


public class Algorithm {

    public static void main(String[] args){
        List<Route> routes = ShortestPathAlgorithm.GetPossibleRoutes(ShortestPathAlgorithm.graaf1, 'A', 'F');
        List<Route> routes2 = ShortestPathAlgorithm.GetPossibleRoutes(ShortestPathAlgorithm.graaf1WithDirections, 'A', 'F');

        ShortestPathAlgorithm.BubleSortRoutes(routes);
        ShortestPathAlgorithm.BubleSortRoutes(routes2);

        System.out.println("Possible routes (graaf1):");
        for (Route route : routes)
        {
            System.out.println(route.ToShortString());
        }

        System.out.println();
        System.out.println("Possible routes (graaf1 w/ direction):");
        for (Route route : routes2)
        {
            System.out.println(route.ToShortString());
        }

    }
}
