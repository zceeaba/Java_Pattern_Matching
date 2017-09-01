package javaclasses;


import java.sql.*;

public class mysqldeterministiccompare
{
    public static void main(String[] args)
    {   long startTime=System.nanoTime();
        new mysqldeterministiccompare().datafetch();
        long endTime=System.nanoTime();
        long duration=(endTime-startTime);
        System.out.println(duration+"secs");
    }
    public void datafetch(){
        try {
            System.out.println("Parser");
            //Command to register a driver in Java(We dynamically load Java's driver class file into memory)
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost", "root", "QAzx.1ws");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM gtr_organisations.personview p JOIN isisdb.isisview i  "+
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

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(4) + " " + rs.getString(3));
            }
            con.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

