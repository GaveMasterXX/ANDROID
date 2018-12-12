package healthbox.tp.pdm.ipbeja.pt.boxv10.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Frequency_take")
public class Frequency_take {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private long durationTake;


    public Frequency_take(long id, long duartionTake) {
    this.id = id;
    this.durationTake = duartionTake;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDurationTake() {
        return durationTake;
    }

    public void setDurationTake(long durationTake) {
        this.durationTake = durationTake;
    }

}
