package model;
import etu1755.annotation.Url;
import etu1755.framework.ModelView;

public class Emp {
    @Url(url="emp-insert")
    public ModelView insert(){
        ModelView mv = new ModelView();
        mv.setView("../emplist.jsp");
        return mv;
    }
}