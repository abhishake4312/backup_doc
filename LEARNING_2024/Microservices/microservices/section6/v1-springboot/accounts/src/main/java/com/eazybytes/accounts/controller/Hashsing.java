package com.eazybytes.accounts.controller;

import java.util.ArrayList;
import java.util.HashMap;

public class Hashsing {
       static method1 (String s1 ,String s2){
        String s3=s1+" "+s2;
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        String[] sadd=s3.split(" ");
        for(int i=0;i<sadd.length;i++){
               
            String inner=sadd[i];
            if(hm.containsKey(inner)){
                hm.put(inner,hm.get(inner)+1);
            }else{
                hm.put(inner,1);
            }
        }
        ArrayList<String> ret=new ArrayList<>();
        for(int i=0;i<sadd.length;i++){
            if(hm.get(sadd[i])==1){
                ret.add(sadd[i]);
            }
        }
        return ret;
    }
    a= "abcd"
    b= "abmncd"
     method2(String[] s1,String s2){
        for(int i=0;i<s1.length;i++){
            String a=s1[i];
            String b=s2;
            int j=0;
            int k=0;
            while(j<a.length()){
                if(a.charAt(j)==b.charAt(k)){
                    j++;
                    k++;
                }else{
                    k++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String s= "This is sweet apple";
        String s2="This is sour apple";
    }
}



