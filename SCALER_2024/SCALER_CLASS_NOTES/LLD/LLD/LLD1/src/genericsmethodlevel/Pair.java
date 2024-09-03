package genericsmethodlevel;

public class Pair<K,V> {
   private K first;
   private V second;

   public void setFirst(K first) {
       this.first = first;
   }
   public void setSecond(V second) {
       this.second = second;
   }
   public K getFirst() {
       return first;
   }
   public V getSecond() {
       return second;
   }
   public static <T,V> V method1(T first, V second) {
       return second;
   }

   public <T,V> Integer method2(T first, V second) {
       Integer a=10;
       return a;
   }
}
