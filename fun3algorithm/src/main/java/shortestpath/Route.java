package shortestpath;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Route {
    public List<Link> Links;
    public int Distance;

    public Route()
    {
        Links = new ArrayList<Link>();
        Distance = 0;
    }
    public void AddLink(Link link)
    {
        Links.add(link);
        Distance += link.Distance;
    }

    @Override
    public String toString()
    {
//        String str = $"[{Distance}]".PadRight(5, ' ');
        String str = padRight("(" + Distance + ")", 5);
        for (Link link : Links)
        {
            str += link.toString() + " ";
        }
        return str;
    }

    public String ToShortString()
    {
        String str = padRight("(" + Distance + ")", 5);

        if (Links.size() == 1)
        {
            str += Links.get(0).PointA.getId() + " " + Links.get(0).PointB.getId();
        }
        else
        {
            for (int i = 0; i < (Links.size() - 1); i++)
            {
                Link curLink = Links.get(i);
                Link nexLink = Links.get(i + 1);

                if (curLink.PointA.getId() == nexLink.PointA.getId() || curLink.PointA.getId() == nexLink.PointB.getId())
                {
                    if (i == 0)
                        str += curLink.PointB.getId() + " ";

                    str += curLink.PointA.getId() + " ";

                    if (i == Links.size() - 2)
                        str += curLink.PointA.getId() == nexLink.PointA.getId() ? nexLink.PointB.getId() : nexLink.PointA.getId();
                }
                else if (curLink.PointB.getId() == nexLink.PointA.getId() || curLink.PointB.getId() == nexLink.PointB.getId())
                {
                    if (i == 0)
                        str += curLink.PointA.getId() + " ";

                    str += curLink.PointB.getId() + " ";

                    if (i == Links.size() - 2)
                        str += curLink.PointB.getId() == nexLink.PointA.getId() ? nexLink.PointB.getId() : nexLink.PointA.getId();
                }
            }
        }


        return str;
    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }
}
