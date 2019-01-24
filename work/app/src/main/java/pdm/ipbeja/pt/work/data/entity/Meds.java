package pdm.ipbeja.pt.work.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "meds")
public class Meds {
    @PrimaryKey(autoGenerate = true)
    private long idMed;

    private String name;
    private String dayStart;
    private String monthStart;
    private String yearStart;
    private String numberDaysToTake;
    private String hours;
    private boolean status;
    private String imageURL;

    public Meds(long idMed, String name, String dayStart, String monthStart, String yearStart, String numberDaysToTake, String hours, boolean status, String imageURL) {
        this.idMed = idMed;
        this.name = name;
        this.dayStart = dayStart;
        this.monthStart = monthStart;
        this.yearStart = yearStart;
        this.numberDaysToTake = numberDaysToTake;
        this.hours = hours;
        this.status = status;
        this.imageURL = imageURL;
    }

    public long getIdMed() {
        return idMed;
    }

    public void setIdMed(long idMed) {
        this.idMed = idMed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getMonthStart() {
        return monthStart;
    }

    public void setMonthStart(String monthStart) {
        this.monthStart = monthStart;
    }

    public String getYearStart() {
        return yearStart;
    }

    public void setYearStart(String yearStart) {
        this.yearStart = yearStart;
    }

    public String getNumberDaysToTake() {
        return numberDaysToTake;
    }

    public void setNumberDaysToTake(String numberDaysToTake) {
        this.numberDaysToTake = numberDaysToTake;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }



}
