package javaclasses;

import java.util.*;
import javaclasses.occurences;

public class BoyerMoore {

    public BoyerMoore(String a,String b){
        this.computerBoyerMoore(a,b);
    }
    public int computerBoyerMoore(String a,String b){
        char lastchar=a.charAt(a.length()-1);
        char comparechar=b.charAt(a.length()-1);
        for(int i=b.length()-1,j;i<a.length();){
            for(j=b.length()-1;a.charAt(j)==b.charAt(i);--i,--j){
                if(j==0){
                    return i;
                }
            }
        }
        int startposition=0;
        int patternsize=b.length()-1;
        int textsize=patternsize;
        for(int i=textsize;i>=startposition;i--){
            if(a.charAt(i)!=b.charAt(i)){
                startposition=i;
            }
        }
        return 0;
    }

    public Map<occurences, Integer> badcharacterheuristics(int i,char b,int skips){
        Map<occurences,Integer> table=new HashMap<occurences, Integer>();
        occurences newocc=new occurences(b,i);
        table.put(newocc,skips);
        return table;
    }
    public int goodsuffix(String a,String b){
        return 0;
    }
}
