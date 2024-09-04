
public class DSOFormula {
 
	static  double maturityLevel(double ms){
		 
		 if(ms<=20){
			 return 1+(ms-1)/20;
		 }else if(ms>20 && ms<=50){
			 return 2+(ms-21)/30;
		 }else if(ms>50 && ms<=70){
			 return 3+(ms-51)/20;
		 }else if(ms<71 && ms<=90){
			 return 4+(ms-71)/20;
		 }else{
			 return 5;
		 }
	 }
	 public static void main(String[] args){
		 double x=maturityLevel(45);
		 System.out.println(x);
	 }
}
