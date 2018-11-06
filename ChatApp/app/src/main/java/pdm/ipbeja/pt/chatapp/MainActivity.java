package pdm.ipbeja.pt.chatapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pdm.ipbeja.pt.chatapp.data.ChatDatabase;
import pdm.ipbeja.pt.chatapp.data.Contact;

public class MainActivity extends AppCompatActivity {


    private ChatAdpter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.adpter = new ChatAdpter();

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adpter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Contact> allContacts = ChatDatabase.getInstance(this).contactsDao().getAllContacts();
        this.adpter.setData(allContacts);
    }

    public void addNewMessageOnCliked(View view) {
        NewContactActivity.start(this);

    }


    public class ChatViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView text;
        private TextView date;

        public ChatViewHolder(@NonNull View view) {
            super(view);
            this.name = view.findViewById(R.id.chat_name);
            this.text = view.findViewById(R.id.chat_last_text);
            this.date = view.findViewById(R.id.chat_date);
        }

        public void bind(Contact contact){
            this.name.setText(contact.getName());

        }
    }


    public class ChatAdpter extends RecyclerView.Adapter<ChatViewHolder>{

        private List<Contact> data = new ArrayList<>();

        @NonNull
        @Override
        public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_windows, viewGroup, false);
            return new ChatViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ChatViewHolder chatViewHolder, int position) {
            Contact contact = data.get(position);
            chatViewHolder.bind(contact);
        }

        @Override
        public int getItemCount() {
            return this.data.size();
        }

        public void setData(List<Contact> allContacts) {
            this.data = allContacts;
            notifyDataSetChanged();
        }
    }
}
