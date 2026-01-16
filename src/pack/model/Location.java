/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.model;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class Location {
    
    private int idLocation;   // id_location
    private int idBien;       // id_bien
    private Date dateDebut;
    private Date dateFin;
    private double loyer;

    public Location() {
    }

    public Location(int idLocation, int idBien, Date dateDebut, Date dateFin, double loyer) {
        this.idLocation = idLocation;
        this.idBien = idBien;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.loyer = loyer;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public int getIdBien() {
        return idBien;
    }

    public void setIdBien(int idBien) {
        this.idBien = idBien;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getLoyer() {
        return loyer;
    }

    public void setLoyer(double loyer) {
        this.loyer = loyer;
    }
    
    
}
