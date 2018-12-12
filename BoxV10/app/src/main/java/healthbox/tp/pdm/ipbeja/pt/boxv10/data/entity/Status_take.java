package healthbox.tp.pdm.ipbeja.pt.boxv10.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Status_take")
public class Status_take {

    @PrimaryKey
    private  long idStatus;

    private boolean isTaken;

    public Status_take(long idStatus, boolean isTaken) {
        this.idStatus = idStatus;
        this.isTaken = isTaken;
    }

    public long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(long idStatus) {
        this.idStatus = idStatus;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}
