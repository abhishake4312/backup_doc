package datastructure.typecast;

public class CharIntCovert {
  public static void main(String[] args){
	  int x=20;
	  char b= (char) (x+'0');
	  System.out.println(x);
	  System.out.println(b);
	  char d= (char)(100);
	  System.out.println(d);
	  
	  char c = Character.forDigit(x, 10);
	  System.out.println(c);
  }
}
