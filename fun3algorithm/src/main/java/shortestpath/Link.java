package shortestpath;

public class Link {
    public Node PointA;
    public Node PointB;
    public int Distance;
    public Direction Direction;

    public Node getPointA() {
        return PointA;
    }

    public void setPointA(Node pointA) {
        PointA = pointA;
    }

    public Node getPointB() {
        return PointB;
    }

    public void setPointB(Node pointB) {
        PointB = pointB;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int distance) {
        Distance = distance;
    }

    public shortestpath.Direction getDirection() {
        return Direction;
    }

    public void setDirection(shortestpath.Direction direction) {
        Direction = direction;
    }

    public Link(char pointA, char pointB, int distance)
    {
        PointA = new Node(pointA);
        PointB = new Node(pointB);
        Distance = distance;
        Direction = Direction.BOTH;
    }

}
