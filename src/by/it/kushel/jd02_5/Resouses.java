package by.it.kushel.jd02_5;

import java.util.Locale;
import java.util.ResourceBundle;


public class Resouses {
    public static void main(String[] args) {


    //private Resouses resouses=null;
    Locale locale;
    Locale loc1 = new Locale("ru","RU");
    ResourceBundle resouceBundle= ResourceBundle.getBundle("by.it.kushel.jd02_5.Messages", loc1);

    String computerButtonLabel = resouceBundle.getString("helloMessage") ;
    System.out.println( computerButtonLabel);

   /* public Resouses getInstans(){
        if (resouses!=null)
            resouses=new Resouses();
        return resouses;
    }
    private void   setLocale(Locale locale){
        this.locale=locale;
    }*/
/*    public resourses getInstans(Locale locale){
        this.locale=locale;
        System.out.println(resouceBundle.getString("helloMessage"));
        return resouses;
    }*/

}
}

