package pdm.ipbeja.pt.work.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "historicLog", foreignKeys = @ForeignKey( entity = Medicines.class, parentColumns = "idMed", childColumns = "idMeds", onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE))
public class HistoricLog {

    @PrimaryKey(autoGenerate = true)
    private long idLog;
    private long idMeds;
    private String hourLog;
    private String dayLog;
    private String monthLog;
    private String yearLog;
    private String status;

    public HistoricLog(long idLog, long idMeds, String hourLog, String dayLog, String monthLog, String yearLog, String status) {
        this.idLog = idLog;
        this.idMeds = idMeds;
        this.hourLog = hourLog;
        this.dayLog = dayLog;
        this.monthLog = monthLog;
        this.yearLog = yearLog;
        this.status = status;
    }

    public long getIdLog() {
        return idLog;
    }

    public void setIdLog(long idLog) {
        this.idLog = idLog;
    }

    public long getIdMeds() {
        return idMeds;
    }

    public void setIdMeds(long idMeds) {
        this.idMeds = idMeds;
    }

    public String getHourLog() {
        return hourLog;
    }

    public void setHourLog(String hourLog) {
        this.hourLog = hourLog;
    }

    public String getDayLog() {
        return dayLog;
    }

    public void setDayLog(String dayLog) {
        this.dayLog = dayLog;
    }

    public String getMonthLog() {
        return monthLog;
    }

    public void setMonthLog(String monthLog) {
        this.monthLog = monthLog;
    }

    public String getYearLog() {
        return yearLog;
    }

    public void setYearLog(String yearLog) {
        this.yearLog = yearLog;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
