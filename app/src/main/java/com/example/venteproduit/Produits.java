package com.example.venteproduit;

public class Produits {
    String NomProduit, Catégorie, Prix;

    public Produits(){

    }

    public Produits(String nomProduit, String catégorie,String prix) {
        this.NomProduit = nomProduit;
        this.Catégorie = catégorie;
        this.Prix = prix;
    }

    public void setCatégorie(String catégorie) {
        this.Catégorie = catégorie;
    }

    public void setPrix(String prix) {
        this.Prix = prix;
    }

    public void setNomProduit(String nomProduit) {
        this.NomProduit = nomProduit;
    }

    public String getCatégorie() {
        return Catégorie;
    }

    public String getPrix() {
        return Prix;
    }

    public String getNomProduit() {
        return NomProduit;
    }
}
