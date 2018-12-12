package pdm.ipbeja.pt.chatapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class ChatActivity extends AppCompatActivity {

    public static final String CONTACT_ID = "conatctos";

    private long contactId;

    private RecyclerView messageList;
    private MessagAdapter messagAdapter;

    private EditText messageInput;

    public static void start(Context context, long id) {
        Intent starter = new Intent(context, ChatActivity.class);
        starter.putExtra(CONTACT_ID, id);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        contactId = getIntent().getLongExtra(CONTACT_ID, 0);

        if(contactId == 0){
            finish();
            return;
        }

        messageInput = findViewById(R.id.me)

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete_massages:
                //TODO apagar as msgs do contacto
                return true;
        }
        return super.onOptionsItemSelected(item);
    }





}
