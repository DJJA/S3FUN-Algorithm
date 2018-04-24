package shortestpath;

import java.util.ArrayList;
import java.util.List;

public class Graaf {

    public List<Link> getLinks() {
        return links;
    }

    private List<Link> links;

    public Graaf(List<Link> links){
        this.links = links;
    }

    public Link GetLink(char pointFrom, char pointTo)
    {
        for (Link link : links)
        {
            if (((link.PointA.getId() == pointFrom && link.PointB.getId() == pointTo && link.Direction != Direction.BTOA) || (link.PointA.getId() == pointTo && link.PointB.getId() == pointFrom && link.Direction != Direction.ATOB)))
            {
                return link;
            }
        }
        return null;
    }
}
