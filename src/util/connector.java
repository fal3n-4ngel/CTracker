package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
    void connect (){
        Connection c = null;
        Statement cursor = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:data.db");
            System.out.println("Opened database successfully");
            cursor = c.createStatement();
            cursor.close();
            c.close();
        } catch ( SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
    }

    static void insert(String user,String pass){
        Connection c = null;
        Statement cursor = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:data.db");
            System.out.println("Opened database successfully");
            cursor = c.createStatement();
            String sql = "INSERT INTO Users (ID,NAME,PASS) " +
                        "VALUES (111,'"+user+"','"+pass+"'"+");"; 
            cursor.executeUpdate(sql);
            cursor.close();
            c.close();
        } catch ( SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    static void display(){
        Connection c = null;
        Statement cursor = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:data.db");
            System.out.println("Opened database successfully");
            cursor = c.createStatement();
            String sql = "SELECt * FROM Users";
            ResultSet r = cursor.executeQuery(sql);
            while ( r.next() ) {
                String s=r.getString("NAME");
                System.out.println(s);
            }
            cursor.close();
            c.close();
        } catch ( SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    static void LogIn(String User,String Pass){
        Connection c = null;
        Statement cursor = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:data.db");
            System.out.println("Opened database successfully");
            cursor = c.createStatement();
            String sql = "SELECt PASS FROM Users Where NAME='"+User+"'";
            ResultSet r = cursor.executeQuery(sql);
            if(r.getString("PASS")==Pass){
                System.out.println("Logged In");
            }
            cursor.close();
            c.close();
        } catch ( SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }


    public static void main(String args[]) {
        insert("user","pass");
        LogIn("user","pass");
        }
    }
