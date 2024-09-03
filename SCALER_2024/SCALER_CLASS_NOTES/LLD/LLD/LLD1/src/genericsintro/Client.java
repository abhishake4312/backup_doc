package genericsintro;

public class Client {

    public static void main(String[] args) {
        Pair<String,Integer> p=new Pair<String,Integer>();
        p.first="abc"; //hence using generics rather than Object compiler power to check is retained
        p.second=2;
        p.setFirst("abc");

       // Pair<Integer,Integer>
    }
}
