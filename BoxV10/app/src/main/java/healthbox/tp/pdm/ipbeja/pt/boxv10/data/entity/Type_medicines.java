package healthbox.tp.pdm.ipbeja.pt.boxv10.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Type_medicines")
public class Type_medicines {

    @PrimaryKey
    private long idTypeMed;

    private String typeMedicines;

    private String ShpeMedicines;

    public Type_medicines(long idTypeMed, String typeMedicines, String shpeMedicines) {
        this.idTypeMed = idTypeMed;
        this.typeMedicines = typeMedicines;
        ShpeMedicines = shpeMedicines;
    }

    public long getIdTypeMed() {
        return idTypeMed;
    }

    public void setIdTypeMed(long idTypeMed) {
        this.idTypeMed = idTypeMed;
    }

    public String getTypeMedicines() {
        return typeMedicines;
    }

    public void setTypeMedicines(String typeMedicines) {
        this.typeMedicines = typeMedicines;
    }

    public String getShpeMedicines() {
        return ShpeMedicines;
    }

    public void setShpeMedicines(String shpeMedicines) {
        ShpeMedicines = shpeMedicines;
    }
}
