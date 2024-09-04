package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MaxProtien {
	  static class Touple{
	        int value;
	        int weight;
	        float avg;
	        Touple(int value,int weight,float avg){
	            this.value=value;
	            this.weight=weight;
	            this.avg=avg;
	        }
	    }
	  static  public int calculateMaxProtien(int[] A, int[] B, int C) {
	        int n=A.length;
	        Touple[] touple=new Touple[n];
	        for(int i=0;i<n;i++){
	            Touple t=new Touple(A[i],B[i],(A[i]*1.0f/B[i]));
	            touple[i]=t;
	         
	        }
	        Arrays.sort(touple,new Comparator<Touple>(){
	            public int compare(Touple t1,Touple t2){
	                float avg1=t1.avg;
	                float avg2=t2.avg;
	                if(avg1>avg2){
	                    return -1;
	                } else{
	                    return 1;
	                  }
	              }
	        });
	        int i=0;
	        float sum=0f;
	        while(C>0){
	            Touple t=touple[i];
	            System.out.println(t.avg);
	            int w=t.weight;
	            if(w>C){
	               sum=sum+ C*(t.avg);
	               System.out.println(sum);
	               break;
	            }else{
	                sum+= t.value;
	                C=C-w;
	                i++;
	            }
	        }
	     //   System.out.println("sum outside"+Math.round(sum*100));
	        return (int)(sum*1000)/10;
	    }
 public static void main(String[] args){
	 int[] weight= {53,78,14,97,84,55,11,5,31,9,80,82,20,3,7,78,59,95,80,66,26,48,6,32,57,66,48,44,96,61,28,19,32,10,80,42,26,21,88,9,36,74,41,81,42,4};
	 int[] protien= {22,52,22,67,73,54,83,8,95,51,96,40,97,33,46,24,21,90,66,47,26,24,21,50,8,50,86,41,9,57,51,35,89,11,68,2,75,76,60,2,1,52,58,26,97,58};
	 int capacity=37;
	 double a=2.55;
	// System.out.println(a*100);
	// System.out.println(2.55f*100);
	 
	 double maxProtien= calculateMaxProtien(protien,weight,capacity);
	 System.out.println("maxProtien"+maxProtien);
	 System.out.println(2*2.6f);
	
	 
 }
}
