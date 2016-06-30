package by.it.novik.jd02_09.beans;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by Kate Novik.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Roll implements Serializable {
    @XmlAttribute(name="idRoll",required = true)
    private BigInteger idRoll;
    @XmlAttribute(name="name",required = true)
    private String name;

    public Roll() {
        super();
    }

    public BigInteger getIdRoll() {
        return idRoll;
    }

    public void setIdRoll(BigInteger idRoll) {
        this.idRoll = idRoll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roll roll = (Roll) o;

        if (idRoll != null ? !idRoll.equals(roll.idRoll) : roll.idRoll != null) return false;
        return name != null ? name.equals(roll.name) : roll.name == null;

    }

    @Override
    public int hashCode() {
        int result = idRoll != null ? idRoll.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Roll{" +
                "idRoll=" + idRoll +
                ", name='" + name + '\'' +
                '}' + '\n';
    }
}
