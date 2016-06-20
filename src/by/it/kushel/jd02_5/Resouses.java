package by.it.kushel.jd02_5;

import java.util.Locale;
import java.util.ResourceBundle;

public class Resouses {
    private Resouses resouses=null;
    Locale locale;
    ResourceBundle resouceBundle= ResourceBundle.getBundle("by.it.kushel.jd02_05.Messages");
    public Resouses getInstans(){
        if (resouses==null)
            resouses=new Resouses();
        return resouses;
    }
    private void   setLocale(Locale locale){
        this.locale=locale;
    }
    public Resouses getInstans(Locale locale){
        this.locale=locale;
        return  resouses;
        System.out.println(res.getString "helloMessage");
    }

}
