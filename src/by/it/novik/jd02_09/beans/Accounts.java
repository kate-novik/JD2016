package by.it.novik.jd02_09.beans;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by Kate Novik.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Accounts", propOrder = {
        "Account"
})
public class Accounts {
    @XmlElement(name="Account")
    private ArrayList<Account> listAccount = new ArrayList<>();

    public Accounts() {
        super();
    }

    public ArrayList<Account> getListAccount() {
        return listAccount;
    }

    public void setListAccount(ArrayList<Account> listAccount) {
        this.listAccount = listAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accounts accounts = (Accounts) o;

        return listAccount != null ? listAccount.equals(accounts.listAccount) : accounts.listAccount == null;

    }

    @Override
    public int hashCode() {
        return listAccount != null ? listAccount.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "listAccount=" + listAccount +
                '}';
    }
}
