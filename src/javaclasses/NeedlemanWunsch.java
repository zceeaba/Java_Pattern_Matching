package javaclasses;
import java.lang.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javaclasses.Coord;

public class NeedlemanWunsch {
    public Map<Integer,Integer> arrows=new LinkedHashMap<Integer, Integer>();
    public List<Coord> directions=new ArrayList<Coord>();

    public int computeNeedle(String a,String b){
        int sizestringa=(a.length());
        int sizestringb=(b.length());
        int[][] matrix;
        matrix=this.preprocessmatrix(sizestringa,sizestringb);
        for(int i=1;i<a.length();i++){
            for(int j=1;j<b.length();j++){
                matrix[i][j]=choosebest(i,j,a.charAt(i-1),b.charAt(j-1),matrix);
            }
        }
        System.out.println(matrix[sizestringa-1][sizestringb-1]);
        for(int k=0;k<sizestringa;k++){
            for(int l=0;l<sizestringb;l++){
                System.out.println(matrix[k][l]);
            }
        }
        return matrix[sizestringa-1][sizestringb-1];
    }
    public int[][] preprocessmatrix(int sizestringa,int sizestringb){
        int[][] dummymatrix=new int[sizestringa][sizestringb];
        for(int i=0;i<sizestringa;i++){
            int k=0;
            dummymatrix[i][k]=i*(-1);
        }
        for(int j=0;j<sizestringb;j++){
            int k=0;
            dummymatrix[k][j]=j*(-1);
        }
        return dummymatrix;
    }
    public int scoringscheme(char x,char y){
        int alignmentscore,subscore,gappen;
        //reward for match:1,-1 penalty for mismatch,ignore gaps
        int score=0;
        if(x==y){
            System.out.println(x);
            System.out.println(y);
            System.out.println("That is a match");
            score=1;
        }
        else if(x==' ' || y==' '){
            System.out.println("That was a gap");
            score=-1;
        }
        else if(x!=y){
            System.out.println(x);
            System.out.println(y);
            System.out.println("That is not a match");
            score=-1;
        }
        return score;
    }
    public int choosebest(int i,int j,char x,char y,int[][] matrix){
        int score=50;
        int qdiag=matrix[i-1][j-1]+scoringscheme(x,y);
        int qup=matrix[i-1][j]-(1);
        int qleft=matrix[i][j-1]-(1);
        //score=Math.min(qdiag,Math.min(qup,qleft));
        if(qdiag<qup&&qdiag<qleft){
            score=qdiag;
            this.storescoredirection(matrix,i,j,"qdiag");
        }
        else if(qup<qdiag&&qup<qleft){
            score=qup;
            this.storescoredirection(matrix,i,j,"qup");
        }
        else if(qleft<qup&&qleft<qdiag){
            score=qleft;
            this.storescoredirection(matrix,i,j,"qleft");
        }
        else if(qdiag==qleft&&qdiag<qup){
            score=qdiag;
            this.storescoredirection(matrix,i,j,"qdiag");
            this.storescoredirection(matrix,i,j,"qleft");
        }
        else if(qdiag==qup&&qdiag<qleft){
            score=qdiag;
            this.storescoredirection(matrix,i,j,"qdiag");
            this.storescoredirection(matrix,i,j,"qup");
        }
        else if(qup==qleft&&qup<qdiag){
            score=qup;
            this.storescoredirection(matrix,i,j,"qup");
            this.storescoredirection(matrix,i,j,"qleft");
        }
        return score;
    }
    public void storescoredirection(int[][] matrix,int i,int j,String s){
        Coord centrepoint=new Coord(i,j);
        this.directions.add(centrepoint);
        if(s.equals("qdiag")){
            Coord diagpoint=new Coord(i-1,j-1);
            centrepoint.generatesegment(centrepoint,diagpoint);
        }
        else if(s.equals("qup")){
            Coord uppoint=new Coord(i-1,j);
            centrepoint.generatesegment(centrepoint,uppoint);
        }
        else if(s.equals("qleft")){
            Coord leftpoint=new Coord(i,j-1);
            centrepoint.generatesegment(centrepoint,leftpoint);
        }
    }
}
