package pdm.ipbeja.pt.work.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import pdm.ipbeja.pt.work.data.entity.Meds;

@Dao
public interface MedsDao {

    @Insert
    long insert(Meds meds);

    @Query("select * from meds")
    List<Meds> getAllMedicines();

    @Query("select * from meds where idMed = :idMed")
    Meds getId(long idMed);

   // @Query("UPDATE meds SET status = :status WHERE idMed = :id")
    //Meds updateStatus(long id, boolean status);

}
