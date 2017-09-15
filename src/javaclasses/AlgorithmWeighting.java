package javaclasses;
import javaclasses.BruteForce;
import sun.plugin2.util.BrowserType;

import java.lang.reflect.Array;
import java.util.*;

import javaclasses.DistanceComparator;
import sun.rmi.server.InactiveGroupException;

public class AlgorithmWeighting {
    public BruteForce bf=new BruteForce();
    public Set<ArrayList<Integer>> returnset;
    public ArrayList<Integer> returnlist;
    public ArrayList<Integer> sortlist=new ArrayList<Integer>();
    public int score;

    public AlgorithmWeighting(String a,String b){
        int now;
        returnset=bf.computeBruteForce(a,b);
        System.out.println(returnset);
        for(ArrayList<Integer> al:returnset){
            if(al.size()!=1){
                returnlist=al;
            }
        }
        sortlist=returnlist;
        Collections.sort(sortlist,new DistanceComparator());
        now=this.countsubstrings(a,b);
        this.score=this.scorethedata(sortlist,now);
    }

    public int getscore(){
        return this.score;
    }

    public ArrayList<Integer> returnsortedlist()
    {
        return sortlist;
    }

    public int countsubstrings(String a,String b){
        int now;
        String[] splited = a.split("\\s+");
        String[] splittedb = b.split("\\s+");
        if(splited.length<=splittedb.length){
            now=splited.length;
        }
        else{
            now=splittedb.length;
        }
        return now;
    }

    public int scorethedata(ArrayList<Integer> errors,int numberwords){
        int scre=0;
        for(int i=0;i<numberwords;i++){
            int value=errors.get(i);
            scre+=value;
        }
        return scre;
    }
}

