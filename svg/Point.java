import java.util.Locale;

public class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(){
        this.x=0.;
        this.y=0.;
    }

    @Override
    public String toString() {
        return "Point(x=" + x + ", y=" + y + ")";
    }

    public String toSvg() {
        return String.format(Locale.US, "<circle cx='%.2f' cy='%.2f' r='5' fill='black' />", x, y);
    }

    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public Point translated(double dx, double dy) {
        return new Point(this.x + dx, this.y + dy);
    }


}
