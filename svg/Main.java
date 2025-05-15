public class Main {

    public static void main(String args[]){
        Point point = new Point(3.5, 7.2);

        System.out.println(point);
        System.out.println(point.toSvg());
        point.translate(2,1);
        System.out.println("After translate: " + point);
        Point newPoint = point.translated(3,0);
        System.out.println("point after translated: " + point);
        System.out.println("newPoint after translated: " + newPoint);
        System.out.println(point.translated(1,1).toSvg());

        Segment segment = new Segment(point, newPoint);
        System.out.println(segment.toString());
        System.out.println("Segment length: " + segment.length());
        point.translate(-2,0);
        System.out.println("Segment length after change point: " + segment.length());

        Point point1 = new Point(3.5, 7.2);
        Point point2 = new Point(2., 2.0);
        Point point3 = new Point(1.0, 1.0);
        Segment[] segments = {
                new Segment(point1, point2),
                new Segment(point2, point3),
                new Segment(point1, point3)
        };

        Segment longest = Segment.findLongestSegment(segments);
        System.out.println("Longest segment length: " + longest.length());

        Polygon square = Polygon.square(segments[1],null);
        System.out.println(square);
    }
}
