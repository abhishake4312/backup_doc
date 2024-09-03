package genericsmethodlevel;

public class Client {
    public static void main(String[] args) {
        Pair<Integer,String> pair=new Pair<>();
        pair.setFirst(1);
        pair.setSecond("Hello");
        System.out.println(pair);

        // as we are returning V from method1 which is Integer type
      //  String i=Pair.method1("abc",1);
          Integer i=Pair.method1("abc",1);

          Integer a=pair.method2("abc",1);
    }
}
