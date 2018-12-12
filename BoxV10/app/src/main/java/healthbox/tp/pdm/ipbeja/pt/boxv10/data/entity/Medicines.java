package healthbox.tp.pdm.ipbeja.pt.boxv10.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Medicines", foreignKeys ={
        @ForeignKey( entity = Type_medicines.class, parentColumns = "idTypeMed", childColumns = "idTypeMed", onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
        @ForeignKey( entity = Hour_take.class, parentColumns = "idHourTake", childColumns = "idHourTake", onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
        @ForeignKey( entity = Frequency_take.class, parentColumns = "id", childColumns = "idFrequencyTake", onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
        @ForeignKey( entity = Historic.class, parentColumns = "idHistoric", childColumns = "idHistoric", onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE) })
public class Medicines {

    @PrimaryKey
    private long idMed;

    private String name;

    private long numberMedicines;

    private long idTypeMed;

    private long idHourTake;

    private  long idFrequencyTake;

    private long idHistoric;

    public Medicines(long idMed, String name, long numberMedicines, long idTypeMed, long idHourTake, long idFrequencyTake, long idHistoric) {
        this.idMed = idMed;
        this.name = name;
        this.numberMedicines = numberMedicines;
        this.idTypeMed = idTypeMed;
        this.idHourTake = idHourTake;
        this.idFrequencyTake = idFrequencyTake;
        this.idHistoric = idHistoric;
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

    public long getNumberMedicines() {
        return numberMedicines;
    }

    public void setNumberMedicines(long numberMedicines) {
        this.numberMedicines = numberMedicines;
    }

    public long getIdTypeMed() {
        return idTypeMed;
    }

    public void setIdTypeMed(long idTypeMed) {
        this.idTypeMed = idTypeMed;
    }

    public long getIdHourTake() {
        return idHourTake;
    }

    public void setIdHourTake(long idHourTake) {
        this.idHourTake = idHourTake;
    }

    public long getIdFrequencyTake() {
        return idFrequencyTake;
    }

    public void setIdFrequencyTake(long idFrequencyTake) {
        this.idFrequencyTake = idFrequencyTake;
    }

    public long getIdHistoric() {
        return idHistoric;
    }

    public void setIdHistoric(long idHistoric) {
        this.idHistoric = idHistoric;
    }
}
