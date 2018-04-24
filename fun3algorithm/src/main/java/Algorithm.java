import shortestpath.Route;
import shortestpath.ShortestPathAlgorithm;
import stopwatch.TimeStamp;

import java.util.List;


public class Algorithm {

    public static void main(String[] args){
        TimeStamp tsGraafPosibleRoutes = new TimeStamp();
        tsGraafPosibleRoutes.init();
        tsGraafPosibleRoutes.setBegin("Start getPossibleRoutes");
        List<Route> routes = ShortestPathAlgorithm.GetPossibleRoutes(ShortestPathAlgorithm.graaf1, 'A', 'F');
        tsGraafPosibleRoutes.setEnd("Finished getPossibleRouts");

        TimeStamp tsGraafSort = new TimeStamp();
        tsGraafSort.init();
        tsGraafSort.setBegin("Start sorting");
        ShortestPathAlgorithm.BubleSortRoutes(routes);
        tsGraafSort.setEnd("Finished sorting");

        System.out.println("Time spent calculating possible routes: " + tsGraafPosibleRoutes);
        System.out.println("Time spent sorting the routes: " + tsGraafSort);

        System.out.println("Possible routes (graaf1):");
        for (Route route : routes)
        {
            System.out.println(route.ToShortString());
        }

        System.out.println("--------------------------------------------------------");



        List<Route> routes2 = ShortestPathAlgorithm.GetPossibleRoutes(ShortestPathAlgorithm.graaf1WithDirections, 'A', 'F');

        ShortestPathAlgorithm.BubleSortRoutes(routes2);

        System.out.println();
        System.out.println("Possible routes (graaf1 w/ direction):");
        for (Route route : routes2)
        {
            System.out.println(route.ToShortString());
        }

    }
}
