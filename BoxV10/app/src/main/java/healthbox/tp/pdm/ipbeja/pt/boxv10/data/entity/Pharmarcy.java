package healthbox.tp.pdm.ipbeja.pt.boxv10.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "pharmarcy")
public class Pharmarcy{

    @PrimaryKey (autoGenerate = true)
    private  long idPharmarcy;

    private String name;

    private String address;

    private String HourOfWork;

    private  String contacts;


    public Pharmarcy(long idPharmarcy, String name, String address, String hourOfWork, String contacts) {
        this.idPharmarcy = idPharmarcy;
        this.name = name;
        this.address = address;
        HourOfWork = hourOfWork;
        this.contacts = contacts;
    }

    public long getIdPharmarcy() {
        return idPharmarcy;
    }

    public void setIdPharmarcy(long idPharmarcy) {
        this.idPharmarcy = idPharmarcy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHourOfWork() {
        return HourOfWork;
    }

    public void setHourOfWork(String hourOfWork) {
        HourOfWork = hourOfWork;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
