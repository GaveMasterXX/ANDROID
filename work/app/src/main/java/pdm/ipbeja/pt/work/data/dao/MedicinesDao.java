package pdm.ipbeja.pt.work.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import pdm.ipbeja.pt.work.data.entity.Medicines;

@Dao
public interface MedicinesDao {

    @Insert
    long insert(Medicines medicines);

    @Query("select * from medicines")
    List<Medicines>getMedicines();

    @Query("select * from medicines where idMed = :idMed")
    Medicines getMedicines(long idMed);

}
