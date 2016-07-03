package by.it.sergeev.jd02_10.TaskC;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSON_To_XML {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        Products products = new Products(){
            {
                Product product = new Product("Apple", "Iphone", "6s", 2200.2, "Крутая мобила");
                Product product2 = new Product("Samsung", "Galaxy", "5", 1400.2, "Средняя мобила");
                Product product3 = new Product("Nokia", "Nokia", "3310", 0.2, "Лучшая мобила");
                this.add(product);
                this.add(product2);
                this.add(product3);
            }
        };
        String json = gson.toJson(products);
    }
}