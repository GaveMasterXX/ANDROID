package pdm.ipbeja.pt.chatapp.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import pdm.ipbeja.pt.chatapp.data.Contact;

@Dao
public interface ContactDao {

    @Insert()
    long Insert(Contact contact);


    @Update
    int update(Contact contact);

    @Delete
    int delete(Contact contact);

    @Query("SELECT * from contacts")
    List<Contact> getAllContacts();

    @Query("SELECT * FROM contacts Where id = :id")
    Contact getContact(long id);
}
