package by.it.sergeev.jd02_10.TaskAB;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSON {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        Product prod = new Product("Apple", "Iphone", "6s", 2200.2, "Крутая мобила");
        // задание А
        String json = gson.toJson(prod);
        System.out.println(json);
        // задание B
        Product tourDem = gson.fromJson(json, Product.class);
        System.out.println(tourDem.toString());
    }
}