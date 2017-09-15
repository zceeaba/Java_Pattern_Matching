package javaclasses;


import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import javaclasses.BruteForce;
import javaclasses.LevenshteinDistance;
import java.io.File;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;


import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class mysqldeterministiccompare
{
    public LevenshteinDistance lv=new LevenshteinDistance();
    public static void main(String[] args)
    {   long startTime=System.nanoTime();
        //new mysqldeterministiccompare().datafetch();
        mysqldeterministiccompare msc=new mysqldeterministiccompare();
        msc.datalevenshteinfetch();
        msc.compareelements();
        long endTime=System.nanoTime();
        long duration=(endTime-startTime);
        System.out.println(duration+"secs");
    }

    public ArrayList<ArrayList<String>> ai=new ArrayList<ArrayList<String>>();
    public ArrayList<ArrayList<String>> as=new ArrayList<ArrayList<String>>();
    //public Map<StringBuilder,StringBuilder> mi=new HashMap<StringBuilder, StringBuilder>();
    //public Map<StringBuilder,StringBuilder> mp=new HashMap<StringBuilder, StringBuilder>();
    public Multimap<String,ArrayList<String>> mi=ArrayListMultimap.create();
    public Multimap<String,ArrayList<String>> mp=ArrayListMultimap.create();

    public BruteForce bf=new BruteForce();

    public void datalevenshteinfetch(){
        try {
            System.out.println("Parser");
            //Command to register a driver in Java(We dynamically load Java's driver class file into memory)
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost", "root", "QAzx.1ws");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM gtr_organisations.personview");

            System.out.print("The query has been executed");

            while (rs.next()) {
                ArrayList<String> ial=new ArrayList<String>();
                ial.add(rs.getString(1));
                ial.add(rs.getString(3));
                ial.add(rs.getString(4));
                as.add(ial);

                StringBuilder sb=new StringBuilder(rs.getString(1));
                sb.append(rs.getString(3));
                sb.append(rs.getString(4));
                if(rs.getString(1).length()!=0&&rs.getString(3).length()!=0)
                {
                    StringBuilder sk = new StringBuilder(Character.toString(rs.getString(1).charAt(0)));
                    sk.append(Character.toString(rs.getString(3).charAt(0)));
                    mp.put(sk.toString(), ial);
                }
            }
            rs.close();
            //System.out.println(as);
            con.close();

            Connection conb = DriverManager.getConnection(
                    "jdbc:mysql://localhost", "root", "QAzx.1ws");

            Statement stmtb = conb.createStatement();
            ResultSet ri = stmtb.executeQuery("SELECT * FROM isisdb.isisview");

            while (ri.next()) {
                ArrayList<String> ial=new ArrayList<String>();
                ial.add(ri.getString(1));
                ial.add(ri.getString(2));
                ial.add(ri.getString(4));
                ial.add(ri.getString(5));
                ai.add(ial);

                StringBuilder sb=new StringBuilder(ri.getString(1));
                sb.append(ri.getString(2));
                sb.append(ri.getString(4));
                sb.append(ri.getString(5));
                if(ri.getString(1).length()!=0&&ri.getString(4).length()!=0) {
                    StringBuilder sk = new StringBuilder(Character.toString(ri.getString(1).charAt(0)));
                    sk.append(Character.toString(ri.getString(4).charAt(0)));
                    mi.put(sk.toString(),ial);
                }
            }
            //System.out.println(ai);
            ri.close();
            conb.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public void compareelements() {
        int count = 0;
        Set<String> x=mp.keySet();
        Set<String> y=mi.keySet();

        /*
        for(String b:y){
            for(String a:x){
                //System.out.println(b);
                //System.out.println(a);
                //System.out.println(mp.get(a));
                if(a.equals(b)){
                    System.out.println("They equal");
                    //System.out.println(mi.get(a));
                    //System.out.println(mi.get(b));
                }
                System.out.println(mp.get(a));
            }
        }
        */
        int ct=0;
        for(String juice:x){
            if(juice.equals("AB")){
                ct+=1;
                System.out.println(juice);
            }
        }
        System.out.println(ct);

        ArrayList<Set<ArrayList<Integer>>> mainlist=new ArrayList<Set<ArrayList<Integer>>>();
        Map<String,Integer> scores=new HashMap<String, Integer>();
        /*
        for(String a:x){
            //System.out.println(mp.get(a));
            //System.out.println(a);

            System.out.println(a);

            if(y.contains(a))
            {
                System.out.println(mp.get(a).size());
                System.out.println(mp.get(a));
                System.out.println(mi.get(a).size());
                System.out.println(mi.get(a));
                System.out.println("count");
                System.out.println(count);
                for(ArrayList<String> object : mp.get(a))
                {
                    for(ArrayList<String> objecti:mi.get(a)) {
                        //System.out.println(objecti);
                        if (object.get(0).length() == 0 || objecti.get(0).length() == 0||object.get(1).length()==0
                                ||object.get(2).length()==0||objecti.get(1).length()==0||objecti.get(2).length()==0
                                ||objecti.get(3).length()==0)
                        {

                            //System.out.println("Incompatible data");
                        }
                        else
                        {
                            File file=new File("C:\\Users\\Sif49882\\IdeaProjects\\json parser\\src\\javaclasses\\error.txt");
                            try {
                                PrintWriter writer = new PrintWriter(file);
                            try {
                                AlgorithmWeighting aw = new AlgorithmWeighting(object.get(2), objecti.get(3));
                                int score=aw.getscore();
                                scores.put(object.get(2)+" "+objecti.get(3),score);
                                aw=null;
                            }
                            catch (Exception e){
                                writer.write(e.toString());
                            }
                            }
                            catch (Exception e){
                               System.out.println("error");
                            }
                            if (object.get(0).equals(objecti.get(1)) || object.get(0).charAt(0) == objecti.get(1).charAt(0))
                            {
                                if (object.get(1).equals(objecti.get(2)))
                                {
                                    if (object.get(2).equals(objecti.get(3)))
                                    {
                                        mainlist.add(bf.computeBruteForce(object.get(2),objecti.get(3)));
                                        count += 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        */
        for(String a:x){
            //System.out.println(mp.get(a));
            //System.out.println(a);

            System.out.println(a);

            if(y.contains(a))
            {
                System.out.println(mp.get(a).size());
                System.out.println(mp.get(a));
                System.out.println(mi.get(a).size());
                System.out.println(mi.get(a));
                System.out.println("count");
                System.out.println(count);
                for(ArrayList<String> object : mp.get(a))
                {
                    for(ArrayList<String> objecti:mi.get(a)) {
                        /*System.out.println("First object");
                        System.out.println(object);
                        System.out.println("second object");
                        System.out.println(objecti);
                        System.out.println(count);
                        */
                        //System.out.println(objecti);
                        if (object.get(0).length() == 0 || objecti.get(0).length() == 0||object.get(1).length()==0
                                ||object.get(2).length()==0||objecti.get(1).length()==0||objecti.get(2).length()==0
                                ||objecti.get(3).length()==0)
                        {

                            //System.out.println("Incompatible data");
                        }
                        else
                        {
                            if (object.get(0).equals(objecti.get(1)) || object.get(0).charAt(0) == objecti.get(1).charAt(0))
                            {
                                if (lv.computeLevenshtein(object.get(1),objecti.get(2))<2)
                                {
                                    if (lv.computeLevenshtein(object.get(2),objecti.get(3))<5)
                                    {   /*System.out.println(object.get(0));
                                        System.out.println(object.get(1));
                                        System.out.println(objecti.get(2));
                                        System.out.println(object.get(2));
                                        System.out.println(objecti.get(3));
                                        */
                                        mainlist.add(bf.computeBruteForce(object.get(2),objecti.get(3)));
                                        count += 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

        //System.out.println(y);
        /*
        for (ArrayList<String> a : as) {
            for (ArrayList<String> b : ai) {
                if (a.get(0).length() == 0 || b.get(0).length() == 0) {
                    System.out.println("Empty");
                }
                else
                    {
                    System.out.println(a.get(0).charAt(0));
                    System.out.println(b.get(0).charAt(0));
                    if (a.get(0) == b.get(1) ||a.get(0).charAt(0) == b.get(0).charAt(0)) {
                        if (a.get(1) == b.get(2)) {
                            if (a.get(2) == b.get(3)) {
                                {
                                    count += 1;

                                }
                            }
                        }
                    }
                }
            }
        }
        */

        System.out.println(count);
        System.out.println(mainlist);
        System.out.println(scores);

    }
    public void datafetch(){
        try {
            System.out.println("Parser");
            //Command to register a driver in Java(We dynamically load Java's driver class file into memory)
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost", "root", "QAzx.1ws");
            Statement stmt = con.createStatement();
            ResultSet ra = stmt.executeQuery("SELECT * FROM gtr_organisations.personview p JOIN isisdb.isisview i  "+
                    "WHERE p.surname=i.FAMILY_NAME AND p.name=i.ORG_NAME AND\n" +
                    "\tCASE WHEN i.FIRST_NAME_KNOWN_AS = \"\" AND i.GIVEN_NAME = \"\"\n" +
                    "\t\tTHEN ((left(i.initials, 1) = left(p.firstname,1) OR (left(i.initials, 1) = left(p.othername,1))))\n" +
                    "        \n" +
                    "\t\tWHEN  i.FIRST_NAME_KNOWN_AS <> \"\" AND i.GIVEN_NAME <> \"\"\n" +
                    "\t\tTHEN ((i.FIRST_NAME_KNOWN_AS=p.firstname OR i.GIVEN_NAME=p.firstname))\n" +
                    "        \n" +
                    "\t\tELSE \"Couldn't find match\"\n" +
                    "END"
            );
            System.out.print("The query has been executed");

            while (ra.next()) {
                //System.out.println(ra.getString(1) + " " + ra.getString(4) + " " + ra.getString(3));
            }
            con.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

