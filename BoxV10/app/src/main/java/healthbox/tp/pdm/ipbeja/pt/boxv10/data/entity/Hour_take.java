package healthbox.tp.pdm.ipbeja.pt.boxv10.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Hour_take")
public class Hour_take {

    @PrimaryKey
    private long idHourTake;

    private String HourTake;

    private String DateTake;

    public Hour_take(long idHourTake, String hourTake, String dateTake) {
        this.idHourTake = idHourTake;
        HourTake = hourTake;
        DateTake = dateTake;
    }

    public long getIdHourTake() {
        return idHourTake;
    }

    public void setIdHourTake(long idHourTake) {
        this.idHourTake = idHourTake;
    }

    public String getHourTake() {
        return HourTake;
    }

    public void setHourTake(String hourTake) {
        HourTake = hourTake;
    }

    public String getDateTake() {
        return DateTake;
    }

    public void setDateTake(String dateTake) {
        DateTake = dateTake;
    }
}
