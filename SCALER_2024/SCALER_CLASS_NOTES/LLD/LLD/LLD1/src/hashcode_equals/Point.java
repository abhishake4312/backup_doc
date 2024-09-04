package hashcode_equals;

public class Point {

    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Point)) {
            return false;
        }
        Point o=(Point)obj;
        if(this.x==o.x && this.y==o.y) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return x+y;
    }
}
