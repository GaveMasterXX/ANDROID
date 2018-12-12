package pdm.ipbeja.pt.work.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "pharmarcy")
public class Pharmarcy {

    @PrimaryKey (autoGenerate = true)
    private  long idPharmarcy;
    private String name;
    private String address;
    private String timeToOpen;
    private  String contacts;
    private String latitude;
    private  String longitude;

    public Pharmarcy(long idPharmarcy, String name, String address, String timeToOpen, String contacts, String latitude, String longitude) {
        this.idPharmarcy = idPharmarcy;
        this.name = name;
        this.address = address;
        this.timeToOpen = timeToOpen;
        this.contacts = contacts;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getTimeToOpen() {
        return timeToOpen;
    }

    public void setTimeToOpen(String timeToOpen) {
        this.timeToOpen = timeToOpen;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
