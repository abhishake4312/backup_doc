package binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianArraysSorted {
	public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int x= a.size();
        int y= b.size();
        
        if(x>y){
            return findMedianSortedArrays(b,a);
        }
       
        int l=0;
        int h=x;
        double ret= 0.0;
        while(l<=h){
            int splita= (l+h)/2;
            int splitb= (x+y+1)/2-splita;

            int aleftmax= (splita==0)?Integer.MIN_VALUE:a.get(splita-1);
           
            int arightmin= (splita==x)?Integer.MAX_VALUE:a.get(splita);
            int bleftmax= (splitb==0)?Integer.MIN_VALUE:b.get(splitb-1);
            int brightmin= (splitb==y)?Integer.MAX_VALUE:b.get(splitb);
            System.out.println(aleftmax+" "+arightmin+" "+bleftmax+" "+brightmin);

            if(aleftmax<= brightmin && bleftmax <= arightmin){
                if((x+y)%2!=0){
                    return Math.max(bleftmax,aleftmax);
                   
                }else{
                	System.out.println("enters in else");
                     ret= ( (double)Math.max(bleftmax,aleftmax)+Math.min(brightmin,arightmin))/2;
                     return ret;
                   
                }
            }
            if(aleftmax>brightmin){
                h=splita-1;
            }else if(bleftmax>arightmin){
                l=splita+1;
            }
        }
        return 0.0;
	
    }
	public static void main(String[] args){
		ArrayList<Integer> a=new ArrayList<Integer>();
		ArrayList<Integer> b=new ArrayList<Integer>(
				Arrays.asList(0,23));
		System.out.println(findMedianSortedArrays(b,a));

	}
}
