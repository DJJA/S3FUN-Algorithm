package shortestpath;

import java.util.ArrayList;
import java.util.List;

public class Graaf extends ArrayList<Link> {

    public Link GetLink(char pointFrom, char pointTo)
    {
        for (Link link : this)
        {
            if (((link.PointA.getId() == pointFrom && link.PointB.getId() == pointTo && link.Direction != Direction.BTOA) || (link.PointA.getId() == pointTo && link.PointB.getId() == pointFrom && link.Direction != Direction.ATOB)))
            {
                return link;
            }
        }
        return null;
    }
}
