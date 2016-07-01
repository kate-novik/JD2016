package by.it.kust.jd02_09;

/**
 * Created by user_2 on 01.07.2016.
 */
public class ConverterJsonToXmlBuilder extends AbstractConverter {

    @Override
    public void buildConverter(String filename) {

        /*BufferedReader reader= null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            String json="";
            while (!(line=reader.readLine().isEmpty())){
                json = json.concat(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        gson.fromJson(filename, Students.class);*/

    }

    @Override
    public String getConverterResult() {
       /* JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(Students.class);
            Marshaller marshaller=jc.createMarshaller();
            marshaller.marshal();
        } catch (JAXBException e) {
            e.printStackTrace();
        }*/

        return null;
    }
}
