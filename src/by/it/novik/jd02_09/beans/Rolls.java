package by.it.novik.jd02_09.beans;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Kate Novik.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rolls", propOrder = {
        "Roll"
})
public class Rolls implements Serializable {
    @XmlElement(name="Roll")
    private ArrayList<Roll> listRolls = new ArrayList<>();

    public Rolls() {
        super();
    }

    public ArrayList<Roll> getListRolls() {
        return listRolls;
    }

    public void setListRolls(ArrayList<Roll> listRolls) {
        this.listRolls = listRolls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rolls rolls = (Rolls) o;

        return listRolls != null ? listRolls.equals(rolls.listRolls) : rolls.listRolls == null;

    }

    @Override
    public int hashCode() {
        return listRolls != null ? listRolls.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Rolls{" +
                "listRolls=" + listRolls +
                '}';
    }
}
