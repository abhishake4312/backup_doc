package interfaces;

public interface Parent2 {

    public default void method1(){
        System.out.println("this is default method coming from Parent2 interface");
    }
}
