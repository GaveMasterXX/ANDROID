package pdm.ipbeja.pt.chatapp.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;



import java.util.List;

import pdm.ipbeja.pt.chatapp.data.Message;

@Dao
public interface MessageDao {

    @Insert()
    long Insert(Message menssages);


    @Update
    int update(Message menssages);

    @Delete
    int delete(Message menssages);

    @Query("SELECT * from message")
    List<Message> getAllTasks();

    @Query("SELECT * FROM message Where id = :id")
    Message getTask(long id);
}
