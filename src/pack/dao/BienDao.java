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
import pack.model.Bien;

/**
 *
 * @author Lenovo
 */
public class BienDao implements Dao<Bien> {

    private Connection con = Connexion.getConnection();

    @Override
    public boolean create(Bien o) {
        String sql = "INSERT INTO bien(type, ville, surface, prix_mensuel, id_proprietaire) "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, o.getType());
            ps.setString(2, o.getVille());
            ps.setDouble(3, o.getSurface());
            ps.setDouble(4, o.getPrixMensuel());
            ps.setInt(5, o.getIdProprietaire());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Bien o) {
        String sql = "DELETE FROM bien WHERE id_bien=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, o.getIdBien());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(Bien o) {
        String sql = "UPDATE bien SET type=?, ville=?, surface=?, prix_mensuel=?, id_proprietaire=? "
                + "WHERE id_bien=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, o.getType());
            ps.setString(2, o.getVille());
            ps.setDouble(3, o.getSurface());
            ps.setDouble(4, o.getPrixMensuel());
            ps.setInt(5, o.getIdProprietaire());
            ps.setInt(6, o.getIdBien());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Bien> findAll() {
        List<Bien> list = new ArrayList<>();
        String sql = "SELECT * FROM bien";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new Bien(
                        rs.getInt("id_bien"),
                        rs.getString("type"),
                        rs.getString("ville"),
                        rs.getDouble("surface"),
                        rs.getDouble("prix_mensuel"),
                        rs.getInt("id_proprietaire")
                ));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    @Override
    public Bien findById(int id) {
        String sql = "SELECT * FROM bien WHERE id_bien=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Bien(
                        rs.getInt("id_bien"),
                        rs.getString("type"),
                        rs.getString("ville"),
                        rs.getDouble("surface"),
                        rs.getDouble("prix_mensuel"),
                        rs.getInt("id_proprietaire")
                );
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public List<Bien> findByType(String type) {
        List<Bien> list = new ArrayList<>();
        String sql = "SELECT * FROM bien WHERE type=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bien(
                        rs.getInt("id_bien"),
                        rs.getString("type"),
                        rs.getString("ville"),
                        rs.getDouble("surface"),
                        rs.getDouble("prix_mensuel"),
                        rs.getInt("id_proprietaire")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<Bien> findByVille(String ville) {
        List<Bien> list = new ArrayList<>();
        String sql = "SELECT * FROM bien WHERE ville=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ville);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bien(
                        rs.getInt("id_bien"),
                        rs.getString("type"),
                        rs.getString("ville"),
                        rs.getDouble("surface"),
                        rs.getDouble("prix_mensuel"),
                        rs.getInt("id_proprietaire")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<String> findTypes() {
        List<String> types = new ArrayList<>();
        String sql = "SELECT DISTINCT type FROM bien";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                types.add(rs.getString("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return types;
    }

    public List<String> findVilles() {
        List<String> villes = new ArrayList<>();
        String sql = "SELECT DISTINCT ville FROM bien";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                villes.add(rs.getString("ville"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return villes;
    }

}
