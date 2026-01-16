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
public class Proprietaire {
    
    private int idProprietaire;
    private String nom;
    private String contact;
    private String adresse;

    
    public Proprietaire() {
    }

    
    public Proprietaire(int idProprietaire, String nom, String contact, String adresse) {
        this.idProprietaire = idProprietaire;
        this.nom = nom;
        this.contact = contact;
        this.adresse = adresse;
    }

    public int getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return  nom ;
    }
    
    
    
}
