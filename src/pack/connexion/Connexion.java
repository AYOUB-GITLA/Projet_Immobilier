/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Connexion {
    
    private static String login = "root";
	private static String password = "";
	private static String url = "jdbc:mysql://localhost:3306/db_immobilier";
	
	private static Connection connection = null;
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			setConnection(DriverManager.getConnection(url, login, password));
		} catch (ClassNotFoundException e) {
			System.out.println("Driver introvable "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("impossible de se connecter "+ e.getMessage());
		}	
	}

    /**
     * @return the connection
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * @param aConnection the connection to set
     */
    public static void setConnection(Connection aConnection) {
        connection = aConnection;
    }

   
        
        
    
}
