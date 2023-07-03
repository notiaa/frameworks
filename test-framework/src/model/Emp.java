package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import etu1755.annotation.Url;
import etu1755.framework.ModelView;

public class Emp {
    @Url(url="emp-insert")
    public ModelView insert(){
        ModelView mv = new ModelView();
        mv.setView("../emplist.jsp");
        List<String> nom = new ArrayList<>();
        nom.addItem("notia");
        nom.addItem("test");
        HashMap<String,Object> hashmap = new HashMap<>();
        hashmap.put("donne",nom);
        mv.setData(hashmap);
        return mv;
    }
}
