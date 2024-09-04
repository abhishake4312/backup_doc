package datastructure.recursion;

public class Increasecount {
	
	static int count2=0;
	static int funcbyvalue(int s1,int s2,int d1,int d2,int count){
		if(s1==d1 && s2==d2){
			return  ++count;
		}
		if(s1>d1 || s2>d2){
			return count;
		}
		count=funcbyvalue(s1,s2+1,d1,d2,count);
		count=funcbyvalue(s1+1,s2,d1,d2,count);
		return count;
	}
	static void passbyref(int s1,int s2,int d1,int d2){
		if(s1==d1 && s2==d2){
			count2++;
			return;
		}
		if(s1>d1 || s2>d2){
			return ;
		}
		passbyref(s1,s2+1,d1,d2);
		passbyref(s1+1,s2,d1,d2);
		
	}

	public static void main(String[] args){
		
		System.out.println(funcbyvalue(0,0,2,2,0));
		Integer count=new Integer(0);
		count++;
		System.out.println(count);
		passbyref(0,0,2,2);
		System.out.println(count2);
	}
}
