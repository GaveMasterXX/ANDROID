package pdm.ipbeja.pt.work.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import pdm.ipbeja.pt.work.data.dao.MedsDao;
import pdm.ipbeja.pt.work.data.entity.Meds;

@Database(entities = { Meds.class}, version = 1, exportSchema = false)
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

    public abstract MedsDao medsDao();


}
