package hashcode_equals.hasmap;

import java.util.Objects;

public class Point {

    private int x;
    private int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point)) {
            return false;
        }
        Point p = (Point)obj;
        if(this.x == p.x && this.y == p.y) {
           return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
}
