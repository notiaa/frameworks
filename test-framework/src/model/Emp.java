package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import etu1755.annotation.Url;
import etu1755.framework.ModelView;

public class Emp {
    int id;
    String nom;

    @Url(url="emp-insert" )
    public ModelView insert(){
        ModelView mv = new ModelView();
        mv.setView("../emplist.jsp");
        List<String> noms = new ArrayList<>();
        noms.add("notia");
        noms.add("test");
        HashMap<String,Object> hashmap = new HashMap<>();
        hashmap.put("donne",nom);
        mv.setData(hashmap);
        return mv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
