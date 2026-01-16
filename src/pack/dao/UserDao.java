/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.dao;

import java.sql.*;
import java.sql.PreparedStatement;
import pack.connexion.Connexion;

/**
 *
 * @author Lenovo
 */
public class UserDao {
    Connection cn = Connexion.getConnection();

    public boolean login(String email, String password) {
        try {
            String sql = "SELECT * FROM users WHERE Email=? AND PassWord=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
}
