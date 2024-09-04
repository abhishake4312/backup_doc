package inheritence;

public class Client {
    public static void main(String[] args) {
        P obj = new C();
        System.out.println(obj.d1);
        System.out.println(obj.d);
        obj.fun1();
        obj.fun();
        obj.sfun();

        Parent p=new Child("abhi",24);
        System.out.println();
    }
}
