package pdm.ipbeja.pt.chatapp.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "message")
public class Message {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private long contactID;
    private String text;

    public Message(long id, long contactID, String text) {
        this.id = id;
        this.contactID = contactID;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContactID() {
        return contactID;
    }

    public void setContactID(long contactID) {
        this.contactID = contactID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
