package healthbox.tp.pdm.ipbeja.pt.boxv10.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Historic", foreignKeys =  @ForeignKey( entity = Status_take.class, parentColumns = "idStatus", childColumns = "idStatus", onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE))
public class Historic {

    @PrimaryKey
    private long idHistoric;

    private long idStatus;

    public Historic(long idHistoric, long idStatus) {
        this.idHistoric = idHistoric;
        this.idStatus = idStatus;
    }

    public long getIdHistoric() {
        return idHistoric;
    }

    public void setIdHistoric(long idHistoric) {
        this.idHistoric = idHistoric;
    }

    public long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(long idStatus) {
        this.idStatus = idStatus;
    }
}
