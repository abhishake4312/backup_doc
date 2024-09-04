package designpattern;

public class StaticNonStatic {

     int a ;
     static void method1(StaticNonStatic s){
         // can't call NSM as to call NSM we need an instance
         //System.out.println(a);

         //if we have an instance then we can call NSM
         System.out.println(s.a);
     }
}
