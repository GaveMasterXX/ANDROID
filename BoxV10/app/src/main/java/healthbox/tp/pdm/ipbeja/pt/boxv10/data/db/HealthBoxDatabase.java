package healthbox.tp.pdm.ipbeja.pt.boxv10.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import healthbox.tp.pdm.ipbeja.pt.boxv10.data.dao.PharmarcyDao;
import healthbox.tp.pdm.ipbeja.pt.boxv10.data.entity.Pharmarcy;


@Database(entities = {Pharmarcy.class/*, Medicines.class, Frequency_take.class, Hour_take.class,
        Status_take.class, Type_medicines.class, Historic.class, Type_medicines.class*/}, version = 3, exportSchema = false)
public abstract class HealthBoxDatabase extends RoomDatabase {

    private static HealthBoxDatabase instance;

    public static HealthBoxDatabase getInstance(Context context) {
        context = context.getApplicationContext();
        if(instance == null){
            instance = Room.databaseBuilder(context, HealthBoxDatabase.class, "healthBod_db")
                    .addMigrations()
                    .allowMainThreadQueries()
                    //.fallbackToDestructiveMigration() //TODO o porque de esta funcao estar comentada???
                    .build();
        }
        return instance;
    }

    public abstract PharmarcyDao pharmarcyDao();

   /* public  abstract MedicinesDao medicinesDao();

    public abstract Frequency_takeDao frequency_takeDao();

    public abstract Hour_takeDao hour_takeDao();

    public abstract Status_takeDao status_takeDao();

    public abstract HistoricDao historicDao();

    public  abstract Type_medicinesDao type_medicinesDao();*/


    // -------------- MIGRATIONS -----------------------
}
