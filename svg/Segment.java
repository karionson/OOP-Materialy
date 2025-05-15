public class Segment {
    private Point start;
    private Point end;


    public Segment(Point start, Point end){
        this.start = new Point(start.getX(),start.getY());
        this.end = new Point(end.getX(),end.getY());
    }

    public double length() {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
    }

    public static Segment findLongestSegment(Segment[] segments) {
        if (segments == null || segments.length == 0) {
            return null;
        }

        Segment longest = segments[0];
        for (Segment segment : segments) {
            if (segment.length() > longest.length()) {
                longest = segment;
            }
        }
        return longest;
    }

    public String toString(){
        return "Segment: ["+ start.toString()+ ", "+ end.toString()+"]";
    }

    public static Segment[] perpendicular(Segment segment, Point point) {
        double x1 = segment.start.getX();
        double y1 = segment.start.getY();
        double x2 = segment.end.getX();
        double y2 = segment.end.getY();

        double r = segment.length();

        double dx = x2 - x1;
        double dy = y2 - y1;
        double a = dy / dx;

        double aPerpendicular = -1 / a;

        double b = point.getY() - aPerpendicular * point.getX();


        double deltaX = r / Math.sqrt(1 + aPerpendicular * aPerpendicular);
        double deltaY = aPerpendicular * deltaX;

        double x1_intersect = point.getX() + deltaX;
        double y1_intersect = point.getY() + deltaY;
        double x2_intersect = point.getX() - deltaX;
        double y2_intersect = point.getY() - deltaY;

        return new Segment[]{
                new Segment(point, new Point(x1_intersect, y1_intersect)),
                new Segment(point, new Point(x2_intersect, y2_intersect))
        };
    }
    public static Segment[] perpendicular(Segment segment, Point point, double length) {
        Segment[] perpendiculars = perpendicular(segment, point);
        double scale = length / segment.length();

        for (Segment s : perpendiculars) {
            double dx = s.end.getX() - s.start.getX();
            double dy = s.end.getY() - s.start.getY();
            s.end.setX(s.start.getX() + dx * scale);
            s.end.setY(s.start.getY() + dy * scale);
        }

        return perpendiculars;
    }


    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }
}
