package etu1755.framework;

public class Emp {
    String nom;

    public Emp(String nom) {
        setNom(nom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    @Url(url = "Emp-montre")
    public String montre(){
        return "test";
    }
}
