/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pack.connexion.Connexion;
import pack.model.Location;

/**
 *
 * @author Lenovo
 */
public class LocationDao implements Dao<Location> {

   private Connection cnx = Connexion.getConnection();

    public double calculLoyer(Date debut, Date fin, double prixMensuel) {

        if (debut == null || fin == null)
            throw new IllegalArgumentException("Dates invalides");

        if (fin.before(debut))
            throw new IllegalArgumentException("Date fin < date début");

        long diff = fin.getTime() - debut.getTime();
        long jours = TimeUnit.MILLISECONDS.toDays(diff);

        double prixJournalier = prixMensuel / 30.0;
        return jours * prixJournalier;
    }

    // ================= CREATE =================
    @Override
    public boolean create(Location l) {
        try {
            String sql = "INSERT INTO location (id_bien, date_debut, date_fin, loyer) VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.setInt(1, l.getIdBien());
            ps.setDate(2, new java.sql.Date(l.getDateDebut().getTime()));
            ps.setDate(3, new java.sql.Date(l.getDateFin().getTime()));
            ps.setDouble(4, l.getLoyer());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================= UPDATE =================
    @Override
    public boolean update(Location l) {
        try {
            String sql = "UPDATE location SET id_bien=?, date_debut=?, date_fin=?, loyer=? WHERE id_location=?";
            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.setInt(1, l.getIdBien());
            ps.setDate(2, new java.sql.Date(l.getDateDebut().getTime()));
            ps.setDate(3, new java.sql.Date(l.getDateFin().getTime()));
            ps.setDouble(4, l.getLoyer());
            ps.setInt(5, l.getIdLocation());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================= DELETE =================
    @Override
    public boolean delete(Location l) {
        try {
            String sql = "DELETE FROM location WHERE id_location=?";
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, l.getIdLocation());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    // ================= FIND ALL =================
    @Override
    public List<Location> findAll() {
        List<Location> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM location";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Location l = new Location(
                        rs.getInt("id_location"),
                        rs.getInt("id_bien"),
                        rs.getDate("date_debut"),
                        rs.getDate("date_fin"),
                        rs.getDouble("loyer")
                );
                list.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ================= FIND BY ID =================
    @Override
    public Location findById(int id) {
        try {
            String sql = "SELECT * FROM location WHERE id_location=?";
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Location(
                        rs.getInt("id_location"),
                        rs.getInt("id_bien"),
                        rs.getDate("date_debut"),
                        rs.getDate("date_fin"),
                        rs.getDouble("loyer")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ================= RECHERCHE PAR DATE =================
    public List<Location> rechercheParDate(Date debut, Date fin) {
        List<Location> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM location WHERE date_debut >= ? AND date_fin <= ?";
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(debut.getTime()));
            ps.setDate(2, new java.sql.Date(fin.getTime()));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Location(
                        rs.getInt("id_location"),
                        rs.getInt("id_bien"),
                        rs.getDate("date_debut"),
                        rs.getDate("date_fin"),
                        rs.getDouble("loyer")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    
}
