package hashcode_equals.hasmap;

import java.util.HashMap;

public class Client {
    public static void main(String[] args) {
        HashMap<Point,String> hm=new HashMap<Point,String>();
        Point p=new Point(1,2);
        hm.put(p,"A");

        Point p2=new Point(1,2);
        System.out.println(hm.get(p2));
    }
}
