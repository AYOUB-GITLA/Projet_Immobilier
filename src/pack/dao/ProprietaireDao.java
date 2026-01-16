/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pack.connexion.Connexion;
import pack.model.Proprietaire;

/**
 *
 * @author Lenovo
 */
public class ProprietaireDao implements Dao<Proprietaire>{

    private Connection con = Connexion.getConnection();

    @Override
    public boolean create(Proprietaire o) {
        String sql = "INSERT INTO proprietaire(nom, contact, adresse) VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getContact());
            ps.setString(3, o.getAdresse());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Proprietaire o) {
        String sql = "DELETE FROM proprietaire WHERE id_proprietaire=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, o.getIdProprietaire());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(Proprietaire o) {
        String sql = "UPDATE proprietaire SET nom=?, contact=?, adresse=? WHERE id_proprietaire=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getContact());
            ps.setString(3, o.getAdresse());
            ps.setInt(4, o.getIdProprietaire());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<Proprietaire> findAll() {
        List<Proprietaire> list = new ArrayList<>();
        String sql = "SELECT * FROM proprietaire";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new Proprietaire(
                    rs.getInt("id_proprietaire"),
                    rs.getString("nom"),
                    rs.getString("contact"),
                    rs.getString("adresse")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Proprietaire findById(int id) {
        String sql = "SELECT * FROM proprietaire WHERE id_proprietaire=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Proprietaire(
                    rs.getInt("id_proprietaire"),
                    rs.getString("nom"),
                    rs.getString("contact"),
                    rs.getString("adresse")
                );
            }
        } catch (SQLException e) {}
        return null;
    }
    
}
