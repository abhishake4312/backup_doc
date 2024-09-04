import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int val=map.getOrDefault(0,2);
        map.put(0,val);
        System.out.println(map.get(0));
    }
}