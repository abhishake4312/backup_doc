package concurrency.exceptionintro;

import java.io.FileNotFoundException;

public class Client {
    public static void main(String[] args) throws FileNotFoundException {
        Student student = new Student();
//        int score = student.getScore();
        // student.readFile();
//        System.out.println("The score is: ");
//        test(); // exception occurs at this line
//        System.out.println("Just called test");

        System.out.println(student.doSomething());
      //  uncheckedCaller();

    }

    public static void checkCaller() throws FileNotFoundException {
        Student student = new Student();
        student.checkException(); // -> Exception thrown at this line
        System.out.println("Printing from test");
    }
    public static void uncheckedCaller() {
        Student student = new Student();
        System.out.println("Just before calling unchecked caller");
        student.uncheckedException();
        throw new ArithmeticException();
    }
}
