package by.it.kust.jd02_09.TaskB;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by Tanya Kust.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tours", propOrder = {
        "tours"
})
public class Tours {
    @XmlElement(name = "tour")
    private ArrayList<Tour> tours = new ArrayList<Tour>();

    public void setTours(ArrayList<Tour> tours) {
        this.tours = tours;
    }

    public ArrayList<Tour> getTours() {
        return tours;
    }

    public boolean add(Tour tour){
        return tours.add(tour);
    }

    @Override
    public String toString() {
        return "Tours{" +
                "tours=\n" + tours +
                '}';
    }

    public Tours() {
    }
}
