import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ASCIIEncrption {

    public static Connection connect(String url, String username, String password) {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } 
        catch (ClassNotFoundException e)
        {
            System.out.println("Did you forget to include the library???");
            System.exit(1);
        } 
        catch (InstantiationException ex) {} 
        catch (IllegalAccessException ex) {}
        Connection conn=null;
        try 
        {
            conn = DriverManager.getConnection(url,username,password);
        }
        catch (SQLException ex) 
        {
            System.out.println("Sql connection failed "+ex.toString());
            System.exit(1);
        }
        return conn;
    }
    
    public static Map createMap(Connection con) 
    {
        Map fromto = new HashMap();
        try 
        {
            String query = "Select * from map";
            Statement s = con.createStatement();
            s.executeQuery(query);
            ResultSet rs = s.getResultSet();
            while(rs.next())
            {
                fromto.put(rs.getString("from"), rs.getString("to"));
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("Sql connection failed "+ex.toString());
            System.exit(1);
        }
        return fromto;
    }
    
    public static void encryption(Map keymap, String inputFile, String outputFile) throws FileNotFoundException
    {
        Scanner read = new Scanner(new File(inputFile));
        Writer write = null;
        try 
        {
            write = new BufferedWriter(new OutputStreamWriter(
                  new FileOutputStream(outputFile), "utf-8"));
            while (read.hasNextLine()) 
            {
                String line = read.nextLine();
                for(char searchKey: line.toCharArray())
                {
                    String newSearch = "" + searchKey;
                    if(keymap.containsKey(newSearch))
                    {
                        write.write((String) keymap.get(newSearch));
                    }
                    else
                    {
                        write.write(searchKey);
                    }
                }
            }
        } 
        catch (IOException ex){} 
        finally 
        {
           try 
           {
               write.close();
           } 
           catch (Exception ex) {}
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        String inputFile = "C:\\Users\\Jai\\Desktop\\plain.txt";
        String outputFile = "C:\\Users\\Jai\\Desktop\\encrypted.txt"; 
        
        String dbuser = "cs391";
        String dbpass = "abc123";
        String url = "jdbc:mysql://127.0.0.1/test";
        //String dbuser = "root";
        //String dbpass = "";
        //String url = "jdbc:mysql://localhost/katz";
        Connection con = connect(url, dbuser, dbpass);
        Map keymap = createMap(con);
        encryption(keymap, inputFile, outputFile);
    }
}
