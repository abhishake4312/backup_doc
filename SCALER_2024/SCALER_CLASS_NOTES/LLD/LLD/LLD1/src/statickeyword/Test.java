package statickeyword;

public class Test {

    private static int x;

    Test(int x) {
        this.x = x;
    }
    public static void method1(){
        System.out.println(x);
    }
    public void method2(){
        method1(); //can access static from non-static
        System.out.println("method2");
    }
    public static void main(String[] args) {
        Test test = new Test(5);
        test.method1();

        Test test2 = new Test(10);
        test2.method1();

     //   method2(); //can't access non-static from static .
        System.out.println(test.x);
        System.out.println(test2.x);
    }
}
