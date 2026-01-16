/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.model;

/**
 *
 * @author Lenovo
 */
public class Bien {
    private int idBien;
    private String type;
    private String ville;
    private double surface;
    private double prixMensuel;
    private int idProprietaire;

    
    public Bien() {}

    public Bien(int idBien, String type, String ville, double surface, double prixMensuel,int idProprietaire) {
        this.idBien = idBien;
        this.type = type;
        this.ville = ville;
        this.surface = surface;
        this.prixMensuel = prixMensuel;
        this.idProprietaire = idProprietaire;

    }

    public int getIdBien() {
        return idBien;
    }

    public String getType() {
        return type;
    }

    public String getVille() {
        return ville;
    }

    public double getSurface() {
        return surface;
    }

    public double getPrixMensuel() {
        return prixMensuel;
    }

    public void setIdBien(int idBien) {
        this.idBien = idBien;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public void setPrixMensuel(double prixMensuel) {
        this.prixMensuel = prixMensuel;
    }

    public int getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    @Override
    public String toString() {
        return "Bien{" + "N°=" + idBien + ", type=" + type + ", ville=" + ville + '}';
    }

    
    
    
    
}
