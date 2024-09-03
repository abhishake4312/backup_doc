package concurrency.synchronisedMethod;

public class Count {
    private int count;

    public synchronized void changeValue(int i){
        count+=i;
   //     System.out.println(count);
    }
    public int getValue(){
        return count;
    }
}
