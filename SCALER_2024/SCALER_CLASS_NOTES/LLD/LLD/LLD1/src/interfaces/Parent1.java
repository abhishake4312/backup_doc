package interfaces;

public interface Parent1 {

    public default void method1(){
        System.out.println("this is default method coming from Parent1 interface");
    }
}
