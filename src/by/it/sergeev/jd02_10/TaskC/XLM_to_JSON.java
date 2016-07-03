package by.it.sergeev.jd02_10.TaskC;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class XLM_to_JSON {
    public static void main(String[] args) {
        try{
            //XML to Class
            JAXBContext context = JAXBContext.newInstance(Products.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader reader = new FileReader("src\\by\\it\\sergeev\\jd02_10\\TaskC\\Product.xml");
            Products products = (Products) unmarshaller.unmarshal(reader);

            //Class to json
            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String json = gson.toJson(products);
            System.out.println("JSOM from XML.");
            System.out.println(json);

            //json to class
            Products productsOut = gson.fromJson(json, Products.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(productsOut, new FileOutputStream("src\\by\\it\\sergeev\\jd02_10\\TaskC\\From_JSON.xml"));
        } catch (JAXBException | FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}