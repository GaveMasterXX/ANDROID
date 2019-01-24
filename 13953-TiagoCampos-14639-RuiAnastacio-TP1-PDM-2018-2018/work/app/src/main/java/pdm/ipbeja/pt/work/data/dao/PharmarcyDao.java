package pdm.ipbeja.pt.work.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import pdm.ipbeja.pt.work.data.entity.Pharmarcy;

@Dao
public interface PharmarcyDao {
    @Insert
    long insert(Pharmarcy pharmarcy);

    @Delete
    int delete(Pharmarcy pharmarcy);

    @Query("delete from pharmarcy")
    int deleteAll();

    @Query(("select * from pharmarcy where idPharmarcy = :pharmacyId"))
    Pharmarcy getPharmacy(long pharmacyId);

    @Query("select * from pharmarcy")
    List<Pharmarcy> getAllPharmarcy(); ///procura todos os registos da db
}
