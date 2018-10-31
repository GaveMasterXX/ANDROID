package pdm.ipbeja.pt.chatapp.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


import pdm.ipbeja.pt.chatapp.data.dao.ContactDao;
import pdm.ipbeja.pt.chatapp.data.dao.MessageDao;

@Database(entities = {Contact.class, Message.class}, version = 1, exportSchema = false)
public abstract class ChatDatabase extends RoomDatabase {

    private static ChatDatabase instance = null;

    public static ChatDatabase getInstance(Context context){

        context = context.getApplicationContext();

        if(instance == null){
            //criar instanse
            instance = Room.databaseBuilder(context, ChatDatabase.class, "tasks_db")
                    .allowMainThreadQueries()//
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }

    public abstract ContactDao contactosDao();
    public abstract MessageDao messageDao();
}
