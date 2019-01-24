package pdm.ipbeja.pt.work.data.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import pdm.ipbeja.pt.work.data.dao.HistoricLogDao;
import pdm.ipbeja.pt.work.data.dao.MedicinesDao;
import pdm.ipbeja.pt.work.data.dao.PharmarcyDao;
import pdm.ipbeja.pt.work.data.entity.HistoricLog;
import pdm.ipbeja.pt.work.data.entity.Medicines;
import pdm.ipbeja.pt.work.data.entity.Pharmarcy;

@Database(entities = {Pharmarcy.class, Medicines.class, HistoricLog.class}, version = 1, exportSchema = false)
public abstract class HealthBoxDatabase extends RoomDatabase {

    private static HealthBoxDatabase instance;

    public static HealthBoxDatabase getInstance(Context context) {
        context = context.getApplicationContext();
        if(instance == null){
            instance = Room.databaseBuilder(context, HealthBoxDatabase.class, "healthBox_db")
                   // .addMigrations()
                    .allowMainThreadQueries()
                    //.fallbackToDestructiveMigration() //TODO o porque de esta funcao estar comentada???
                    .build();
        }
        return instance;
    }

    public abstract PharmarcyDao pharmarcyDao();
    public abstract MedicinesDao medicinesDao();
    public abstract HistoricLogDao historicLogDao();


    // -------------- MIGRATIONS -----------------------

}
