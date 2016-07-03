package by.it.sergeev.jd02_10.TaskC;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Products {

    @XmlElement(name = "Products")
    private  ArrayList<Product> arrayList = new ArrayList<>();

    public Products(){
        super();
    }

    public void setArrayList(ArrayList<Product> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public String toString() {
        String out = "";
        for (Product product: arrayList)
            out += product.toString() + "\n";
        return out;
    }

    public boolean add(Product product){
        return arrayList.add(product);
    }
}