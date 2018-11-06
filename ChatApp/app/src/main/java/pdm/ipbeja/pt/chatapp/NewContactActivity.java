package pdm.ipbeja.pt.chatapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pdm.ipbeja.pt.chatapp.data.ChatDatabase;
import pdm.ipbeja.pt.chatapp.data.Contact;
import pdm.ipbeja.pt.chatapp.data.dao.ContactDao;

public class NewContactActivity extends AppCompatActivity {

    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        this.name = findViewById(R.id.contact_name);

    }

        public static void start(Context context) {
            Intent starter = new Intent(context, NewContactActivity.class);
            context.startActivity(starter);
        }

    public void onCreateContactClicked(View view) {
        String name = this.name.getText().toString();

        Contact contact = new Contact(0,name);
        ChatDatabase.getInstance(this).contactsDao().Insert(contact);
    }


}
