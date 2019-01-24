package pdm.ipbeja.pt.work.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "medicines")
public class Medicines {

    @PrimaryKey(autoGenerate = true)
    private long idMed;
    private String name;
    private String typeMed;
    private String dayStart;
    private String monthStart;
    private String yearStart;
    private String numberDaysOfTake;

    public Medicines(long idMed, String name, String typeMed, String dayStart, String monthStart, String yearStart, String numberDaysOfTake) {
        this.idMed = idMed;
        this.name = name;
        this.typeMed = typeMed;
        this.dayStart = dayStart;
        this.monthStart = monthStart;
        this.yearStart = yearStart;
        this.numberDaysOfTake = numberDaysOfTake;
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

    public String getTypeMed() {
        return typeMed;
    }

    public void setTypeMed(String typeMed) {
        this.typeMed = typeMed;
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

    public String getNumberDaysOfTake() {
        return numberDaysOfTake;
    }

    public void setNumberDaysOfTake(String numberDaysOfTake) {
        this.numberDaysOfTake = numberDaysOfTake;
    }
}
