package CTracker.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
    Connection c = null;
    ResultSet rs=null;
    private static Connection connection = null;
    static Statement cursor = null;
    

    public static Connection getConn() throws SQLException {
        if(connection == null) connection = DriverManager.getConnection("jdbc:sqlite:data.db");
        return connection;
    }
    public Connector(){ // Initialise the connection ig
        try {
            Class.forName("org.sqlite.JDBC");
            connection = getConn();
            cursor = connection.createStatement();
            cursor.setQueryTimeout(30); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {   
            e.printStackTrace();
        }
    }

    public ResultSet execute(String q) {
        try {
            rs = cursor.executeQuery(q);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}


    // void connect (){
    //     Connection c = null;
    //     Statement cursor = null;
    //     try {
    //         Class.forName("org.sqlite.JDBC");
    //         c = DriverManager.getConnection("jdbc:sqlite:data.db");
    //         System.out.println("Opened database successfully");
    //         cursor = c.createStatement();
    //         cursor.close();
    //         c.close();
    //     } catch ( SQLException e ) {
    //         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    //         System.exit(0);
    //     } catch(Exception e){
    //         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    //         System.exit(0);
    //     }
        
    // }

    // static void insert(String user,String pass){
    //     Connection c = null;
    //     Statement cursor = null;
    //     try {
    //         Class.forName("org.sqlite.JDBC");
    //         c = DriverManager.getConnection("jdbc:sqlite:data.db");
    //         System.out.println("Opened database successfully");
    //         cursor = c.createStatement();
    //         String sql = "INSERT INTO Users (ID,NAME,PASS) " +
    //                     "VALUES (111,'"+user+"','"+pass+"'"+");"; 
    //         cursor.executeUpdate(sql);
    //         cursor.close();
    //         c.close();
    //     } catch ( SQLException e ) {
    //         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    //         System.exit(0);
    //     } catch(Exception e){
    //         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    //         System.exit(0);
    //     }
    // }

    // static void display(){
    //     Connection c = null;
    //     Statement cursor = null;
    //     try {
    //         Class.forName("org.sqlite.JDBC");
    //         c = DriverManager.getConnection("jdbc:sqlite:data.db");
    //         System.out.println("Opened database successfully");
    //         cursor = c.createStatement();
    //         String sql = "SELECt * FROM Users";
    //         ResultSet r = cursor.executeQuery(sql);
    //         while ( r.next() ) {
    //             String s=r.getString("NAME");
    //             System.out.println(s);
    //         }
    //         cursor.close();
    //         c.close();
    //     } catch ( SQLException e ) {
    //         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    //         System.exit(0);
    //     } catch(Exception e){
    //         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    //         System.exit(0);
    //     }
    // }

    // static void LogIn(String User,String Pass){
    //     Connection c = null;
    //     Statement cursor = null;
    //     try {
    //         Class.forName("org.sqlite.JDBC");
    //         c = DriverManager.getConnection("jdbc:sqlite:data.db");
    //         System.out.println("Opened database successfully");
    //         cursor = c.createStatement();
    //         String sql = "SELECt PASS FROM Users Where NAME='"+User+"'";
    //         ResultSet r = cursor.executeQuery(sql);

    //         if (r.next() == false) {
                
    //             // puthiya user creation with pass 
    //             insert(User,Pass);
    //             System.out.println("New User Created");
    //           }

    //         if(r.getString("PASS").equals(Pass)){
    //             System.out.println("Logged In");
    //         }
    //         else{
    //             System.out.println("Invalid Login");
    //         }
    //         cursor.close();
    //         c.close();
    //     } catch ( SQLException e ) {
    //         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    //         System.exit(0);
    //     } catch(Exception e){
    //         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    //         System.exit(0);
    //     }
    // }

