/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import pack.connexion.Connexion;

/**
 *
 * @author Lenovo
 */
public class StatistiqueDao {

    Connection cnx = Connexion.getConnection();

    public ResultSet revenuParVille() throws Exception {
        String sql = "SELECT b.ville, SUM(l.loyer) total FROM location l JOIN bien b ON l.id_bien = b.id_bien GROUP BY b.ville";
        return cnx.createStatement().executeQuery(sql);
    }

    public ResultSet revenuParProprietaire() throws Exception {
        String sql = "SELECT p.nom, SUM(l.loyer) total FROM location l JOIN bien b ON l.id_bien = b.id_bien JOIN proprietaire p ON b.id_proprietaire = p.id_proprietaire GROUP BY p.nom";
        return cnx.createStatement().executeQuery(sql);
    }

    public ResultSet revenuParType() throws Exception {
        String sql = "SELECT b.type, SUM(l.loyer) total FROM location l JOIN bien b ON l.id_bien = b.id_bien GROUP BY b.type";
        return cnx.createStatement().executeQuery(sql);
    }
}

